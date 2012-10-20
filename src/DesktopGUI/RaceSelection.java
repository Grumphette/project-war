package DesktopGUI;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import misc.CoreGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private CoreGeneralConfig coreConfig;
	private ArrayList<String> racesAvailable;
	
	
	public RaceSelection()
	{
		super();
	}
	
	public void buildRaceSelection()
	{
		coreConfig = CoreGeneralConfig.getCoreConfigSingleton();
		racesAvailable = coreConfig.getArmyDBC().getAllRaces();
	}

}
