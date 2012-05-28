package misc;

import java.util.ArrayList;

import GUIobjects.BackImage;


public class GeneralConfig 
{
	private static GeneralConfig singleton;
	
	private Dimension2D DefaultSize;
	private String ArmySaveFolder;
	private String ArmyDB;
	private ArrayList<String> ArmyConfigFiles;
	private ArrayList<BackImage> GeneralImages; 
	
	
	private GeneralConfig()
	{
		GeneralImages = new ArrayList<BackImage>();
		ArmyConfigFiles = new ArrayList<String>();
	}
	
	public static GeneralConfig getGeneralConfig ()
	{
		if (singleton == null)
		{
			singleton = new GeneralConfig();
		}
		return singleton;
	}

	public static void setSingleton(GeneralConfig singleton) {
		GeneralConfig.singleton = singleton;
	}

	public void setDefaultSize(int width, int heigh) 
	{
		DefaultSize = new Dimension2D(width,heigh);
	}

	public void setArmySaveFolder(String armySaveFolder) {
		ArmySaveFolder = armySaveFolder;
	}

	public void setArmyDB(String armyDB) {
		ArmyDB = armyDB;
	}

	public void setArmyConfigFiles(ArrayList<String> armyConfigFiles) 
	{
		ArmyConfigFiles = armyConfigFiles;
	}

	public void addGeneralImage(String Name, String Path) 
	{
		BackImage imageToAdd = new BackImage(Name, Path);
		GeneralImages.add(imageToAdd);
	}
	
	

}
