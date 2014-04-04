package model;

public class TrominoeModel 
{
	private Board myBoard;
	private int[][] myBoardArray;
	private DeficientSquare defSquare;
	private int currentNum;
	

	public TrominoeModel(int size, int x, int y) 
	{	
		currentNum = 1;
		myBoard = new Board(size);
		myBoardArray = myBoard.getBoard();
		defSquare = new DeficientSquare(x,y);
		myBoardArray[defSquare.getXCoordinate()][defSquare.getYCoordinate()] = -1;
	}
	
	public void tile() 
	{
		tileRec(myBoardArray.length, 0, 0);
	}
	
	private void tileRec(int size, int originX, int originY) 
	{
		if (size == 2) 
		{
			for (int i=0; i<size; i++) 
			{
				for (int j=0; j<size; j++)
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
			int savex=originX, savey=originY;
			for (int x=originX; x<originX+size; x++) 
			{
				for (int y=originY; y<originY+size; y++)
				{
					if (myBoardArray[x][y] != 0) 
					{
						savex = x;
						savey = y;
					}
				}
			}
				
			if (savex < originX + size/2 && savey < originY + size/2) 
			{
				tileRec(size/2, originX, originY);
				
				myBoardArray[originX+size/2][originY+size/2-1] = currentNum;
				myBoardArray[originX+size/2][originY+size/2] = currentNum;
				myBoardArray[originX+size/2-1][originY+size/2] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, originX, originY+size/2);
				tileRec(size/2, originX+size/2, originY);
				tileRec(size/2, originX+size/2, originY+size/2);	
			}
			else if (savex < originX + size/2 && savey >= originY + size/2) 
			{
				tileRec(size/2, originX, originY+size/2);
				
				myBoardArray[originX+size/2][originY+size/2-1] = currentNum;
				myBoardArray[originX+size/2][originY+size/2] = currentNum;
				myBoardArray[originX+size/2-1][originY+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, originX, originY);
				tileRec(size/2, originX+size/2, originY);
				tileRec(size/2, originX+size/2, originY+size/2);
			}
			else if (savex >= originX + size/2 && savey < originY + size/2) 
			{
				tileRec(size/2, originX+size/2, originY);
				
				myBoardArray[originX+size/2-1][originY+size/2] = currentNum;
				myBoardArray[originX+size/2][originY+size/2] = currentNum;
				myBoardArray[originX+size/2-1][originY+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, originX, originY);
				tileRec(size/2, originX, originY+size/2);
				tileRec(size/2, originX+size/2, originY+size/2);
			}
			else 
			{
				tileRec(size/2, originX+size/2, originY+size/2);
				
				myBoardArray[originX+size/2-1][originY+size/2] = currentNum;
				myBoardArray[originX+size/2][originY+size/2-1] = currentNum;
				myBoardArray[originX+size/2-1][originY+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, originX+size/2, originY);
				tileRec(size/2, originX, originY+size/2);
				tileRec(size/2, originX, originY);
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