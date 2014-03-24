package testing;

import static org.junit.Assert.assertTrue;
import model.Board;
import org.junit.Test;

public class TrominoeTest 
{
	@Test
	public void testDeficientSquareGeneration() 
	{
		for( int i = 0; i < 100000; i++ )
		{
			Board board = new Board( 8 );

			assertTrue( board.getDeficientSquare().getXCoordinate() >= 0 && 
				        board.getDeficientSquare().getXCoordinate() <= 1 );
		
	    	assertTrue( board.getDeficientSquare().getYCoordinate() >= 0 && 
			            board.getDeficientSquare().getYCoordinate() <= 1 );
		}
	}
}