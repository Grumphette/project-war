package DesktopGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Core.CoreGame;

import misc.CoreGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel implements Observer
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
		racesAvailable = coreConfig.getarmyRaces();
		
		for(String race : racesAvailable)
		{
			//create a new JPanelWithImage
			//
		}
	}

	@Override
	public void update(Observable obs, Object obj)
	{
		
	}

}
