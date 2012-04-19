package Core;

import java.util.ArrayList;

import misc.Coord2D;


public abstact class Field 
{
  private bool crossable;
  private int movementPenalty;
  private Ability grantedBonus;
	
	public Field()
	{
		
	}
	
	
	public void isCrossable()
  {
    return crossable;
  }
  
  public Ability getGrantedBonus()
  {
    return grantedBonus;
  }
  
  public int getMovementPenalty()
  {
     return movementPenalty;
  }
}
