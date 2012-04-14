package Core;

public class Game {
	
	/**
	 * The game is decomposed  in turns (taken by each one of the player alternatively) with diferent phases :
	 * 
	 * 1. Unit Redeployment  : the player can move one Troop (for free) from a sector of the battle field to an another adjacent sector
	 * 
	 * 2. Actions :
	 *	2.1. Move : Identical to Unit Redeployment by cost Energy
	 *	2.2. Charge : Move one Unit From a Front sector to the engagement sector
	 *		2.2.1. : The oposit player can intercept (charge of shoot) the attaking troop or do nothing
	 *	2.3. Carry on an engagement : the troup already engaged continue fighting against its enemy
	 *	2.4. Flee : a troup already engaged can break the formation to retreat and get back to its orginal front sector
	 *	2.5. Shoot : shoot at one enemy troup in the opposit front sector
	 *	2.6. Use a special capacity : Active a special capacity of one unit
	 *	2.7. The player can simply pass his turn 
	 * 
	 * 3. End of the turn
	 * 
	 * For each action there is special cases to be handled
	 * */
	
	public Game ()
	{
		//Initialization of the different game component
		
		//Define witch player starts, (draw a dice, the greater score starts)
		
		//while half of a player's army is not yet destroyed, continue
		
			//Execute the actions described above
		
		//if half of a player's army is destroyed, end
	}

}
