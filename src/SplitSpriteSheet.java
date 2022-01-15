import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

// This class will split the sprite sheet and attach sub-images into specific lists

public class SplitSpriteSheet
{  
   // Data members
   ArrayList<BufferedImage> borderList;
   ArrayList<BufferedImage> pacManList;
   ArrayList<BufferedImage> ghostList;
   ArrayList<BufferedImage> fruitList;
   ArrayList<BufferedImage> edibleCircleList;
   ArrayList<BufferedImage> blackSquareList;
   
   // Default consturctor 
   SplitSpriteSheet()
   {
      getBorders();
      getPacman();
      getGhosts();
      getFruits();
      getEdibleCircle();
      getBlackSquare();
   }
   
   // Loop that gets the subimages from the various spritesheets
   public ArrayList<BufferedImage> getImages(ArrayList<BufferedImage> returnList, int startX, int endX, 
         int startY, int endY, int moveX, int movY, int imageSize, String filname)
   {      
      try
      {
         BufferedImage spriteSheet = ImageIO.read(new File(filname));
         for (int heightCounter = startY; heightCounter <= endY; heightCounter+=movY)
            for (int widthCounter = startX; widthCounter <= endX; widthCounter+=moveX)
            {
               BufferedImage preSizedImage = spriteSheet.getSubimage(widthCounter, heightCounter, imageSize, imageSize);
               BufferedImage postSizedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);     
               Graphics2D g2d = postSizedImage.createGraphics();
               g2d.drawImage(preSizedImage, 0, 0, 50, 50, null);
               g2d.dispose();
               returnList.add(postSizedImage);
            }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
      return returnList;
   }
   
   // Function that specifis where the borders are within the spritesheet
   // Calls the loop to retrieve those images
   public ArrayList<BufferedImage>  getBorders()
   {
      int startWidth = 225;
      int endWidth = 360;
      int startHeight = 54;
      int endHeight = 72;
      int imageSize = 8;
      int movX = 9;
      int movY = 9;
      String filname = "Sprites/Maze/Maze.png";
      borderList = new ArrayList<BufferedImage>();
      
      borderList = getImages (borderList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);
      
      int lastIndex = borderList.size() - 4;
      for (int i = borderList.size() - 1; i >= lastIndex; i--)
         borderList.remove(i);
         
      return borderList;
   }
   
   // Function that specifis where the pacmans are within the spritesheet
   // Calls the loop to rerieve those images
   public ArrayList<BufferedImage> getPacman()
   {
      int startWidth = 457;
      int endWidth = 473;  // Don't forget full circled PacMan
      int startHeight = 1;
      int endHeight = 49;
      int imageSize = 13;
      int movX = 16;
      int movY = 16;
      String filname = "Sprites/General/General.png";
      pacManList = new ArrayList<BufferedImage>();
      
      pacManList = getImages (pacManList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);
      
      // For the full circled PacMan
      try
      {
         BufferedImage spriteSheet = ImageIO.read(new File(filname));
         BufferedImage preSizedImage = spriteSheet.getSubimage(endWidth + movX, startHeight, imageSize, imageSize);
         BufferedImage postSizedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);     
         Graphics2D g2d = postSizedImage.createGraphics();
         g2d.drawImage(preSizedImage, 0, 0, 50, 50, null);
         g2d.dispose();
         pacManList.add(postSizedImage);
      } 
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
      return pacManList;
   }
   
   // Function that specifis where the ghosts are within the spritesheet
   // Calls the loop to rerieve those images
   public ArrayList<BufferedImage> getGhosts()
   {
      int startWidth = 457;
      int endWidth = 569; // don't forget dead ghost
      int startHeight = 65;
      int endHeight = 113;
      int imageSize = 14;
      int movX = 32;
      int movY = 16;
      String filname = "Sprites/General/General.png";
      ghostList = new ArrayList<BufferedImage>();
      
      ghostList = getImages (ghostList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);

      
      // For the dead ghosts
      try
      {
         BufferedImage spriteSheet = ImageIO.read(new File(filname));
         BufferedImage preSizedImage = spriteSheet.getSubimage(endWidth + movX, startHeight, imageSize, imageSize);
         BufferedImage postSizedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);     
         Graphics2D g2d = postSizedImage.createGraphics();
         g2d.drawImage(preSizedImage, 0, 0, 50, 50, null);
         g2d.dispose();
         ghostList.add(postSizedImage);
         
      } 
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
      return ghostList;
   }
   
   // Function that specifis where the fruits are within the spritesheet
   // Calls the loop to retrieve those images
   public ArrayList<BufferedImage> getFruits()
   {
      int startWidth = 489;
      int endWidth = 537; 
      int startHeight = 49;
      int endHeight = 49;
      int imageSize = 13;
      int movX = 16;
      int movY = 16;
      String filname = "Sprites/General/General.png";
      fruitList = new ArrayList<BufferedImage>();
      
      fruitList = getImages (fruitList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);
      
      return fruitList;
   }
   
   // Function that specifis where the circle image is within the spritesheet
   // Calls the loop to retrieve that image
   public BufferedImage getEdibleCircle()
   {
      int startWidth = 342;
      int endWidth = 342;
      int startHeight = 72;
      int endHeight = 72;
      int imageSize = 8;
      int movX = 9;
      int movY = 9;
      String filname = "Sprites/Maze/Maze.png";
      edibleCircleList = new ArrayList<BufferedImage>();

      edibleCircleList = getImages (edibleCircleList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);
      
      return edibleCircleList.get(0);
   }
   
   // Function that specifis where the circle image is within the spritesheet
   // Calls the loop to retrieve that image
   public BufferedImage getBlackSquare()
   {
      int startWidth = 333;
      int endWidth = 333;
      int startHeight = 72;
      int endHeight = 72;
      int imageSize = 8;
      int movX = 9;
      int movY = 9;
      String filname = "Sprites/Maze/Maze.png";
      blackSquareList = new ArrayList<BufferedImage>();

      blackSquareList = getImages (blackSquareList, startWidth, endWidth, startHeight, endHeight, movX, movY, imageSize, filname);
      
      return blackSquareList.get(0);
   }
}
