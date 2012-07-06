package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	private GeneralConfig globalConfigSettings;
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
	
	
	
	public void Load() throws IOException, ParseException
	{
		LoadGeneralConfig();
		//LoadArmyConfig();
	}
	
	private void LoadGeneralConfig() throws IOException, ParseException
	{
		fileReader = new FileReader("configFiles/generalConfig");
		
		generalConfigJsonObj = (JSONObject) parser.parse(fileReader);
		
		Map DefaultSizeMap  =  (Map) generalConfigJsonObj.get("DefaultSize");
		
		globalConfigSettings.setDefaultSize(Integer.parseInt(DefaultSizeMap.get("width").toString()), Integer.parseInt(DefaultSizeMap.get("high").toString()));
		//System.out.println(DefaultSizeMap.get("ArmySaveFolder").toString());
		globalConfigSettings.setArmySaveFolder(generalConfigJsonObj.get("ArmySaveFolder").toString());
		globalConfigSettings.setArmyDB(generalConfigJsonObj.get("ArmyDB").toString());
		globalConfigSettings.setArmyConfigFiles((ArrayList<String>)generalConfigJsonObj.get("ArmyConfigFiles"));
		
		Map allGeneralImg  = (Map) generalConfigJsonObj.get("GeneralImages");
		
		anIterator = allGeneralImg.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry entry = (Map.Entry)anIterator.next();
				globalConfigSettings.addGeneralImage(entry.getKey().toString(),entry.getValue().toString());
			
		}
		
		Map allColors  = (Map) generalConfigJsonObj.get("UIColors");
		
		anIterator = allColors.entrySet().iterator();
		while(anIterator.hasNext())
		{
				Map.Entry entry = (Map.Entry)anIterator.next();
				globalConfigSettings.addBtnColor(entry.getKey().toString(),(ArrayList<String>)entry.getValue());
			
		}
	}
	
	public GeneralConfig getGlobalConfigSettings()
	{
		return globalConfigSettings;
	}
	
}
