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
	private ArrayList<String> racesAvailable;
	
	
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
			//BackImage toto = guiConfig.getGeneralImage(tmp);
			//Logo = new JPanelWithImg(LogImgInfo.getFinalImage());
		}
	}


}
