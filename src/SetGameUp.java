// SetGameUp is a game that sets the backend of the game
// The game reolves around the use of the mySprite array
// Various images and various Sprite Objects will be assigned to each elemment within mySprite

public class SetGameUp
{
   // Data Members
   Sprite[] mySprite;
   int pacManIndex;
   int [] postionOfGhosts;
   boolean [] edibleCircleArray;
   SplitSpriteSheet spriteSheet;

   // Default constructor
   // Intializes mySprite, edibleCircleArray, and splits the spritesheet
   SetGameUp()
   {
      mySprite = new Sprite[16*16];
      edibleCircleArray = new boolean[16*16];
      spriteSheet = new SplitSpriteSheet();
      setRowsUp();
      getGhostsIndex();
      createEdibleCircleArray();
   }
   
   // Calls the function that set specific rows of the game
   // Assigns specific [row, column] characterstic to each element in mySprite
   public void setRowsUp()
   {
      firstRow();
      secondRow();
      thirdRow();
      fourthRow();
      fifthRow();
      sixthRow();
      seventhRow();
      eightRow();
      ninthRow();
      tenthRow();
      eleventhRow();
      rowTwelve();
      rowThirteen();
      rowFourteen();
      rowFifteen();
      rowSixteen();
   }
   
   // For the first row of the maze
   public void firstRow()
   {
      int counter = 0;
      for (int i = 0; i < 16; i++)
      {  
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(1));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(0));
         }
         else
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(10));
         }
         counter+= 50;
      }
   }
      
   // For the second row of the maze
   public void secondRow()
   {  
      int counter = 0;
      for (int i = 16; i < 32; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 50 || counter == 450)
         {
            mySprite[i] = new Ghosts();
            mySprite[i].setImage(spriteSheet.ghostList.get(1));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the third row of the maze
   public void thirdRow()
   {  
      int counter = 0;
      for (int i = 32; i < 48; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(23));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
               mySprite[i] = new Borders();
               mySprite[i].setImage(spriteSheet.borderList.get(21));
         }
         else if (counter == 250 || counter == 650)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(22));
         }
         else if (counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(34));
         }
         else if (counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(35));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the fourth row of the maze
   public void fourthRow()
   {
      int counter = 0;
      for (int i = 48; i < 64; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500 || counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(25));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
               mySprite[i] = new BlackSqaure();
               mySprite[i].setImage(spriteSheet.blackSquareList.get(0));
         }
         else if (counter == 250 || counter == 650 || counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(24));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the fifth row of the maze
   public void fifthRow()
   {  
      int counter = 0;
      for (int i = 64; i < 80; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500 || counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(41));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(20));
         }
         else if (counter == 250 || counter == 650 || counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(40));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the sixth row of the maze
   public void sixthRow()
   {
      int counter = 0;
      for (int i = 80; i < 96; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the seventh row of the maze
   public void seventhRow()
   {
      int counter = 0;
      for (int i = 96; i < 112; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(5));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(4));
         }
         else if (counter == 50 || counter == 100 || counter == 700 || counter == 650)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(13));
         }
         else if (counter == 150)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(22));
         }
         else if (counter == 600)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(23));
         }
         else if (counter == 200 || counter == 550)
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         else if (counter == 250)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(29));
         }
         else if (counter == 500)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(28));
         }
         else if (counter >= 300 && counter <= 450)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(13));
         }
         else
         {
            mySprite[i] = new BlackSqaure();
            mySprite[i].setImage(spriteSheet.blackSquareList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the eigth row of the maze
   public void eightRow()
   {
      int counter = 0;
      for (int i = 112; i < 128; i++)
      {
         if (counter == 200 || counter == 550)
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         else if (counter == 250 || counter == 600)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 500 || counter == 150)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else
         {
            mySprite[i] = new BlackSqaure();
            mySprite[i].setImage(spriteSheet.blackSquareList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the ninth row of the maze
   public void ninthRow()
   {
      int counter = 0;
      for (int i = 128; i < 144; i++)
      {
         if (counter == 200 || counter == 550)
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         else if (counter == 250 || counter == 600)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 500 || counter == 150)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else
         {
            mySprite[i] = new BlackSqaure();
            mySprite[i].setImage(spriteSheet.blackSquareList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For the tenth row of the maze
   public void tenthRow()
   {
      int counter = 0;
      for (int i = 144; i < 160; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(1));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(0));
         }
         else if (counter == 50 || counter == 100 || counter == 700 || counter == 650)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(11));
         }
         else if (counter == 150)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(26));
         }
         else if (counter == 600)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(27));
         }
         else if (counter == 200 || counter == 550)
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         else if (counter == 250)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(31));
         }
         else if (counter == 500)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(30));
         }
         else 
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(11));
         }
         counter+= 50;
      }
   }
   
   // For the eleventh row of the maze
   public void eleventhRow()
   {
      int counter = 0;
      for (int i = 160; i < 176; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 50 || counter == 450)
         {
            mySprite[i] = new Ghosts();
            mySprite[i].setImage(spriteSheet.ghostList.get(1));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For row 12
   public void rowTwelve()
   {
      int counter = 0;
      for (int i = 176; i < 192; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(23));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
               mySprite[i] = new Borders();
               mySprite[i].setImage(spriteSheet.borderList.get(21));
         }
         else if (counter == 250 || counter == 650)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(22));
         }
         else if (counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(34));
         }
         else if (counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(35));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For row 13 of the maze
   public void rowThirteen()
   {
      int counter = 0;
      for (int i = 192; i < 208; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500 || counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(25));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
               mySprite[i] = new BlackSqaure();
               mySprite[i].setImage(spriteSheet.blackSquareList.get(0));
         }
         else if (counter == 250 || counter == 650 || counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(24));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For row 14 of the maze
   public void rowFourteen()
   {
      int counter = 0;
      for (int i = 208; i < 224; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 100 || counter == 500 || counter == 350)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(41));
         }
         else if ((counter > 100 && counter < 250) || (counter > 500 && counter < 650))
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(20));
         }
         else if (counter == 250 || counter == 650 || counter == 400)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(40));
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For row 15 of the maze
   public void rowFifteen()
   {
      int counter = 0;
      for (int i = 224; i < 240; i++)
      {
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(3));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(2));
         }
         else if (counter == 350)
         {
            mySprite[i] = new Pacman();
            mySprite[i].setImage(spriteSheet.pacManList.get(1));
            pacManIndex = 231;
         }
         else
         {
            mySprite[i] = new Circles();
            mySprite[i].setImage(spriteSheet.edibleCircleList.get(0));
         }
         counter+= 50;
      }
   }
   
   // For row 16 of the maze
   public void rowSixteen()
   {
      int counter = 0;
      for (int i = 240; i < 256; i++)
      {  
         if (counter == 0)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(5));
         }
         else if (counter == 750)
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(4));
         }
         else
         {
            mySprite[i] = new Borders();
            mySprite[i].setImage(spriteSheet.borderList.get(13));
         }
         counter+= 50;
      }
   }
   
   // Gets the positons of each of the 4 ghosts and stores them into an array
   public void getGhostsIndex()
   {
      postionOfGhosts = new int[4];
      int index  = 0;
      for (int i = 0; i < mySprite.length; i++)
         if (mySprite[i].getClass() == (new Ghosts()).getClass())
         {
            postionOfGhosts[index] = i;
            index++;
         }
   }
   
   // Creates an array of booleans based on how many edible circles are left for pacman
   public void createEdibleCircleArray()
   {  
      for (int i = 0; i < mySprite.length; i++)
      {
         if (i == pacManIndex)
            edibleCircleArray[i] = false;
         else if (mySprite[i].getClass() == (new Borders()).getClass() || mySprite[i].getClass() == (new BlackSqaure()).getClass() || mySprite[i].getClass() == (new Pacman()).getClass())
            edibleCircleArray[i] = false;
         else
            edibleCircleArray[i] = true;
      }
   }
   
}
