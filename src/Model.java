// The model updates the data of the game
public class Model
{  
   // Data members
   SetGameUp myGame = null;
   
   // Default constructor that intializes myGame
   Model()
   {
      myGame = new SetGameUp();
   }
   
   // Puts a specific thread to sleep for a specific amount of time
   public void doNothing(int milliseconds)
   {
      try
      {
         Thread.sleep(milliseconds);
      }
      catch (InterruptedException e)
      {
         System.out.println("Unexpected interrupt");
         System.exit(0);
      }
   }   
   
   // Function that changes the images of pacman to give the illusion of animation
   public void animatePacman(int column)
   {
      myGame.mySprite[myGame.pacManIndex].setImage(myGame.spriteSheet.pacManList.get(column));
      doNothing(75);
   }
   
   // Function that removes Pacman from a specific position
   // This function is needed as pacman moves across different position
   public int removePacman()
   {
      myGame.edibleCircleArray[myGame.pacManIndex] = false;
      myGame.mySprite[myGame.pacManIndex] = new BlackSqaure();
      myGame.mySprite[myGame.pacManIndex].setImage(myGame.spriteSheet.blackSquareList.get(0));
      return myGame.pacManIndex;
   }
   
   // Function that adds pacman to a specific position
   // This function is needed as pacman moves across different position
   public int addNewPacman(int direction, int index)
   {
      myGame.pacManIndex = myGame.pacManIndex + direction;
      
      myGame.mySprite[myGame.pacManIndex] = new Pacman();
      myGame.mySprite[myGame.pacManIndex].setImage(myGame.spriteSheet.pacManList.get(index));
      return myGame.pacManIndex;
   }
   
   // Function that removes the ghosts from their various positions
   // This function is needed as ghosts moves across different position
   public void removeGhosts()
   {
      for (int i = 0; i < 4; i++)
      {  
         if (myGame.edibleCircleArray[myGame.postionOfGhosts[i]] == false)
         {
            myGame.mySprite[myGame.postionOfGhosts[i]] = new BlackSqaure();
            myGame.mySprite[myGame.postionOfGhosts[i]].setImage(myGame.spriteSheet.blackSquareList.get(0));
         }
         else
         {
            myGame.mySprite[myGame.postionOfGhosts[i]] = new Circles();
            myGame.mySprite[myGame.postionOfGhosts[i]].setImage(myGame.spriteSheet.edibleCircleList.get(0));
         }
      }
   }
   
   // Function that adds news ghosts to their various positions
   // This function is needed as ghosts moves across different position
   public void addNewGhosts(int direction, int indexOfGhostImage)
   {
      for (int i = 0; i < 4; i++)
      {
         myGame.postionOfGhosts[i] = myGame.postionOfGhosts[i] + direction;
         
         myGame.mySprite[myGame.postionOfGhosts[i]] = new Ghosts();
         myGame.mySprite[myGame.postionOfGhosts[i]].setImage(myGame.spriteSheet.ghostList.get(indexOfGhostImage));
      }
   }
   
   // Function that determines the score and returns it as an int
   // Called from the controller
   // Score is based on how many circles pacman has easten
   public int determineScore()
   {
      int score = -169;
      
      for (int i = 0; i < myGame.edibleCircleArray.length; i++)
         if (myGame.edibleCircleArray[i] == false)
            score++;
      return score;
   }
   
   // Increments the seconds
   public int incrementSeconds(int seconds)
   {
      seconds++;
      doNothing(1000);
      return seconds;
   }
   
   // Determines if pacman and a ghost collided
   // If they did, it returns true to indicate that the user lost
   // Otherwise, it returns false so the game keeps going
   public boolean determineIfLost()
   {
      for (int i = 0; i < myGame.postionOfGhosts.length; i++)
         if (myGame.postionOfGhosts[i] == myGame.pacManIndex)
            return true;
      return false;
   }
   
}