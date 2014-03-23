package model;

import java.util.Random;

public class DeficientSquare 
{
  private int myXLoc;
  private int myYLoc;
  private Random rand;
  
  public DeficientSquare()
  {
	 rand = new Random();
  }
  
  public void generateCoordinates()
  {
	  myXLoc = rand.nextInt(2);
	  myYLoc = rand.nextInt(2);
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