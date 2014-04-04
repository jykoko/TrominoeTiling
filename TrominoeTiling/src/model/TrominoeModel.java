package model;

public class TrominoeModel {
	
	private int[][] grid;
	private int currentNum;
	
	// Pre-condition: size must be a perfect power of 2 and 0<=x<size, 0<=y<size
	// Post-condition: creates an empty tromino object with dimensions size x size.
	public TrominoeModel(int size, int x, int y) 
	{
		
		int actualsize = 1;
		while (actualsize < size) actualsize*=2;
		
		// Make sure the grid size is a perfect power of 2.
		grid = new int[actualsize][actualsize];
		currentNum = 1;
		
		// Fill in the grid with all empty squares.
		for (int i=0; i<actualsize; i++) {
			for (int j=0; j<actualsize; j++) {
				grid[i][j] = 0;
			}
		}
		
		// This represents the original hole in the tromino.
		grid[x][y] = -1;
	}
	
	// Wrapper call for recursive method.
	public void tile() {
		tileRec(grid.length, 0, 0);
	}
	
	private void tileRec(int size, int topx, int topy) {
		
		// No recursive case needed here, just fill in your one tromino...
		if (size == 2) {
		
			// Fill in the one necessary tromino. The hole is identified by a
			// non-zero number, so don't fill in that one square.	
			for (int i=0; i<size; i++) 
				for (int j=0; j<size; j++)
					if (grid[topx+i][topy+j] == 0)
						grid[topx+i][topy+j] = currentNum;
		
			// Advance to the next tromino.
			currentNum++;
		}
		
		// Recursive case...
		else {
			
			// Find coordinates of missing hole
			int savex=topx, savey=topy;
			
			for (int x=topx; x<topx+size; x++) 
				for (int y=topy; y<topy+size; y++)
					if (grid[x][y] != 0) {
						savex = x;
						savey = y;
					}
				
			// Hole in upper left quadrant.		
			if (savex < topx + size/2 && savey < topy + size/2) {
				
				// Recursively tile upper left quadrant.
				tileRec(size/2, topx, topy);
				
				// Fill in middle tromino
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2] = currentNum;
				
				// Advance to the next tromino
				currentNum++;
				
				// Now we can make our three other recursive calls.
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);
				
			}
			
			// Hole in upper right quadrant
			else if (savex < topx + size/2 && savey >= topy + size/2) {
				
				// Recursively tile upper right quadrant.
				tileRec(size/2, topx, topy+size/2);
				
				// Fill in middle tromino
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
				// Advance to the next tromino
				currentNum++;
				
				// Now we can make our three other recursive calls.
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx+size/2, topy+size/2);
				
			}
			
			// Hole in bottom left quadrant
			else if (savex >= topx + size/2 && savey < topy + size/2) {
				
				// Recursively tile bottom left quadrant.
				tileRec(size/2, topx+size/2, topy);
				
				// Fill in middle tromino
				grid[topx+size/2-1][topy+size/2] = currentNum;
				grid[topx+size/2][topy+size/2] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
				// Advance to the next tromino
				currentNum++;
				
				// Now we can make our three other recursive calls.
				tileRec(size/2, topx, topy);
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx+size/2, topy+size/2);
			}
			else {
				
				// Recursively tile bottom right quadrant.
				tileRec(size/2, topx+size/2, topy+size/2);
				
				// Fill in middle tromino
				grid[topx+size/2-1][topy+size/2] = currentNum;
				grid[topx+size/2][topy+size/2-1] = currentNum;
				grid[topx+size/2-1][topy+size/2-1] = currentNum;
				
				// Advance to the next tromino
				currentNum++;
				
				// Now we can make our three other recursive calls.
				tileRec(size/2, topx+size/2, topy);
				tileRec(size/2, topx, topy+size/2);
				tileRec(size/2, topx, topy);
			}
			
		} // end large if-else
		
	} // end tileRec
	
	
	// Prints out the current object.
	public void print() {
		
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++)
				System.out.print(grid[i][j] + "\t");
			System.out.println();
		}
	}
	
	public int[][] getgrid()
	{
		return grid;
	}
}

//public class TrominoeModel 
//{
//   private Board myBoard;
//   private int[][] myDisplayBoard = null;
//   private int myNumbIterations, myXLoc, myYLoc, filled = 1, halfOfBoardLength = 0;
//   private static final int DEFICIENT = -1, EMPTY = 0;
//   
//   public TrominoeModel( Board board )
//   {
//	   myBoard = board;
//	   myBoard.getBoard()[myBoard.getDeficientSquare().getXCoordinate()]
//			   			 [myBoard.getDeficientSquare().getYCoordinate()] = -1;
//   }
//   
//   public void tileBoard()
//   {
//	  tile( myBoard.getOriginalBoardSize(), 0, 0 );
//   }
//   
//   private void tile( int gridSize, int originX, int originY )
//   {
//	   if( gridSize == 2 )
//	   {    
//            for( int i = 0; i < originX + gridSize; i++ )
//            {
//            	for( int j = 0; j < originY + gridSize; j++ )
//                {
//
//                	if( myBoard.getBoard()[i][j] == 0 )
//                	{
//                		myBoard.getBoard()[i][j] = filled;
//                	}
//                }
//             }
//            incrementFilled();
//            myDisplayBoard = myBoard.getBoard();
//	   }
//	   else
//	   {
//		   findDefSquare( gridSize, originX, originY);
//		   halfOfBoardLength = gridSize / 2;
//		   System.out.println( " half of board length: " + halfOfBoardLength);
//		   
//		   if( myXLoc < originX + halfOfBoardLength && 
//        	   myYLoc < originY + halfOfBoardLength) //upper left
//           {
//        	   tile(halfOfBoardLength, originX, originY);
//        	   
//        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
//        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
//        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
//        	   
//        	   System.out.println( myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1]  );
//        	   incrementFilled();
//        	   
//        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY); //upper right
//        	   tile(halfOfBoardLength, originX , originY + halfOfBoardLength); //lower left
//        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
//           }
//           else if( myXLoc < originX + halfOfBoardLength && 
//            	    myYLoc >= originY + halfOfBoardLength) //lower left
//           {
//        	   tile( halfOfBoardLength, originX, originY + halfOfBoardLength);
//        	   
//        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength - 1] = filled;
//        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
//        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
//        	   
//        	   incrementFilled();
//        	   
//        	   //recursively tile the rest
//        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
//        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
//        	   tile( halfOfBoardLength, originX, originY); // upper left
//
//           }
//           else if( myXLoc >= originX + halfOfBoardLength && 
//            	    myYLoc < originY + halfOfBoardLength) // upper right
//           {
//        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY );
//        	   
//        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
//        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
//        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength -1 ] = filled;
//        	  
//        	  incrementFilled();
//        	  
//        	  tile( halfOfBoardLength, originX, originY); // upper left
//       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right 
//       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength); // lower left
//           }
//           else //lower right
//           {
//        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
//        	  
//        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
//        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
//        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
//        	  
//        	  incrementFilled();
//        	  
//        	  tile( halfOfBoardLength, originX, originY); // upper left
//       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
//       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength ); // lower left
//           }
//	   	}
//   }
//   
//   public synchronized void incrementFilled() 
//   {
//       filled++;
//   }
//   
//   private void findDefSquare( int gridSize , int originX, int originY)
//   {
//	   myXLoc = originX;
//	   myYLoc = originY;
//	   for( int i = 0; i < originX + gridSize; i++ )
//       {
//       	   for( int j = 0; j < originY + gridSize; j++ )
//           {
//           	 if( myBoard.getBoard()[i][j] != 0 )
//           	 {
//           		myBoard.setDefSquare(i, j);
//             }
//           }
//        }
//	   myXLoc = myBoard.getDeficientSquare().getXCoordinate();
//	   myYLoc = myBoard.getDeficientSquare().getYCoordinate();
//   }
//   
//   public Board getBoard()
//   {
//	   return myBoard;
//   }
//}
