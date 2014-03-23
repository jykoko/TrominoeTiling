package model;

public class TrominoeModel 
{
   private Board myBoard;
   private Board myDisplayBoard;
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
	   myDisplayBoard = myBoard;
   }
   
   public void tile( int gridSize )
   {
	   if( gridSize == 2 )
	   {
		    int xLoc = myBoard.getDeficientSquare().getXCoordinate();
            int yLoc = myBoard.getDeficientSquare().getYCoordinate();
		   //loop thru board, checking for defSquare location, otherwise fill
		   //set origBoard to solution for display in GUI via controller
	   }
	   else
	   {
		  // int n = myBoard.getBoardSize() / 2;
		  // add recursive calls for each quadrant
	   }
   }
}