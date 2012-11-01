package Core;

import java.util.ArrayList;

import misc.Coord2D;




public class Troop {
	
	private int size;
  private int trackSize;
	private Coord2D leftrotatePoint, rightrotatePoint;
	private ArrayList<Unit> troupUnits;
	private boolean isDeployed;
	
	//aglomerate all the abilities, attack dices and stamania to ease furser tests
	private ArrayList<Ability> grantedAbilities;
	private ArrayList<Dice> attackDices;
	private int stamania;
	
	public Troop()
	{
		this.size = 0;
		this.trackSize = 0;
		this.troupUnits = new ArrayList<Unit>();
		this.grantedAbilities = new ArrayList<Ability>();
		this.attackDices = new ArrayList<Dice>();
		this.stamania = 0;
		this.leftrotatePoint = new Coord2D(0, 0);
		this.rightrotatePoint = new Coord2D(0, 0);
		this.isDeployed = false;
	}

	public void addUnit(Unit unitToAdd)
	{
		this.trackSize++;
		//you have to check that the unitToAdd.troupSizeAgreement is less or equal to the other Unit in the troop
		if(this.troupUnits.isEmpty())
		{
			this.size = unitToAdd.getTroupSizeAgreement();
		}
		else
		{
			if(unitToAdd.getTroupSizeAgreement() >= this.trackSize && this.trackSize <= this.size ) //we are in the case where we want to add a unit with a correct size aggrement in a not fully populated troop
			{
				this.troupUnits.add(unitToAdd);
				this.grantedAbilities.addAll(unitToAdd.getGrantedAbilities());
				this.attackDices.addAll(unitToAdd.getAttackDices());
				this.stamania += unitToAdd.getStamania();
					
				if(unitToAdd.getTroupSizeAgreement() < this.size) // if we add a unit with a lowest troop size agreement we have to udpate the size limit of this troop
				{
					this.size = unitToAdd.getTroupSizeAgreement();
				}
			}
		}
	}
	
	public void rotate(int dx, int dy, Coord2D pivot)
	{
		if(pivot.equals(this.leftrotatePoint))
		{
			this.rightrotatePoint.translate(dx, dy);
		}
		else
		{
			this.leftrotatePoint.translate(dx, dy);
		}
	}
	
	public void march(int dx, int dy)
	{
		this.leftrotatePoint.translate(dx, dy);
		this.rightrotatePoint.translate(dx, dy);
	}
	
	public void deploy(int x, int y)
	{
		this.leftrotatePoint.setLocation(x, y);
		this.rightrotatePoint.setLocation(x+this.size, y);
		this.isDeployed = true;
	}
	
	
	
}
