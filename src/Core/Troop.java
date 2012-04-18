package Core;

import java.util.ArrayList;




public class Troop {
	
	private int size;
	private ArrayList<Unit> troupUnits;
	
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
	}

	public void addUnit(Unit unitToAdd)
	{
		//you have to check that the unitToAdd.troupSizeAgreement is less or equal to the other Unit in the troop
		//add the potential abilites of the unit to the aglomerated one in the troop
		//same for the attackDices
		//increment the stamania of the Troop
		//increment the size
	}
	
	
	//test to construct a correct Troop
	//all units have the same troupSizeAgreement ?
	
	
	
	
}
