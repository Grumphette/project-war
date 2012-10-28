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
	//represents the model to observe
	private CoreGame model;
	
	private CoreGeneralConfig coreConfig;
	private ArrayList<String> racesAvailable;
	
	
	public RaceSelection(CoreGame model)
	{
		super();
		this.model = model;
	}
	
	public void buildRaceSelection()
	{
		model.addObserver(this);
		coreConfig = CoreGeneralConfig.getCoreConfigSingleton();
		model.askArmyRaces();
	}

	@Override
	public void update(Observable obs, Object obj)
	{
		
	}

}
