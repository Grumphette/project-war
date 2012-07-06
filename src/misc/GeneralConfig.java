package misc;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GUIobjects.BackImage;


public class GeneralConfig 
{
	private static GeneralConfig singleton;
	
	private Dimension2D DefaultSize;
	private String ArmySaveFolder;
	private String ArmyDB;
	private ArrayList<String> ArmyConfigFiles;
	private ArrayList<BackImage> GeneralImages;
	private ArrayList<BtnColor> BtnColors;
	
	private GeneralConfig()
	{
		GeneralImages = new ArrayList<BackImage>();
		ArmyConfigFiles = new ArrayList<String>();
		BtnColors = new ArrayList<BtnColor>();
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
	
	public void addBtnColor(String Name, List<String> RGBA) 
	{
		BtnColor colorsToAdd = new BtnColor(Name, Integer.parseInt(RGBA.get(0)),Integer.parseInt(RGBA.get(1)),Integer.parseInt(RGBA.get(2)),Integer.parseInt(RGBA.get(3)));
		BtnColors.add(colorsToAdd);
	}
	
	public Color getBtnColor(String Name)
	{
		for(BtnColor btnCol : BtnColors)
		{
			if(btnCol.GetBtnState().equals(Name))
			{
				return  btnCol.getColor();
			}
		}
		return null;
	}
	
	public Image getGeneralImage(String Name) throws IOException
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
