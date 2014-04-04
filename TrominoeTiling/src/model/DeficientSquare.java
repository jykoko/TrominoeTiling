package model;

public class DeficientSquare 
{
  private int myXLoc;
  private int myYLoc;
  
  public DeficientSquare(int x, int y)
  {
	 this.setCoorinates(x, y);
  }
  
  public void setCoorinates( int x, int y )
  {
	  myXLoc = x;
	  myYLoc = y;
  }
  
  public int getXCoordinate()
  {
	 return myXLoc;
  }
  
  public int getYCoordinate()
  {
	 return myYLoc;
  }
}