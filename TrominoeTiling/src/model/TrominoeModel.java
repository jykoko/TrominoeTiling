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
	
	private void tileRec(int size, int topx, int topy) 
	{
		if (size == 2) 
		{
			for (int i=0; i<size; i++) 
			{
				for (int j=0; j<size; j++)
				{
					if (myBoardArray[topx+i][topy+j] == 0)
					{
						myBoardArray[topx+i][topy+j] = currentNum;
					}
				}
			}
			advanceToNextTrominoe();
		}
		else 
		{
			int savex=topx, savey=topy;
			for (int x=topx; x<topx+size; x++) 
			{
				for (int y=topy; y<topy+size; y++)
				{
					if (myBoardArray[x][y] != 0) 
					{
						savex = x;
						savey = y;
					}
				}
			}
				
			if (savex < topx + size/2 && savey < topy + size/2) 
			{
				tileRec(size/2, topx, topy);
				
				myBoardArray[topx+size/2][topy+size/2-1] = currentNum;
				myBoardArray[topx+size/2][topy+size/2] = currentNum;
				myBoardArray[topx+size/2-1][topy+size/2] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);	
			}
			else if (savex < topx + size/2 && savey >= topy + size/2) 
			{
				tileRec(size/2, topx, topy+size/2);
				
				myBoardArray[topx+size/2][topy+size/2-1] = currentNum;
				myBoardArray[topx+size/2][topy+size/2] = currentNum;
				myBoardArray[topx+size/2-1][topy+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);
			}
			else if (savex >= topx + size/2 && savey < topy + size/2) 
			{
				tileRec(size/2, topx+size/2, topy);
				
				myBoardArray[topx+size/2-1][topy+size/2] = currentNum;
				myBoardArray[topx+size/2][topy+size/2] = currentNum;
				myBoardArray[topx+size/2-1][topy+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy+size/2);
			}
			else 
			{
				tileRec(size/2, topx+size/2, topy+size/2);
				
				myBoardArray[topx+size/2-1][topy+size/2] = currentNum;
				myBoardArray[topx+size/2][topy+size/2-1] = currentNum;
				myBoardArray[topx+size/2-1][topy+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx, topy);
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