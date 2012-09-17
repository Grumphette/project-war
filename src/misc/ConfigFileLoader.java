package misc;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
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

public class ConfigFileLoader
{	
	private static ConfigFileLoader singleton;
	
	private JSONParser parser;
	private FileReader fileReader;
	private JSONObject generalConfigJsonObj;
	private Iterator<Object> anIterator;
	
	private ConfigFileLoader() throws IOException, ParseException 
	{
		parser = new JSONParser();
		fileReader = new FileReader("configFiles/generalConfig");
		generalConfigJsonObj = (JSONObject) parser.parse(fileReader);
	}
	
	public static ConfigFileLoader getConfigFileLoaderSingleton ()
	{
		if (singleton == null)
		{
			try {
				singleton = new ConfigFileLoader();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public String retrieveArmySaveFolder()
	{
		return generalConfigJsonObj.get("ArmySaveFolder").toString();
	}
	
	public String retrieveArmyDBPath()
	{
		return generalConfigJsonObj.get("ArmyDB").toString();
	}
	
	public ArrayList<String> retrieveArmyConfigFiles()
	{
		return (ArrayList<String>)generalConfigJsonObj.get("ArmyConfigFiles");
	}
	
	public String retrieveFont()
	{
		return generalConfigJsonObj.get("Font").toString();
	}
	
	public Map<String,List<String>> retrieveGeneralImages()
	{
		return (Map<String,List<String>>) generalConfigJsonObj.get("GeneralImages");
	}
	
	public Map<String,List<String>> retrieveUIColor()
	{
		return (Map<String,List<String>>) generalConfigJsonObj.get("UIColors");
	}
	
}
