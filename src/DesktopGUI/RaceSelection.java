package DesktopGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Core.CoreGame;
import GUIobjects.BackImage;

import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private JLabel chooseUrArmyLbl;
	private JPanel verticalLayoutPnl;
	private JPanel horizontalLayoutPnl;
	private JPanel armyRacesPnlBack;
	private JLabel armyDescriptionLbl;
	private JPanel armyLayout;
	private JPanel btnLayoutPnl;
	
	private JScrollPane armyRacesScrollPnl;
	
	private ArrayList<JPanel> allArmyPnl;
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
		
		
		chooseUrArmyLbl = new JLabel("Choose your army race");
		
		
		armyRacesPnlBack = new JPanel();
		armyRacesPnlBack.setLayout(new BoxLayout(armyRacesPnlBack, BoxLayout.X_AXIS));
		for(String tmp : racesAvailable)
		{
			BackImage tmpIcons = guiConfig.getGeneralImage(tmp);
			
			//Logo = new JPanelWithImg(LogImgInfo.getFinalImage());
		}
		
		
		
		
		
		
		armyRacesScrollPnl = new JScrollPane();
		
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl, BoxLayout.X_AXIS));
		
		
		racesAvailable = coreConfig.getarmyRaces();
		
		
		verticalLayoutPnl = new JPanel();
		verticalLayoutPnl.setLayout(new BoxLayout(verticalLayoutPnl, BoxLayout.Y_AXIS));
		verticalLayoutPnl.add(chooseUrArmyLbl);
		
		this.add(verticalLayoutPnl);
		
		
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
