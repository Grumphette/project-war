package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	private ArrayList<BackImage> ArmyIcons;
	private Map<String, String> ArmyDescriptions; 
	private ArrayList<UIColor> UIColors;
	private Map<String, ArrayList<UnitGui>> GUIunit;
	private Map<String,Font> FontGui;
	
	private GuiGeneralConfig()
	{
		GeneralImages = new ArrayList<BackImage>();
		ArmyIcons =	 new ArrayList<BackImage>();
		ArmyConfigFiles = new ArrayList<String>();
		UIColors = new ArrayList<UIColor>();
		ArmyDescriptions = new HashMap<String, String>();
		FontGui = new HashMap<String, Font>();
	}
	
	public static GuiGeneralConfig getGuiConfigSingleton ()
	{
		if (singleton == null)
		{
			singleton = new GuiGeneralConfig();
		}
		return singleton;
	}
	
	public void loadGuiConfig()
	{
		GuiConfLoader = ConfigFileLoader.getConfigFileLoaderSingleton();
		
		this.setArmySaveFolder(GuiConfLoader.retrieveArmySaveFolder());
		this.setGuiGeneralImage(GuiConfLoader.retrieveGeneralImages());
		this.setUIColor(GuiConfLoader.retrieveUIColor());
		this.setFont(GuiConfLoader.retrieveFont());
		this.setArmyIcons(GuiConfLoader.retrieveArmyIcons());
		this.setArmyDescriptions(GuiConfLoader.retrieveArmyDescription());
	}

	private void setArmySaveFolder(String armySaveFolder) {
		ArmySaveFolder = armySaveFolder;
	}

	private void setGuiGeneralImage(Map<String,List<String>> ImageMap) 
	{	
		Iterator<Entry<String,List<String>>> anIterator = ImageMap.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry<String, List<String>> entry = anIterator.next();
				BackImage imageToAdd = new BackImage(entry.getKey().toString(), ((ArrayList<String>) entry.getValue()).get(0), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(1)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(2)));
				GeneralImages.add(imageToAdd);
		}
	}
	
	private void setUIColor(Map<String, List<String>> ColorMap) 
	{
		Iterator<Entry<String,List<String>>> anIterator = ColorMap.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry<String, List<String>> entry = anIterator.next();
				UIColor colorsToAdd = new UIColor(entry.getKey().toString(), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(0)), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(1)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(2)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(3)));
				UIColors.add(colorsToAdd);
		}
	}
	private void setArmyIcons(Map<String,List<String>> ImageMap)
	{
		Iterator<Entry<String,List<String>>> anIterator = ImageMap.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry<String, List<String>> entry = anIterator.next();
				BackImage imageToAdd = new BackImage(entry.getKey().toString(), ((ArrayList<String>) entry.getValue()).get(0), Integer.parseInt(((ArrayList<String>) entry.getValue()).get(1)),Integer.parseInt(((ArrayList<String>) entry.getValue()).get(2)));
				ArmyIcons.add(imageToAdd);
		}
	}
	
	private void setArmyDescriptions(Map<String, String> Descriptionsmap)
	{
		this.ArmyDescriptions = Descriptionsmap;
	}
	
	private void setFont(List<String> fontAttribute)
	{
		Font tmpFont = null;
		try 
		{
			tmpFont = Font.createFont(Font.TRUETYPE_FONT,new File(fontAttribute.get(0)));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		FontGui.put("standard", tmpFont.deriveFont(Font.BOLD, Integer.parseInt(fontAttribute.get(1))));
		FontGui.put("tooltip", tmpFont.deriveFont(Font.BOLD, Integer.parseInt(fontAttribute.get(2))));
	}
	
	
	public ArrayList<String> getArmyConfigFiles()
	{
		return ArmyConfigFiles;
	}
	
	public Font getStandarFont()
	{
		return FontGui.get("standard");
	}
	
	public Font getToolTipFont()
	{
		return FontGui.get("tooltip");
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
	
	public BackImage getGeneralImage(String Name)
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
	public BackImage getArmyIcons(String Name)
	{
		for(BackImage img : ArmyIcons)
		{
			if(img.getName().equals(Name))
			{
				return  img.getImage();
			}
		}
		return null;
	}
	
	public String getArmyDescitpions(String Name)
	{
		Iterator<Entry<String,String>> anIterator = ArmyDescriptions.entrySet().iterator();
		while(anIterator.hasNext())
		{
			Map.Entry<String, String> entry = anIterator.next();
			if(entry.getKey().equals(Name))
			{
				return entry.getValue();
			}
		}
		return null;
	}
}
