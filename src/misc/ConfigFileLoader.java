package misc;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @brief The goal of this class is to load the 
 * Json configuration file */

public class ConfigFileLoader
{	
	private static ConfigFileLoader singleton;
	
	private JSONParser parser;
	private Map<String,JSONObject> generalConfigJsonObj;

	private ConfigFileLoader()
	{
		parser = new JSONParser();
		generalConfigJsonObj = new HashMap<String,JSONObject>();
		
		this.openAllConfigFiles();
	}
	
	private void openAllConfigFiles()
	{
		try 
		{
			generalConfigJsonObj.put("generalConfig",(JSONObject) parser.parse(new FileReader("configFiles/generalConfig")));
			
			for (String tmp : this.retrieveArmyConfigFiles())
			{
				generalConfigJsonObj.put(tmp.split("/")[1],(JSONObject) parser.parse(new FileReader(tmp)));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static ConfigFileLoader getConfigFileLoaderSingleton ()
	{
		if (singleton == null)
		{
				singleton = new ConfigFileLoader();
		}
		return singleton;
	}
	
	public String retrieveArmySaveFolder()
	{
		String toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			Map.Entry<String, JSONObject> entry = anIterator.next();
			toReturn = entry.getValue().get("ArmySaveFolder").toString();
			if(toReturn != null)
			{
				return toReturn;
			}
		}
		return null;
	}
	
	public String retrieveArmyDBPath()
	{
		String toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			Map.Entry<String, JSONObject> entry = anIterator.next();
			toReturn = entry.getValue().get("ArmyDB").toString();
			if(toReturn != null)
			{
				return toReturn;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> retrieveArmyConfigFiles()
	{
		
		ArrayList<String> toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			 Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			 toReturn = (ArrayList<String>) entry.getValue().get("ArmyConfigFiles");
			 if(toReturn != null)
			 {
				 return toReturn;
			 }
		}
		return null;
	}
	
	public String retrieveFont()
	{
		String toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			 Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			 toReturn = entry.getValue().get("Font").toString();
			 if(toReturn != null)
			 {
				 return toReturn;
			 }
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> retrieveGeneralImages()
	{
		Map<String,List<String>> toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			 Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			 toReturn = (Map<String,List<String>>) entry.getValue().get("GeneralImages");
			 if(toReturn != null)
			 {
				 return toReturn;
			 }
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> retrieveUIColor()
	{
		Map<String,List<String>> toReturn = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		while(anIterator.hasNext())
		{
			 Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			 toReturn = (Map<String,List<String>>) entry.getValue().get("UIColors");
			 if(toReturn != null)
			 {
				 return toReturn;
			 }
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> retrieveArmyIcons()
	{
		Map<String,List<String>> toReturn = new HashMap<String,List<String>>();
		List<String> armyIconsInfo;
		String tmpRace = null;
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		
		while(anIterator.hasNext())
		{
			Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			if(entry.getValue().get("armyIcon") != null)
			{				
				armyIconsInfo = (List<String>) entry.getValue().get("armyIcon");
				tmpRace = entry.getKey().split("Config")[0];
				
				toReturn.put(tmpRace, armyIconsInfo);
			}
		}
		return toReturn;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,String> retrieveArmyDescription()
	{
		Map<String,String> toReturn = new HashMap<String,String>();
		String tmpRace = null;
		String tmpDescription = null;
		
		Iterator<Entry<String,JSONObject>> anIterator = generalConfigJsonObj.entrySet().iterator();
		
		while(anIterator.hasNext())
		{
			Map.Entry<String, JSONObject> entry = anIterator.next();
			 
			if(entry.getValue().get("history") != null)
			{				
				tmpDescription = entry.getValue().get("history").toString();
				tmpRace = entry.getKey().split("Config")[0];
				
				toReturn.put(tmpRace, tmpDescription);
			}
		}
		return toReturn;
	}
	
}
