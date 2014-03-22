package model;

public class Board 
{
   int[][] myBoard;
   int boardSize = 0;
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
	   boardSize = size;
	   myBoard = new int[boardSize][boardSize];
   }
   
   public int getBoardSize()
   {
	   return boardSize;
   }
}
