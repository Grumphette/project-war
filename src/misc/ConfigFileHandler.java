package misc;

import java.awt.FontFormatException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @brief The goal of this class is to load the 
 * Json configuration file */

public class ConfigFileHandler
{
	private static ConfigFileHandler singleton;
	
	private static GeneralConfig globalConfigSettings;
	//ArmyConfig armyConfigSettings;
	private JSONParser parser;
	private FileReader fileReader;
	private JSONObject generalConfigJsonObj;
	private Iterator<Object> anIterator;
	
	private ConfigFileHandler() 
	{
		parser = new JSONParser();
		globalConfigSettings = GeneralConfig.getGeneralConfig();
	}
	
	public static ConfigFileHandler getConfigFileHandler ()
	{
		if (singleton == null)
		{
			singleton = new ConfigFileHandler();
		}
		return singleton;
	} 
	
	
	
	public void Load() throws IOException, ParseException, FontFormatException
	{
		LoadGeneralConfig();
		//LoadArmyConfig();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void LoadGeneralConfig() throws IOException, ParseException, FontFormatException
	{
		fileReader = new FileReader("configFiles/generalConfig");
		
		generalConfigJsonObj = (JSONObject) parser.parse(fileReader);
		
		//System.out.println(DefaultSizeMap.get("ArmySaveFolder").toString());
		globalConfigSettings.setArmySaveFolder(generalConfigJsonObj.get("ArmySaveFolder").toString());
		globalConfigSettings.setArmyDB(generalConfigJsonObj.get("ArmyDB").toString());
		globalConfigSettings.setArmyConfigFiles((ArrayList<String>)generalConfigJsonObj.get("ArmyConfigFiles"));
		globalConfigSettings.createFont(generalConfigJsonObj.get("Font").toString());
		
		
		Map allGeneralImg  = (Map) generalConfigJsonObj.get("GeneralImages");
		
		anIterator = allGeneralImg.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry entry = (Map.Entry)anIterator.next();
				globalConfigSettings.addGeneralImage(entry.getKey().toString(),(ArrayList<String>)entry.getValue());
			
		}
		
		Map allColors  = (Map) generalConfigJsonObj.get("UIColors");
		
		anIterator = allColors.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry entry = (Map.Entry)anIterator.next();
				globalConfigSettings.addBtnColor(entry.getKey().toString(),(ArrayList<String>)entry.getValue());
			
		}
	}
	
	public static GeneralConfig getGlobalConfigSettings()
	{
		return globalConfigSettings;
	}
	
}
