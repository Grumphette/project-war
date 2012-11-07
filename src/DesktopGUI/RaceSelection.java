package DesktopGUI;


import java.util.ArrayList;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;


import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private JLabel chooseUrArmyLbl;
	private JPanel verticalLayoutPnl;
	private JPanel horizontalLayoutPnl;
	private JPanel armyRacesPnlBack;
	private JTextArea armyDescriptionLbl;
	private JPanel armyLayout;
	private JPanel btnLayoutPnl;
	
	private JScrollPane armyRacesScrollPnl;
	
	private ArrayList<ArmyRaceIcon> allArmyPnl;
	private ArrayList<String> racesAvailable;
	private Map<String,String> racesDescription;
	private int state;
	
	private GuiGeneralConfig guiConfig;
	
	public RaceSelection()
	{
		super();
	}
	
	public void buildRaceSelection()
	{
		CoreGeneralConfig  coreConfig = CoreGeneralConfig.getCoreConfigSingleton();
		guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		
		racesAvailable = coreConfig.getarmyRaces();
		
		chooseUrArmyLbl = new JLabel("Choose your army race");
		chooseUrArmyLbl.setAlignmentX(CENTER_ALIGNMENT);
		
		allArmyPnl = new ArrayList<ArmyRaceIcon>();
		armyRacesPnlBack = new JPanel();
		armyRacesPnlBack.setLayout(new BoxLayout(armyRacesPnlBack, BoxLayout.Y_AXIS));
		for(String tmp : racesAvailable)
		{
			ArmyRaceIcon tmpPnl = new ArmyRaceIcon(tmp);
			allArmyPnl.add(tmpPnl);
			armyRacesPnlBack.add(tmpPnl);
		}
		
		armyRacesScrollPnl = new JScrollPane(armyRacesPnlBack);
		armyRacesScrollPnl.setAutoscrolls(true);
		armyRacesScrollPnl.setVerticalScrollBarPolicy(ScrollPaneLayout.VERTICAL_SCROLLBAR_NEVER);
		
		armyDescriptionLbl = new JTextArea();
		armyDescriptionLbl.setEditable(false);
		armyDescriptionLbl.setOpaque(false);
		armyDescriptionLbl.append("description de l'armée de la mort qui tue vraiment la mort");
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl, BoxLayout.X_AXIS));
		horizontalLayoutPnl.add(armyRacesScrollPnl);
		horizontalLayoutPnl.add(Box.createHorizontalGlue());
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
