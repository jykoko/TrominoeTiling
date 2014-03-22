package model;

public class TrominoeModel 
{
   Board myBoard;
   Board myDisplayBoard;
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
	   myDisplayBoard = myBoard;
   }
   
   public void tile( int gridSize )
   {
	   if( gridSize == 2 )
	   {
		   //myBoard.getDefSquare().getXLoc(), myBoard.getDefSquare().getYLoc();
		   //loop thru board, checking for defSquare location, otherwise fill
		   //set origBoard to solution for display in GUI via controller
	   }
	   else
	   {
		   int n = myBoard.getBoardSize() / 2;
		   myBoard.setBoardSize(n);
	   }
   }
}