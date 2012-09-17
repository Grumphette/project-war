package misc;

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
	
	public static CoreGeneralConfig getGeneralConfigSingleton ()
	{
		if (singleton == null)
		{
			singleton = new CoreGeneralConfig();
		}
		return singleton;
	}
	
	public void LoadCoreConfig()
	{
		this.setArmyDBPath(configFile.retrieveArmyDBPath());
	}
	private void setArmyDBPath (String dbPath)
	{
		ArmyDBC.setPath(dbPath);
	}
}
