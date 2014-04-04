package model;

public class TrominoeModel 
{
	private Board myBoard;
	private int[][] myBoardArray;
	private DeficientSquare defSquare;
	private int currentNum;

	public TrominoeModel(int boardLength, int x, int y) 
	{	
		currentNum = 1;
		myBoard = new Board(boardLength);
		myBoardArray = myBoard.getBoard();
		defSquare = new DeficientSquare(x,y);
		myBoardArray[defSquare.getXCoordinate()][defSquare.getYCoordinate()] = -1;
	}
	
	public void tile() 
	{
		tileRec(myBoardArray.length, 0, 0);
	}
	
	private void tileRec(int boardLength, int originX, int originY) 
	{
		if (boardLength == 2) 
		{
			for (int i=0; i<boardLength; i++) 
			{
				for (int j=0; j<boardLength; j++)
				{
					if (myBoardArray[originX+i][originY+j] == 0)
					{
						myBoardArray[originX+i][originY+j] = currentNum;
					}
				}
			}
			advanceToNextTrominoe();
		}
		else 
		{
			int defX=originX, defY=originY;
			for (int x=originX; x<originX+boardLength; x++) 
			{
				for (int y=originY; y<originY+boardLength; y++)
				{
					if (myBoardArray[x][y] != 0) 
					{
						defX = x;
						defY = y;
					}
				}
			}
				
			if (defX < originX + boardLength/2 && defY < originY + boardLength/2) 
			{
				tileRec(boardLength/2, originX, originY);
				
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = currentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = currentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(boardLength/2, originX, originY+boardLength/2);
				tileRec(boardLength/2, originX+boardLength/2, originY);
				tileRec(boardLength/2, originX+boardLength/2, originY+boardLength/2);	
			}
			else if (defX < originX + boardLength/2 && defY >= originY + boardLength/2) 
			{
				tileRec(boardLength/2, originX, originY+boardLength/2);
				
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = currentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = currentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(boardLength/2, originX, originY);
				tileRec(boardLength/2, originX+boardLength/2, originY);
				tileRec(boardLength/2, originX+boardLength/2, originY+boardLength/2);
			}
			else if (defX >= originX + boardLength/2 && defY < originY + boardLength/2) 
			{
				tileRec(boardLength/2, originX+boardLength/2, originY);
				
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = currentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = currentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(boardLength/2, originX, originY);
				tileRec(boardLength/2, originX, originY+boardLength/2);
				tileRec(boardLength/2, originX+boardLength/2, originY+boardLength/2);
			}
			else 
			{
				tileRec(boardLength/2, originX+boardLength/2, originY+boardLength/2);
				
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = currentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = currentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(boardLength/2, originX+boardLength/2, originY);
				tileRec(boardLength/2, originX, originY+boardLength/2);
				tileRec(boardLength/2, originX, originY);
			}
		} 
	} 
	
	public void advanceToNextTrominoe()
	{
		currentNum++;
	}
	
	public Board getBoard()
	{
		return myBoard;
	}
	
	public int[][] getgrid()
	{
		return myBoardArray;
	}
}