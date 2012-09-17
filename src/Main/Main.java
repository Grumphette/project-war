package Main;

import misc.GuiGeneralConfig;
import DesktopGUI.MainWindow;

/** Special fonts have to be installed in  the ~/.fonts */


public class Main {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		GuiGeneralConfig guiConfig = GuiGeneralConfig.getGeneralConfigSingleton();
		//CoreGeneralConfig coreConfig =  
		try 
		{
			guiConfig.loadGuiConfig();
			//coreConfig.loadCoreConfig();
			MainWindow window = new MainWindow();
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
		
		
	}

}
