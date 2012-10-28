package Core;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

import GUIobjects.UnitGui;

import misc.ConfigFileLoader;
import misc.CoreGeneralConfig;

public class CoreGame extends Observable
{
	private static CoreGame singleton;
	
	CoreGeneralConfig coreConfig;

	private ArrayList<String> armyRaces;
	private Map<String, ArrayList<Unit>> armyUnits;
	
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
	
	private CoreGame ()
	{
		coreConfig = CoreGeneralConfig.getCoreConfigSingleton(); 
		coreConfig.loadCoreConfig();
		
		//initialization of data structures for the game
		armyRaces = new ArrayList<String>();
		
		//geting all the needed informations about the play
		coreConfig.dbc().connectToDB();
		coreConfig.dbc().retrieveAllRaces(armyRaces);
		
		
	}
	
	public void playTurn()
	{
		//Initialization of the different game component
		//Size of Army selection
		//Load Units/Abilities
		//Army Creation (store/load army ?)
	
		//Define witch player starts, (draw a dice, the greater score starts)
			//Army Placement on the battlefield
		
		//while half of a player's army is not yet destroyed, continue
		
			//Execute the actions described above
		
		//if half of a player's army is destroyed, end
	}
	public void askArmyRaces()
	{
		setChanged();
		notifyObservers(armyRaces);
	}
	
	public static CoreGame getCoreGameSingleton ()
	{
		if (singleton == null)
		{
				singleton = new CoreGame();
		}
		return singleton;
	}
}
