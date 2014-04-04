package model;

public class TrominoeModel 
{
	private Board board;
	private int[][] grid;
	private DeficientSquare defSquare;
	private int currentNum;
	

	public TrominoeModel(int size, int x, int y) 
	{	
		currentNum = 1;
		board = new Board(size);
		grid = board.getBoard();

		defSquare = new DeficientSquare(x,y);
		grid[defSquare.getXCoordinate()][defSquare.getYCoordinate()] = -1;
	}
	
	public void tile() 
	{
		tileRec(grid.length, 0, 0);
	}
	
	private void tileRec(int size, int topx, int topy) 
	{
		if (size == 2) 
		{
			for (int i=0; i<size; i++) 
			{
				for (int j=0; j<size; j++)
				{
					if (grid[topx+i][topy+j] == 0)
					{
						grid[topx+i][topy+j] = currentNum;
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
					if (grid[x][y] != 0) 
					{
						savex = x;
						savey = y;
					}
				}
			}
				
			if (savex < topx + size/2 && savey < topy + size/2) 
			{
				tileRec(size/2, topx, topy);
				
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);	
			}
			else if (savex < topx + size/2 && savey >= topy + size/2) 
			{
				tileRec(size/2, topx, topy+size/2);
				
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);
			}
			else if (savex >= topx + size/2 && savey < topy + size/2) 
			{
				tileRec(size/2, topx+size/2, topy);
				
				grid[topx+size/2-1][topy+size/2] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
				advanceToNextTrominoe();
				
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy+size/2);
			}
			else 
			{
				tileRec(size/2, topx+size/2, topy+size/2);
				
				grid[topx+size/2-1][topy+size/2] = currentNum;
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
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
		return board;
	}
	
	public int[][] getgrid()
	{
		return grid;
	}
}
