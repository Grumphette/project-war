package Core;

import java.util.ArrayList;


public abstract class Field 
{
  private boolean crossable;
  private int movementPenalty;
  private Ability grantedBonus;
	
	public Field()
	{
		
	}
	
	
	public boolean isCrossable()
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
