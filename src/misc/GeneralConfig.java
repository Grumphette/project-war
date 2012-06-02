package misc;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

import GUIobjects.BackImage;


public class GeneralConfig 
{
	private static GeneralConfig singleton;
	
	private Dimension2D DefaultSize;
	private String ArmySaveFolder;
	private String ArmyDB;
	private ArrayList<String> ArmyConfigFiles;
	private ArrayList<BackImage> GeneralImages;
	private Iterator<BackImage> ImageIterator;
	
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
	
	public Dimension2D getDefaultSize() 
	{
		return DefaultSize;
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
	
	public Image getGeneralImage(String Name)
	{
		for(BackImage img : GeneralImages)
		{
			if(img.getName().equals(Name))
			{
				return  img.getImage();
			}
		}
		return null;
	}
	
	

}
