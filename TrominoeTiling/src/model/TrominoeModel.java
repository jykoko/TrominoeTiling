package model;

public class TrominoeModel 
{
   private Board myBoard;
   private int[][] myDisplayBoard = null;
   private int myNumbIterations, myXLoc, myYLoc, filled =1;
   private static final int DEFICIENT = -1, EMPTY = 0;
   
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
   }
   
   public void tileBoard()
   {
	  tile( myBoard.getBoardSize(), 0, 0 );
   }
   
   private void tile( int gridSize, int originX, int originY )
   {
	   
	   if( gridSize == 2 )
	   {    
            for( int i = 0; i < myBoard.getBoard().length; i++ )
            {
            	for( int j = 0; j < myBoard.getBoard()[i].length; j++ )
                {
                	if( myBoard.getBoard()[i][j] != DEFICIENT )
                	{
                		myBoard.getBoard()[i][j] = filled;
                	}
                }
             }
            filled++;
            myDisplayBoard = myBoard.getBoard();
		   //loop thru board, checking for defSquare location, otherwise fill
		   //set origBoard to solution for display in GUI via controller
	   }
	   else
	   {
		   findDefSquare(originX, originY);
		   originX = 0;
		   originY = 0;
		   int halfOfBoardLength = myBoard.getBoardSize() / 2;
		   
		   if( myXLoc < originX + halfOfBoardLength && 
        	   myYLoc < originY + halfOfBoardLength) //upper left
           {
        	   tile(halfOfBoardLength, originX, originY);
        	   
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   
        	   filled++;
        	   
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength - 1);
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
        	   tile(halfOfBoardLength, originX + halfOfBoardLength - 1, originY + halfOfBoardLength);
           }
           else if( myXLoc < originX + halfOfBoardLength && 
            	    myYLoc >= originY + halfOfBoardLength) //lower left
           {
        	   //recursively tiling lower left quad
        	   tile( halfOfBoardLength, originX, originY + halfOfBoardLength);
        	   
        	   //set center tromino
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	   
        	   filled++;
        	   
        	   //recursively tile the rest
        	   tile( halfOfBoardLength, originX + halfOfBoardLength - 1 , originY + halfOfBoardLength - 1);
        	   tile( halfOfBoardLength, originX + halfOfBoardLength - 1 , originY + halfOfBoardLength);
        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength );
           }
           else if( myXLoc >= originX + halfOfBoardLength && 
            	    myYLoc < originY + halfOfBoardLength) // upper right
           {
        	  
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY );
        	   
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength -1 ] = filled;
        	  
        	  filled++;
        	  
        	  tile( halfOfBoardLength, originX + halfOfBoardLength , originY + halfOfBoardLength - 1);
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength , originY + halfOfBoardLength);
       	      tile( halfOfBoardLength, originX + halfOfBoardLength - 1, originY + halfOfBoardLength - 1);
           }
           else //lower right
           {
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
        	  
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	  
        	  filled++;
        	  
        	  tile( halfOfBoardLength, originX + halfOfBoardLength , originY + halfOfBoardLength - 1);
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength - 1 , originY + halfOfBoardLength);
       	      tile( halfOfBoardLength, originX + halfOfBoardLength , originY + halfOfBoardLength );
           }
	   	}
   }
   
   private void findDefSquare( int originX, int originY )
   {
	   myNumbIterations++;
	   if(myNumbIterations <= 1)
	   {
		  myXLoc = myBoard.getDeficientSquare().getXCoordinate();
		  myYLoc = myBoard.getDeficientSquare().getYCoordinate();
	   }
	   else
	   {
		  myBoard.setDefSquare(originX, originY);
		  myXLoc = myBoard.getDeficientSquare().getXCoordinate();
		  myYLoc = myBoard.getDeficientSquare().getYCoordinate();
	   }
   }
   
   public Board getBoard()
   {
	   return myBoard;
   }
}