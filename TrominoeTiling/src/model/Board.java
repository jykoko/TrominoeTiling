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
   
   /*
    * Private because only accessed from within this class. 
    */
   private void setNewDeficientSquare()
   {
	   myDefSquare.generateCoordinates();
   }
   
   public void setDefSquare( int x, int y )
   {
 	   myDefSquare.setCoorinates(x, y);
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
   
   public void printBoard()
   {
	   for( int i = 0; i < myBoard.length; i++ ) 
	   {
		  for( int j = 0; j < myBoard[i].length; j++ ) 
		  {
		      System.out.print( myBoard[i][j] + "\t");
		  }
		  System.out.println();
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
   
   public int[][] getBoard()
   {
	   return myBoard;
   }
}