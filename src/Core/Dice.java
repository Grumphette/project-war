package Core;

import java.util.Random;

public abstract class Dice 
{
	private int diceValue;
	private String diceType;
	
	static private Random randomNum = new Random();
	
	/**
	 * @brief initialize a Dice with a specific value
	 * @param value of the dice
	 * */
	public Dice(int val, String type)
	{
		this.diceValue = val;
		this.diceType = type;
	}
	
	/**
	 * @brief initialize a Dice with a random value
	 * @param type of the dice (close combat or range combat)
	 * */
	public Dice(String type)
	{
		this.diceValue = (randomNum.nextInt(6)+1);
		this.diceType = type;
	}

	/**
	 * @brief Roll a 6 faced dice
	 * @return value of the rolled dice
	 */
	public int rollDice()
	{
		return (randomNum.nextInt(6)+1);
	}
	
	public int getDiceValue() 
	{
		return diceValue;
	}

	public String getDiceType() 
	{
		return diceType;
	}
	
	
	

}
