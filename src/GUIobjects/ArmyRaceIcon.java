package GUIobjects;


import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.GuiGeneralConfig;


public class ArmyRaceIcon extends JPanel 
{
	private String race;
	private JLabel raceLbl;
	private BackImage raceIcon;
	private ConfirmationButton raceIconPnl;
	
	
	public ArmyRaceIcon(String race)
	{
		GuiGeneralConfig guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		
		this.race = race;
		raceLbl = new JLabel(this.race);
		raceLbl.setFont(guiConfig.getToolTipFont());
		
		raceIcon = guiConfig.getArmyIcons(race);
		raceIconPnl = new ConfirmationButton(raceIcon.getFinalImage());
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(raceIconPnl);
		this.add(Box.createVerticalStrut(2));
		this.add(raceLbl);
		this.setBackground(guiConfig.getUIColor("grey"));
		this.setMaximumSize(new Dimension(raceIcon.getImgSize().width,raceIcon.getImgSize().height+2+10));
	}
	
	public String getSelectedRace()
	{
		return this.race;
	}

}
