package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.parser.ParseException;

import GUIobjects.BackImage;
import GUIobjects.UnitGui;


public class GuiGeneralConfig 
{
	private static GuiGeneralConfig singleton;
	
	private ConfigFileLoader GuiConfLoader;
	private String ArmySaveFolder;
	private ArrayList<String> ArmyConfigFiles;
	private ArrayList<BackImage> GeneralImages;
	private ArrayList<UIColor> UIColors;
	private Map<String, ArrayList<UnitGui>> GUIunit;
	private Font purissaFont;
	
	private GuiGeneralConfig()
	{
		GeneralImages = new ArrayList<BackImage>();
		ArmyConfigFiles = new ArrayList<String>();
		UIColors = new ArrayList<UIColor>();
	}
	
	public static GuiGeneralConfig getGeneralConfigSingleton ()
	{
		if (singleton == null)
		{
			singleton = new GuiGeneralConfig();
		}
		return singleton;
	}
	
	public void loadGuiConfig() throws IOException, ParseException, FontFormatException
	{
		GuiConfLoader = ConfigFileLoader.getConfigFileLoaderSingleton();
		this.setArmySaveFolder(GuiConfLoader.retrieveArmySaveFolder());
		this.setArmyConfigFiles(GuiConfLoader.retrieveArmyConfigFiles());
		this.setGuiGeneralImage(GuiConfLoader.retrieveGeneralImages());
		this.setUIColor(GuiConfLoader.retrieveUIColor());
		this.setFont(GuiConfLoader.retrieveFont());
	}

	private void setArmySaveFolder(String armySaveFolder) {
		ArmySaveFolder = armySaveFolder;
	}

	private void setArmyConfigFiles(ArrayList<String> armyConfigFiles) 
	{
		ArmyConfigFiles = armyConfigFiles;
	}

	private void setGuiGeneralImage(Map<String,List<String>> ImageMap) 
	{	
		Iterator<Entry<String,List<String>>> anIterator = ImageMap.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>)anIterator.next();
				BackImage imageToAdd = new BackImage(entry.getKey().toString(), ((ArrayList<String>) entry.getValue()).get(0), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(1)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(2)));
				GeneralImages.add(imageToAdd);
		}
	}
	
	private void setUIColor(Map<String, List<String>> ColorMap) 
	{
		Iterator<Entry<String,List<String>>> anIterator = ColorMap.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>)anIterator.next();
				UIColor colorsToAdd = new UIColor(entry.getKey().toString(), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(0)), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(1)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(2)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(3)));
				UIColors.add(colorsToAdd);
		}
	}
	
	private void setFont(String pathToFont) throws FontFormatException, IOException
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
