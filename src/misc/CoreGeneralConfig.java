package misc;

import java.util.ArrayList;

public class CoreGeneralConfig 
{
	private static CoreGeneralConfig singleton;
	private ArmyDataBaseConnector ArmyDBC;
	private ConfigFileLoader configFile;
	
	
	private CoreGeneralConfig ()
	{
		configFile = ConfigFileLoader.getConfigFileLoaderSingleton();
		ArmyDBC = new ArmyDataBaseConnector();
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
	}
	
	private void setArmyDBPath (String dbPath)
	{
		ArmyDBC.setPath(dbPath);
	}
	
	public ArmyDataBaseConnector dbc()
	{
		return ArmyDBC;
	}
}
