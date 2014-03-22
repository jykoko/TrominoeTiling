package model;

public class DeficientSquare 
{
  private int myXLoc;
  private int myYLoc;
  
  public DeficientSquare( int xCord, int yCord )
  {
	  myXLoc = xCord;
	  myYLoc = yCord;
  }
  
  public void setXCoordinate( int coordinate )
  {
	  myXLoc = coordinate;
  }
  
  public void setYCoordinate( int coordinate )
  {
	  myYLoc = coordinate;
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