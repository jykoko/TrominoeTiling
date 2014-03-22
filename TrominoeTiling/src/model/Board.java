package model;

public class Board 
{
   int[][] myBoard;
   int myBoardSize = 0;
   DeficientSquare myDefSquare;
   
   public Board( int boardSize )
   {
	  setBoardSize( boardSize );
   }
   
   public void rotateBoard()
   {
	   
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
