import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * This program implements an MVC Design Pattern
 * The class below belongs to the controller
 * It will coordinate between the View and the Model
 */

public class Controller
{
   // data members
   Model model;
   View view;
   int directionOfPacman;
   boolean moveRight;
   boolean moveLeft;
   boolean moveDown;
   boolean moveUp;
   Animate animation = null;
   Timer timerThread = null;

   // default constructor
   // Creates the frames, and adds a keyListener to the game
   Controller(Model aModel, View aView)
   {
      model = aModel;
      view = aView;
      view.timerAndScoreFrame(0, 0);
      view.createMaze(model.myGame);
      view.maze.addKeyListener(new KeyPressed());
   }
   
   // Class that implements KeyListener
   class KeyPressed implements KeyListener 
   {

      @Override
      public void keyTyped(KeyEvent e)
      {  
      }

      @Override
      public void keyPressed(KeyEvent e)
      {
         // Whenever we press any key, then the timer should start
         if (timerThread == null)
         {
            timerThread = new Timer();
            timerThread.start();
         }
         
         // Pacman should move only when we press the right, down, up, and left key
         // Depending on the key we press, we will indicate which direction pacman should move in
         
         // We might need to stop the previous animation thread before starting a new one
         // Thats what createOrStopAnimation does
         if (e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            directionOfPacman = 1;
            createOrStopAnimation();
            animation.start();
         }
         
         else if (e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            directionOfPacman = -1;
            createOrStopAnimation();
            animation.start();
         }
         
         else if (e.getKeyCode() == KeyEvent.VK_UP)
         {
            directionOfPacman = -16;
            createOrStopAnimation();
            animation.start();
         }
         
         else if (e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            directionOfPacman = 16;
            createOrStopAnimation();
            animation.start();
         }
      }

      @Override
      public void keyReleased(KeyEvent e)
      {         
      }
      
      // If we haven't created an animation, then we should create one and start it
      // Otherwise, if we have, we need to stop the previous animation thread before starting it
      public void createOrStopAnimation()
      {
         if (animation == null)
            animation = new Animate();
         else
         {
            animation.stop();
            animation = new Animate();
         }
      }
      
   }
   
   // Animate class is the class responsible for all animations on the screen
   // It extends Thread because the animation runs its own thread
   
   // futureIndex determines the position that pacman is trying to move in
   // If we can move into that position, then we will animate Pacman, move pacman, and animate the ghosts
   // If pacman can't move into that position, then we will only animate the pacman and ghosts, without moving pacman 
   class Animate extends Thread
   {  
      public void run()
      {         
         int futureIndex = model.myGame.pacManIndex + directionOfPacman;
         while (model.myGame.mySprite[futureIndex].assessCollision() == true)
         {
            animatePacman(directionOfPacman);
            movePacman(directionOfPacman, whichPacmanImage());
            futureIndex = model.myGame.pacManIndex + directionOfPacman;
            
            if (model.determineIfLost())
               youLost(this);
            animateGhosts();
            if (model.determineIfLost())
               youLost(this);
            
            view.timerAndScoreFrame(determineScore(), timerThread.seconds);
            view.updatePacman(model.myGame);
         }
         while (model.myGame.mySprite[futureIndex].assessCollision() == false)
         {
            animatePacman(directionOfPacman);
            animateGhosts();
            if (model.determineIfLost())
               youLost(this);
            view.timerAndScoreFrame(determineScore(), timerThread.seconds);
            view.updatePacman(model.myGame);
         }
      }  
   }
   
   // function that animates pacman
   // Will call relevant functions in the model and the view to upate the data and the screen
   public void animatePacman(int directionOfPacman)
   {
      int index = whichPacmanImage();
      
      for (int i = index; i < index + 2; i++)
      {
         model.animatePacman(i);
         view.updatePacman(model.myGame);
      }
      model.animatePacman(8);
      view.updatePacman(model.myGame);
      model.doNothing(25);
   }
   
   // whichPacmanImage determines which index we should use within the pacman ImageBuffer arrayList
   public int whichPacmanImage()
   {
      int index;
      
      if (directionOfPacman == 1)
         return index = 0;
      else if (directionOfPacman == -1)
         return index = 2;
      else if (directionOfPacman == -16)
         return index = 4;
      else
          return index = 6;
   }
   
   // Function that moves pacman across the screen
   // It will call functions in the model and the view to update the data and the screen
   public void movePacman(int directionOfPacman, int whichPacmanImage)
   {
      model.removePacman();
      view.updatePacman(model.myGame);
      model.addNewPacman(directionOfPacman, whichPacmanImage);
      view.updatePacman(model.myGame);
   }
   
   // Function that moves the ghosts and animates them
   // It will call functions in the model and the view to update the data and the screen
   // The ghosts will move in a loop
   public void animateGhosts()
   {
      int directionOfMove;
      int indexOfGhostImage;
      
      determineFutureMovementAndImage();
      model.removeGhosts();
      view.updateGhosts(model.myGame);
      
      if (moveRight)
         model.addNewGhosts(directionOfMove = 1, indexOfGhostImage = 0);
      else if (moveDown)
         model.addNewGhosts(directionOfMove = 16, indexOfGhostImage = 3);
      else if (moveLeft)
         model.addNewGhosts(directionOfMove = -1, indexOfGhostImage = 1);
      else if (moveUp)
         model.addNewGhosts(directionOfMove = -16, indexOfGhostImage = 2);
      
      view.updateGhosts(model.myGame);
   }
   
   // Function that determines in which direction the ghosts should move
   // It relies on knowing the position of a ghost an any given time
   // To know the position, it will pull it from myGame.positionOfGhosts array
   public void determineFutureMovementAndImage()
   {
      if (model.myGame.postionOfGhosts[0] == 17)
      {
         moveUp = false;
         moveRight = true;
      }
      else if (model.myGame.postionOfGhosts[0] == 22)
      {
         moveRight = false;
         moveDown = true;
      }
      else if (model.myGame.postionOfGhosts[0] == 86)
      {
         moveDown = false;
         moveLeft = true;
      }
      else if (model.myGame.postionOfGhosts[0] == 81)
      {
         moveLeft = false;
         moveUp = true;
      }
   }
   
   // Function that updates the view to reflect that you lost
   public void youLost(Animate myAnimation)
   {
      view.youLostFrame();
      myAnimation.stop();
   }
   
   // Function that determines the score
   // The score is based on how many edible arrays pacman has eaten
   public int determineScore()
   {
      int score = model.determineScore();
      if (score == 87)
      {
         view.youWonFrame();
         animation.stop();
      }
      return score;
   }
   
   // Class for the timer
   // It extends Thread because the timer will run on its own thread
   private class Timer extends Thread
   {
      int seconds;
      public void run()
      {
         while (!model.determineIfLost() && determineScore() != 86)
            seconds = model.incrementSeconds(seconds);
      }
   }
}


