package Main;

import misc.ArmyDataBaseConnector;
import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;
import Core.CoreGame;
import DesktopGUI.MainWindow;

/** Special fonts have to be installed in  the ~/.fonts */


public class Main {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		//Starting the Game core, that will handle the game
		CoreGame gcore = new CoreGame();
		
		//Starting the Gui
		MainWindow window = new MainWindow();
	}
}
