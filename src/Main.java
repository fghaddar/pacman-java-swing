import java.awt.image.*;
import javax.swing.*;


/*
 * Abstract class for each sprite that we pull from the sprite sheet
 */
abstract class Sprite
{
   public enum Animation { INANIMATE, ANIMATE }
   
   BufferedImage image;
   boolean collision;
   Animation typeOfAnimation;
   
   protected abstract void setImage(BufferedImage aImage);
   protected abstract BufferedImage getImage();
   protected abstract boolean assessCollision();
   protected abstract void setAnimation();
}

/*
 * class Main that runs main
 */
public class Main
{
   public static void main(String[] args)
   {
      Model model  = new Model(); 
      View view = new View();
      Controller controller = new Controller (model, view);
   }
}