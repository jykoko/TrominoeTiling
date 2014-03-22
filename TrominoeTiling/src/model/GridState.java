package model;

public enum GridState 
{
  DEFICIENT(-1), EMPTY(0), FILLED(1);
  
  private int stateValue;

  GridState( int numericVal ) 
  {
      this.stateValue = numericVal;
  }

  public int getState() 
  {
      return stateValue;
  }
}
