import java.awt.image.BufferedImage;

/*
 * AnimatedObject is a class that extends Sprite
 * This abstract class is for the animate sprites that we will pull from the sprite sheet
 */

 abstract class AnimatedObject extends Sprite
{
   public enum typeOfAnimated { PACMAN, GHOSTS }
   
   typeOfAnimated animatedType;
   
   protected abstract void setImage(BufferedImage aImage);
   protected abstract BufferedImage getImage();
   protected abstract boolean assessCollision();
   protected abstract void setTypeOfAnimated();
   protected void setAnimation()
   {
      typeOfAnimation = Animation.ANIMATE;
   } 
}

 /*
  * Class for all the pacman sub-images we will pull
  * It will assign similar characteristics  to each pacman object
  */
 
class Pacman extends AnimatedObject
{
   @Override
   protected BufferedImage getImage()
   {
      return image;
   }
   
   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = true;
      return collision;
   }
   
   @Override
   protected void setTypeOfAnimated()
   {
      animatedType = typeOfAnimated.PACMAN;
   }
}

/*
 * Class for all the ghosts sub-images we will pull
 * It will assign similar characteristics to each ghosts object
 */

class Ghosts extends AnimatedObject
{
   @Override
   protected BufferedImage getImage()
   {
      return image;
   }
   
   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = true;
      return collision;
   }

   @Override
   protected void setTypeOfAnimated()
   {
      animatedType = typeOfAnimated.GHOSTS;
   }
}
