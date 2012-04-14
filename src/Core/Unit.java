package Core;

import java.util.ArrayList;

public class Unit {
	
	
	private String name;
	private int commandPrice;
	private int troupSizeAgreement;
	private ArrayList<Ability> grantedAbilities; 
	private ArrayList<Dice> attackDices;
	private int stamania;
	
	public Unit(String name, int price, int sizeAgreement, ArrayList<Ability> abilities, ArrayList<Dice> dices, int stamania)
	{
		this.name = name;
		this.commandPrice = price;
		this.troupSizeAgreement = sizeAgreement;
		this.grantedAbilities = abilities;
		this.attackDices = dices;
		this.stamania = stamania;
	}

	public String getName() {
		return name;
	}

	public int getCommandPrice() {
		return commandPrice;
	}

	public int getTroupSizeAgreement() {
		return troupSizeAgreement;
	}

	public ArrayList<Ability> getGrantedAbilities() {
		return grantedAbilities;
	}

	public ArrayList<Dice> getAttackDices() {
		return attackDices;
	}

	public int getStamania() {
		return stamania;
	}

	

	
	
}
