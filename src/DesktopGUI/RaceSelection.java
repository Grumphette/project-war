package DesktopGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Core.CoreGame;
import GUIobjects.BackImage;

import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private JPanel verticalLayoutPnl;
	private JPanel horizontalLayoutPnl;
	private JPanel armyLayout;
	private JPanel btnLayoutPnl;
	private ArrayList<String> racesAvailable;
	private int state;
	
	public RaceSelection()
	{
		super();
	}
	
	public void buildRaceSelection()
	{
		CoreGeneralConfig coreConfig = CoreGeneralConfig.getCoreConfigSingleton();
		GuiGeneralConfig guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		
		racesAvailable = coreConfig.getarmyRaces();
		for(String tmp : racesAvailable)
		{
			//BackImage tmpIcons = guiConfig.getGeneralImage(tmp);
			//Logo = new JPanelWithImg(LogImgInfo.getFinalImage());
		}
	}
	
	public int getState()
	{
		return this.state;
	}
	private void hideStartWindow()
	{
		this.setVisible(false);
	}


}
