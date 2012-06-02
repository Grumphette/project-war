package Main;

import java.io.IOException;
import misc.ConfigFileHandler;
import org.json.simple.parser.ParseException;
import DesktopGUI.MainWindow;

/** Special fonts have to be installed in  the ~/.fonts */


public class Main {

	
	public static void main(String[] args) 
	{
		ConfigFileHandler config = ConfigFileHandler.getConfigFileHandler();
		try 
		{
			config.Load();
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(config);
		
	}

}
