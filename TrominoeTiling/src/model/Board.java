package model;

public class Board 
{
   private int[][] myBoard;
   private int myBoardSize = 0;
   private DeficientSquare myDefSquare = new DeficientSquare();
   
   public Board( int boardSize )
   {
	  setBoardSize( boardSize );
	  setNewDeficientSquare();
	  clearBoard();
   }
   
   public void rotateBoard()
   {
	   
   }
   
   /*
    * Private because only accessed from within this class. 
    */
   private void setNewDeficientSquare()
   {
	   myDefSquare.generateCoordinates();
   }
   
   public DeficientSquare getDeficientSquare()
   {
	   return myDefSquare;
   }
   
   public void clearBoard()
   {
	   for( int i = 0; i < myBoard.length; i++ ) 
	   {
		  for( int j = 0; j < myBoard[i].length; j++ ) 
		  {
		      myBoard[i][j] = 0;
		  }
	   }
   }
   
   public void setBoardSize( int size )
   {
	   myBoardSize = size;
	   myBoard = new int[myBoardSize][myBoardSize];
   }
   
   public int getBoardSize()
   {
	   return myBoardSize;
   }
}