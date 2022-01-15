import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// View updates the view of the screen

public class View extends JFrame
{   
   // Data members
   JFrame scoreFrame = null;
   JLabel scoreLabel = null;
   JLabel timeLabel = null;
   JFrame maze = null;
   GridBagLayout layout = null;
   GridBagConstraints gbc = null;
   ImageIcon [] tempIcons = null;
   JLabel [] tempLabels = null;
   JPanel[] panel = null;
   
   // Function that creates the intial maze
   public void createMaze(SetGameUp myGame)
   {
      layout = new GridBagLayout();
      gbc = new GridBagConstraints();
      tempIcons = new ImageIcon[16*16];
      tempLabels = new JLabel[16*16];
      panel = new JPanel[16*16];
      maze = new JFrame();
      
      gbc.gridheight = 50;
      gbc.gridwidth = 50;
      gbc.gridx = 0;
      gbc.gridy = 0;
      
      maze.setLayout(layout);
      maze.setSize(800, 825);
      
      
      for (int i = 0; i < tempIcons.length; i++)
      {
         tempIcons[i] = new ImageIcon(myGame.mySprite[i].image);
         tempLabels[i] = new JLabel(tempIcons[i]);
         panel[i] = new JPanel();
         panel[i].setLayout(layout);
         panel[i].add(tempLabels[i], gbc);
         maze.add(panel[i], gbc);
         gbc.gridx+=50;
         if (gbc.gridx == 800)
         {
            gbc.gridx = 0;
            gbc.gridy += 50;
         }
      }
      
      maze.setVisible(true);
      maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   // Function that updates the screen to reflect the current position of pacman
   public void updatePacman(SetGameUp myGame)
   {
      gbc.gridx = (myGame.pacManIndex % 16) * 50;
      gbc.gridy = (myGame.pacManIndex / 16) * 50;
      
      ImageIcon tempIcon = new ImageIcon(myGame.mySprite[myGame.pacManIndex].image);
      JLabel tempLabel = new JLabel(tempIcon);
      panel[myGame.pacManIndex].removeAll();
      panel[myGame.pacManIndex].add(tempLabel, gbc);
      maze.setVisible(true);
   }
   
   // Function that update the screen to reflect the current positions of the ghosts
   public void updateGhosts(SetGameUp myGame)
   {
      for (int i = 0; i < 4; i++)
      {
         gbc.gridx = (myGame.postionOfGhosts[i] % 16) * 50;
         gbc.gridy = (myGame.postionOfGhosts[i] / 16) * 50;
         
         ImageIcon tempIcon = new ImageIcon(myGame.mySprite[myGame.postionOfGhosts[i]].image);
         JLabel tempLabel = new JLabel(tempIcon);
         panel[myGame.postionOfGhosts[i]].removeAll();
         panel[myGame.postionOfGhosts[i]].add(tempLabel, gbc);
         maze.add(panel[myGame.postionOfGhosts[i]], gbc);
         maze.setVisible(true);
      }
   }
   
   // Function that creates a JFrame to indicate that you lost
   public void youLostFrame()
   {
      JLabel lostLabel = new JLabel("You lost", JLabel.CENTER);
      JFrame lostFrame = new JFrame();
      
      lostFrame.add(lostLabel, JLabel.CENTER);
      lostFrame.setSize(400, 100);
      lostFrame.setLocationRelativeTo(null);
      lostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      lostFrame.setVisible(true);
   }
   
   // Function that creates a JFrame to indicate that you won
   public void youWonFrame()
   {
      JLabel lostLabel = new JLabel("You won", JLabel.CENTER);
      JFrame lostFrame = new JFrame();
      
      lostFrame.add(lostLabel, JLabel.CENTER);
      lostFrame.setSize(400, 100);
      lostFrame.setLocationRelativeTo(null);
      lostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      lostFrame.setVisible(true);
   }
   
   // Function that creates and updates the timer and the score JFrame
   public void timerAndScoreFrame(int score, int seconds)
   {
      if (scoreFrame == null)
      {
         scoreFrame = new JFrame("Score Frame");
         scoreFrame.setLayout(new GridLayout(2,1));
         scoreLabel = new JLabel("Score is: " + String.valueOf(score), JLabel.CENTER);
         timeLabel = new JLabel("Timer is: " + String.valueOf(seconds), JLabel.CENTER);
      }
      
      scoreLabel.setText("Score is: " + String.valueOf(score));
      timeLabel.setText("Timer is: " + String.valueOf(seconds));
      scoreFrame.add(timeLabel, JLabel.CENTER);
      scoreFrame.add(scoreLabel, JLabel.CENTER);
      scoreFrame.setSize(400, 100);
      scoreFrame.setLocation(800,0);
      scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      scoreFrame.setVisible(true);
   }
}
