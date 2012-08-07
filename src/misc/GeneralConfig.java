package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GUIobjects.BackImage;
import GUIobjects.UnitGui;


public class GeneralConfig 
{
	private static GeneralConfig singleton;
	
	private Dimension2D DefaultSize;
	private String ArmySaveFolder;
	private String ArmyDB;
	private ArrayList<String> ArmyConfigFiles;
	private ArrayList<BackImage> GeneralImages;
	private ArrayList<UIColor> UIColors;
	private Map<String, ArrayList<UnitGui>> GUIunit;
	private Font purissaFont;
	
	private GeneralConfig()
	{
		GeneralImages = new ArrayList<BackImage>();
		ArmyConfigFiles = new ArrayList<String>();
		UIColors = new ArrayList<UIColor>();
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

	public void addGeneralImage(String Name, List<String> attributes) 
	{
		BackImage imageToAdd = new BackImage(Name, attributes.get(0), Integer.parseInt(attributes.get(1)),Integer.parseInt(attributes.get(2)));
		GeneralImages.add(imageToAdd);
	}
	
	public void addBtnColor(String Name, List<String> RGBA) 
	{
		UIColor colorsToAdd = new UIColor(Name, Integer.parseInt(RGBA.get(0)),Integer.parseInt(RGBA.get(1)),Integer.parseInt(RGBA.get(2)),Integer.parseInt(RGBA.get(3)));
		UIColors.add(colorsToAdd);
	}
	
	public void createFont(String pathToFont) throws FontFormatException, IOException
	{
		
		purissaFont = Font.createFont(Font.TRUETYPE_FONT,new File(pathToFont));
		purissaFont = purissaFont.deriveFont(Font.BOLD, 14);
		
	}
	
	public Font getFont()
	{
		return purissaFont;
	}
	
	public Color getUIColor(String Name)
	{
		for(UIColor UICol : UIColors)
		{
			if(UICol.GetBtnState().equals(Name))
			{
				return  UICol.getColor();
			}
		}
		return null;
	}
	
	public BackImage getGeneralImage(String Name) throws IOException
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
