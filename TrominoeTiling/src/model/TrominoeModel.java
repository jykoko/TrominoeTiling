package model;

public class TrominoeModel 
{
   private Board myBoard;
   private int[][] myDisplayBoard = null;
   private int myNumbIterations, myXLoc, myYLoc,filled = 1, halfOfBoardLength = 0;
   private static final int DEFICIENT = -1, EMPTY = 0;
   
   public TrominoeModel( Board board )
   {
	   myBoard = board;
	   myBoard.getBoard()[myBoard.getDeficientSquare().getXCoordinate()]
			   			 [myBoard.getDeficientSquare().getYCoordinate()] = -1;
	   
   }
   
   public void tileBoard()
   {
	  tile( myBoard.getOriginalBoardSize(), 0, 0 );
   }
   
   private void tile( int gridSize, int originX, int originY )
   {
	   if( gridSize == 2 )
	   {    
            for( int i = 0; i <  gridSize; i++ )
            {
            	for( int j = 0; j <  gridSize; j++ )
                {

                	if( myBoard.getBoard()[originX+i][originY+j] == 0 )
                	{
                		myBoard.getBoard()[originX+i][originY+j] = filled;
                	}
                }
             }
            incrementFilled();
            myDisplayBoard = myBoard.getBoard();
	   }
	   else
	   {
		   findDefSquare( gridSize, originX, originY);
		   halfOfBoardLength = gridSize / 2;
		   System.out.println( " xloc: " + myXLoc + "yloc: " + myYLoc);
		   
		   if( myXLoc < originX + halfOfBoardLength && 
        	   myYLoc < originY + halfOfBoardLength) //upper left
           {
			   System.out.println( "in upper left" );
        	   tile(halfOfBoardLength, originX, originY);
        	   
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   
        	   int i = myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1];
        	  
        	   incrementFilled();
        	   
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY); //upper right
        	   tile(halfOfBoardLength, originX , originY + halfOfBoardLength); //lower left
        	   tile(halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
           }
           else if( myXLoc < originX + halfOfBoardLength && 
            	    myYLoc >= originY + halfOfBoardLength) //lower left
           {
        	   System.out.println( "in lower left" );
        	  
        	   tile( halfOfBoardLength, originX, originY + halfOfBoardLength);
     
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength - 1] = filled;
        	   myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	   myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	   
        	   incrementFilled();
        	   
        	   //recursively tile the rest
        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
        	   tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right
        	   tile( halfOfBoardLength, originX, originY); // upper left

           }
           else if( myXLoc >= originX + halfOfBoardLength && 
            	    myYLoc < originY + halfOfBoardLength) // upper right
           {
        	   System.out.println( "in upper right" );
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY );
        	   
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength -1 ] = filled;
        	  
        	  incrementFilled();
        	  
        	  tile( halfOfBoardLength, originX, originY); // upper left
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength); // lower right 
       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength); // lower left

           }
           else //lower right
           {
        	   System.out.println( "in lower right" );
        	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY + halfOfBoardLength);
        	  
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength - 1] = filled;
        	  myBoard.getBoard()[originX + halfOfBoardLength - 1][originY + halfOfBoardLength] = filled; 
        	  myBoard.getBoard()[originX + halfOfBoardLength][originY + halfOfBoardLength] = filled;
        	  
        	  incrementFilled();
        	  
        	  tile( halfOfBoardLength, originX, originY); // upper left
       	   	  tile( halfOfBoardLength, originX + halfOfBoardLength, originY); // upper right
       	      tile( halfOfBoardLength, originX , originY + halfOfBoardLength ); // lower left
           }
	   	}
   }
   
   public synchronized void incrementFilled() 
   {
       filled++;
   }
   
   private void findDefSquare( int gridSize , int originX, int originY)
   {
	   System.out.println( "originX:" + originX + "originY: " + originY);
	   for( int i = 0; i <  originX + gridSize; i++ )
       {
       	   for( int j = 0; j < originY + gridSize; j++ )
           {
           	 if( myBoard.getBoard()[ i][ j] != 0 )
           	 {
           		
           		System.out.println("i " +  i + "j " + j);
           		myBoard.setDefSquare(i,j);
             }
           }
        }
	   myXLoc = myBoard.getDeficientSquare().getXCoordinate();
	   myYLoc = myBoard.getDeficientSquare().getYCoordinate();
   }
   
   public Board getBoard()
   {
	   return myBoard;
   }
}
