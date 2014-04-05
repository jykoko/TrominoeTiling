package model;

public class TrominoeModel 
{
	private Board myBoard;
	private int[][] myBoardArray;
	private DeficientSquare myDefSquare;
	private int myCurrentNum, myFinalNumbIterations;

	public TrominoeModel(int boardLength, int x, int y) 
	{	
		myCurrentNum = 1;
		myBoard = new Board(boardLength);
		myBoardArray = myBoard.getBoard();
		myDefSquare = new DeficientSquare(x,y);
		myBoardArray[myDefSquare.getXCoordinate()][myDefSquare.getYCoordinate()] = -1;
	}
	
	public void tileBoard() 
	{
		tile(myBoardArray.length, 0, 0);
	}
	
	private void tile(int boardLength, int originX, int originY) 
	{
		if (boardLength == 2) 
		{
			for (int i=0; i<boardLength; i++) 
			{
				for (int j=0; j<boardLength; j++)
				{
					if (myBoardArray[originX+i][originY+j] == 0)
					{
						myBoardArray[originX+i][originY+j] = myCurrentNum;
					}
				}
			}
			advanceToNextTrominoe();
			myFinalNumbIterations++;
		}
		else 
		{
			int defX = originX, defY = originY;
			for (int x = originX; x < originX+boardLength; x++) 
			{
				for (int y = originY; y < originY+boardLength; y++)
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
				tile(boardLength/2, originX, originY);
				
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = myCurrentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = myCurrentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = myCurrentNum;
				
				advanceToNextTrominoe();
				
				tile(boardLength/2, originX, originY+boardLength/2);
				tile(boardLength/2, originX+boardLength/2, originY);
				tile(boardLength/2, originX+boardLength/2, originY+boardLength/2);	
			}
			else if (defX < originX + boardLength/2 && defY >= originY + boardLength/2) 
			{
				tile(boardLength/2, originX, originY+boardLength/2);
				
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = myCurrentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = myCurrentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = myCurrentNum;
				
				advanceToNextTrominoe();
				
				tile(boardLength/2, originX, originY);
				tile(boardLength/2, originX+boardLength/2, originY);
				tile(boardLength/2, originX+boardLength/2, originY+boardLength/2);
			}
			else if (defX >= originX + boardLength/2 && defY < originY + boardLength/2) 
			{
				tile(boardLength/2, originX+boardLength/2, originY);
				
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = myCurrentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2] = myCurrentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = myCurrentNum;
				
				advanceToNextTrominoe();
				
				tile(boardLength/2, originX, originY);
				tile(boardLength/2, originX, originY+boardLength/2);
				tile(boardLength/2, originX+boardLength/2, originY+boardLength/2);
			}
			else 
			{
				tile(boardLength/2, originX+boardLength/2, originY+boardLength/2);
				
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2] = myCurrentNum;
				myBoardArray[originX+boardLength/2][originY+boardLength/2-1] = myCurrentNum;
				myBoardArray[originX+boardLength/2-1][originY+boardLength/2-1] = myCurrentNum;
				
				advanceToNextTrominoe();
				
				tile(boardLength/2, originX+boardLength/2, originY);
				tile(boardLength/2, originX, originY+boardLength/2);
				tile(boardLength/2, originX, originY);
			}
		} 
	} 
	
	public void advanceToNextTrominoe()
	{
		myCurrentNum++;
	}
	
	public Board getBoard()
	{
		return myBoard;
	}
	
	public int[][] getgrid()
	{
		return myBoardArray;
	}
	
	public DeficientSquare getDefSquare()
	{
		return myDefSquare;
	}

	public int getNumbIterations() 
	{
		return myFinalNumbIterations;
	}
}