package DesktopGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
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
	
	private ArrayList<ArmyRaceIcon> allArmyPnl;
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
		
		chooseUrArmyLbl = new JLabel("Choose your army race");
		
		allArmyPnl = new ArrayList<ArmyRaceIcon>();
		armyRacesPnlBack = new JPanel();
		armyRacesPnlBack.setLayout(new BoxLayout(armyRacesPnlBack, BoxLayout.X_AXIS));
		for(String tmp : racesAvailable)
		{
			ArmyRaceIcon tmpPnl = new ArmyRaceIcon(tmp);
			allArmyPnl.add(tmpPnl);
			armyRacesPnlBack.add(tmpPnl);
		}
		
		armyRacesScrollPnl = new JScrollPane(armyRacesPnlBack);
		armyRacesScrollPnl.setAutoscrolls(true);
		
		armyDescriptionLbl = new JLabel("TODO");
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl, BoxLayout.X_AXIS));
		horizontalLayoutPnl.add(armyRacesScrollPnl);
		horizontalLayoutPnl.add(Box.createHorizontalStrut(5));
		horizontalLayoutPnl.add(armyDescriptionLbl);
		
		
		
		
		verticalLayoutPnl = new JPanel();
		verticalLayoutPnl.setLayout(new BoxLayout(verticalLayoutPnl, BoxLayout.Y_AXIS));
		verticalLayoutPnl.add(chooseUrArmyLbl);
		verticalLayoutPnl.add(horizontalLayoutPnl);
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
