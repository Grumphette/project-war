package Core;

import java.util.ArrayList;

import misc.Coord2D;




public class Troop {
	
	private int size;
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
		//you have to check that the unitToAdd.troupSizeAgreement is less or equal to the other Unit in the troop
		int tmpSize = 1;
		if(this.troupUnits.isEmpty())
		{
			this.size = unitToAdd.getTroupSizeAgreement();
		}
		else
		{
			while(this.troupUnits.iterator().hasNext())
			{
				tmpSize++;
				if(unitToAdd.getTroupSizeAgreement() > this.size && tmpSize < this.size)
				{
					
				}
				if(unitToAdd.getTroupSizeAgreement() < this.size && tmpSize < this.size)
				{
					this.size=unitToAdd.getTroupSizeAgreement();
					/***/
				}
			}
		}
		
		
		
		//add the potential abilites of the unit to the aglomerated one in the troop
		//same for the attackDices
		//increment the stamania of the Troop
		//increment the size
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
