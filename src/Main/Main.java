package Main;

import java.io.IOException;

import misc.ConfigFileHandler;

import org.json.simple.parser.ParseException;

public class Main {

	
	public static void main(String[] args) 
	{
		ConfigFileHandler config = new ConfigFileHandler();
		try {
			config.Load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
