import java.awt.image.BufferedImage;

/*
 * Inanimate Object is an abstract class that extends Sprite
 * This abstract class is for the inanimate sprites that we will pull from the sprite sheet
 */

abstract class InanimateObject extends Sprite
{  
   public enum typeOfNonAnimated { BORDERS, CIRCLES, FRUITS , BLACKSQAURE }
   
   typeOfNonAnimated nonAnimatedType;
   
   protected abstract void setImage(BufferedImage aImage);
   protected abstract BufferedImage getImage();
   protected abstract boolean assessCollision();
   protected abstract void setTypeOfNonAnimated();
   protected void setAnimation()
   {
      typeOfAnimation = Animation.INANIMATE;
   }
}

/*
 * Class for all the border sub-images we will pull
 * It will assign similar characteristics  to each border object
 */
class Borders extends InanimateObject
{     
   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }
   
   @Override
   protected BufferedImage getImage()
   {
      return image;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = false;
      return collision;
   }

   @Override
   protected void setTypeOfNonAnimated()
   {
      nonAnimatedType = typeOfNonAnimated.BORDERS;
   }
   
}

/*
 * Class for all the BlackSqaure image
 */

class BlackSqaure extends InanimateObject
{

   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }
   
   @Override
   protected BufferedImage getImage()
   {
      return image;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = true;
      return collision;
   }

   @Override
   protected void setTypeOfNonAnimated()
   {
      nonAnimatedType = typeOfNonAnimated.BLACKSQAURE;
   }
   
}

/*
 * Class for all the Circle image
 */

class Circles extends InanimateObject
{
   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }
   
   @Override
   protected BufferedImage getImage()
   {
      return image;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = true;
      return collision;
   }

   @Override
   protected void setTypeOfNonAnimated()
   {
      nonAnimatedType = typeOfNonAnimated.CIRCLES;
   }
}

/*
 * Class for all the Fruits we will pull from the sprite sheet
 * It will assign similar characteristics  to each Fruit object
 */

class Fruits extends InanimateObject
{
   @Override
   protected void setImage(BufferedImage aImage)
   {
      this.image = aImage;
   }
   
   public BufferedImage getImage()
   {
      return image;
   }

   @Override
   protected boolean assessCollision()
   {
      collision = true;
      return collision;
   }

   @Override
   protected void setTypeOfNonAnimated()
   {
      nonAnimatedType = typeOfNonAnimated.FRUITS;
   }
}
