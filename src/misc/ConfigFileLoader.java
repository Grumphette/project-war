package misc;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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
	private ArrayList<JSONObject> generalConfigJsonObj;
	
	private ConfigFileLoader()
	{
		parser = new JSONParser();
		generalConfigJsonObj = new ArrayList<JSONObject>();
	}
	
	public void addConfigFileToLoad(String path)
	{
		FileReader tmp;
		try 
		{
			tmp = new FileReader(path);
			generalConfigJsonObj.add((JSONObject) parser.parse(tmp));
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = tmp.get("ArmySaveFolder").toString();
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = tmp.get("ArmyDB").toString();
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = (ArrayList<String>)tmp.get("ArmyConfigFiles");
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = tmp.get("Font").toString();
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = (Map<String,List<String>>) tmp.get("GeneralImages");
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
		for(JSONObject tmp : generalConfigJsonObj)
		{
			 toReturn = (Map<String,List<String>>) tmp.get("UIColors");
			 if(toReturn != null)
			 {
				 return toReturn;
			 }
		}
		return null;
	}
	
}
