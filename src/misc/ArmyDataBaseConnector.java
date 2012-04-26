package misc;

import java.sql.*;
import java.util.ArrayList;

import Core.Unit;
public class ArmyDataBaseConnector 
{
	private ArrayList<Unit> armyListing;
	
	public ArmyDataBaseConnector()
	{
		armyListing = new ArrayList<Unit>();
	}
	
	public ArrayList<Unit> getAllTheUnitDescription(String armyRace)
	{
		return null;
	}
	//we have to connect to the database
	//load all units when the race is chosen
	//store all the results in a ArrayList and then provide it to the calling object
}
