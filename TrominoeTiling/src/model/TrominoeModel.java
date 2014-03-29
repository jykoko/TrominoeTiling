package model;

public class TrominoeModel 
{
   private Board myBoard;
   private Board myDisplayBoard;
   private int myNumbIterations, myXLoc, myYLoc;
   private static final int DEFICIENT = -1, FILLED = 1, EMPTY = 0;
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
	   myDisplayBoard = myBoard;
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
                		myBoard.getBoard()[i][j] = FILLED;
                	}
                }
             }
            
            myDisplayBoard = myBoard;
		   //loop thru board, checking for defSquare location, otherwise fill
		   //set origBoard to solution for display in GUI via controller
	   }
	   else
	   {
		   findDefSquare(originX, originY);
		   int halfOfBoardLength = myBoard.getBoardSize() / 2;
		   
		   if( myXLoc < originX + halfOfBoardLength && 
        	   myYLoc < originY + halfOfBoardLength) //upper left
           {
        	   tile(halfOfBoardLength, originX, originY);
        	   
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = FILLED;
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = FILLED; 
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = FILLED; 
        	   
        	   tile(halfOfBoardLength, originX, originY + halfOfBoardLength);
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY);
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
           }
           else if( myXLoc < originX + halfOfBoardLength && 
            	    myYLoc >= originY + halfOfBoardLength) //lower left
           {
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength - 1] = FILLED;
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = FILLED; 
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = FILLED;
           }
           else if( myXLoc >= originX + halfOfBoardLength && 
            	    myYLoc < originY + halfOfBoardLength) // upper right
           {
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = FILLED;
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = FILLED; 
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = FILLED;
           }
           else //lower right
           {
        	  
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