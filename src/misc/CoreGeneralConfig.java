package misc;

import java.util.ArrayList;
import java.util.Map;

import Core.Unit;

public class CoreGeneralConfig 
{
	private static CoreGeneralConfig singleton;
	private ArmyDataBaseConnector ArmyDBC;
	private ConfigFileLoader configFile;
	
	//armyRaces and armyUnits are 2 needed object
	//for the dispalay and the army building, but
	//it will not be used during the Game
	private ArrayList<String> armyRaces;
	private Map<String, ArrayList<Unit>> armyUnits;
	
	private CoreGeneralConfig ()
	{
		configFile = ConfigFileLoader.getConfigFileLoaderSingleton();
		ArmyDBC = new ArmyDataBaseConnector();
		armyRaces = new ArrayList<String>();
		//armyUnits = new Map<String, ArrayList<Unit>>();
	}
	
	public static CoreGeneralConfig getCoreConfigSingleton ()
	{
		if (singleton == null)
		{
			singleton = new CoreGeneralConfig();
		}
		return singleton;
	}
	
	public void loadCoreConfig()
	{
		this.setArmyDBPath(configFile.retrieveArmyDBPath());
		ArmyDBC.retrieveAllRaces(armyRaces);
	}
	
	private void setArmyDBPath (String dbPath)
	{
		ArmyDBC.setPath(dbPath);
	}
	
	public ArrayList<String> getarmyRaces()
	{
		return armyRaces;
	}
}
