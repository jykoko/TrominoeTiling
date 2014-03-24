package model;

import java.util.Random;

public class DeficientSquare 
{
  private int myXLoc;
  private int myYLoc;
  private Random myRand;
  
  public DeficientSquare()
  {
	 myRand = new Random();
  }
  
  public void generateCoordinates()
  {
	 myXLoc = myRand.nextInt(2);
	 myYLoc = myRand.nextInt(2);
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