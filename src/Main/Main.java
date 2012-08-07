package Main;

import misc.ConfigFileHandler;
import DesktopGUI.MainWindow;

/** Special fonts have to be installed in  the ~/.fonts */


public class Main {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		ConfigFileHandler config = ConfigFileHandler.getConfigFileHandler();
		try 
		{
			config.Load();
			MainWindow window = new MainWindow();
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
		
		
	}

}
