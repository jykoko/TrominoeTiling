package model;

public class TrominoeModel 
{
   private Board myBoard;
   private int[][] myDisplayBoard = null;
   private int myNumbIterations, myXLoc, myYLoc,filled = 1, halfOfBoardLength = 0;
   private static final int DEFICIENT = -1, EMPTY = 0;
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
	   myBoard.getBoard()[myBoard.getDeficientSquare().getXCoordinate()]
			   			 [myBoard.getDeficientSquare().getYCoordinate()] = -1;
   }
   
   public void tileBoard()
   {
	  tile( myBoard.getOriginalBoardSize(), 0, 0 );
   }
   
   private void tile( int gridSize, int originX, int originY )
   {
	   if( gridSize == 2 )
	   {    
            for( int i = 0; i < originX + gridSize; i++ )
            {
            	for( int j = 0; j < originY + gridSize; j++ )
                {

                	if( myBoard.getBoard()[i][j] == 0 )
                	{
                		myBoard.getBoard()[i][j] = filled;
                	}
                }
             }
            incrementFilled();
            myDisplayBoard = myBoard.getBoard();
	   }
	   else
	   {
		   findDefSquare();
		   halfOfBoardLength = gridSize / 2;
		   System.out.println( " half of board length: " + halfOfBoardLength);
		   
		   if( myXLoc < originX + halfOfBoardLength && 
        	   myYLoc < originY + halfOfBoardLength) //upper left
           {
        	   tile(halfOfBoardLength, originX, originY);
        	   
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   
        	   incrementFilled();
        	   
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY); //upper right
        	   tile(halfOfBoardLength, originX , originY + halfOfBoardLength); //lower left
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
           }
           else if( myXLoc < originX + halfOfBoardLength && 
            	    myYLoc >= originY + halfOfBoardLength) //lower left
           {
        	   tile( halfOfBoardLength, originX, originY + halfOfBoardLength);
        	   
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	   
        	   incrementFilled();
        	   
        	   //recursively tile the rest
        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
        	   tile( halfOfBoardLength, originX, originY); // upper left

           }
           else if( myXLoc >= originX + halfOfBoardLength && 
            	    myYLoc < originY + halfOfBoardLength) // upper right
           {
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY );
        	   
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength -1 ] = filled;
        	  
        	  incrementFilled();
        	  
        	  tile( halfOfBoardLength, originX, originY); // upper left
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right 
       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength); // lower left

           }
           else //lower right
           {
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
        	  
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	  
        	  incrementFilled();
        	  
        	  tile( halfOfBoardLength, originX, originY); // upper left
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength ); // lower left
           }
	   	}
   }
   
   public synchronized void incrementFilled() 
   {
       filled++;
   }
   
   private void findDefSquare()
   {
	   for( int i = 0; i < myBoard.getBoard().length; i++ )
       {
       	   for( int j = 0; j < myBoard.getBoard()[i].length; j++ )
           {
           	 if( myBoard.getBoard()[i][j] != 0 )
           	 {
           		myBoard.setDefSquare(i, j);
             }
           }
        }
   }
   
   public Board getBoard()
   {
	   return myBoard;
   }
}
