package Core;

import java.util.Random;

/** @brief Describe the abstract class Dice, 
  * It can be used as static dice within the unit action dice,
  *  or as one time rolling dice during battle*/

public abstract class Dice 
{
	
	
	private int diceValue; /**< @brief dice Value set at the Unit Creation, or when a dice is rolled*/
	private String diceType; /**< @brief dice Type set at the Unit Creation, or to discriminate the rolled dice*/
	
	/**@brief random dice generation function*/
	static private Random randomNum = new Random();
	
	/**
	 * @brief initialize a Dice with a specific value
	 * @param val value of the dice
	 * @param type type of the dice (range or close combat)
	 * */
	public Dice(int val, String type)
	{
		this.diceValue = val;
		this.diceType = type;
	}
	
	/**
	 * @brief initialize a Dice with a random value
	 * @param type type of the dice (range or close combat)
	 * */
	public Dice(String type)
	{
		this.diceValue = (randomNum.nextInt(6)+1);
		this.diceType = type;
	}

	/**
	 * @brief Roll a 6 faced dice
	 * @return value value of the rolled dice
	 */
	public int rollDice()
	{
		return (randomNum.nextInt(6)+1);
	}
	
	/**
	 * @brief Return the dice values from the unit available dices
	 * @return value value of the dice
	 */
	public int getDiceValue() 
	{
		return diceValue;
	}

	/**
	 * @brief Return the dice type (range or close combat) from the unit available dices
	 * @return value value of the dice
	 */
	public String getDiceType() 
	{
		return diceType;
	}
}
