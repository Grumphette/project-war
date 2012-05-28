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
	GeneralConfig globalConfigSettings;
	//ArmyConfig armyConfigSettings;
	JSONParser parser;
	FileReader fileReader;
	JSONObject generalConfigJsonObj;
	Iterator anIterator;
	
	public ConfigFileHandler() 
	{
		parser = new JSONParser();
		globalConfigSettings = GeneralConfig.getGeneralConfig();
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
		
		Map DefaultSizeMap  = (Map) generalConfigJsonObj.get("DefaultSize");
		
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
		
		
	}
	
}
