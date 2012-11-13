package DesktopGUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.GuiGeneralConfig;

import GUIobjects.BackImage;

public class ArmyRaceIcon extends JPanel 
{
	private String race;
	private JLabel raceLbl;
	private BackImage raceIcon;
	private JPanelWithImg raceIconPnl;
	
	public ArmyRaceIcon(String race)
	{
		GuiGeneralConfig guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		
		this.race = race;
		raceLbl = new JLabel(this.race);
		raceLbl.setAlignmentX(CENTER_ALIGNMENT);
		raceLbl.setFont(guiConfig.getToolTipFont());
		raceIcon = guiConfig.getArmyIcons(race);
		raceIconPnl = new JPanelWithImg(raceIcon.getFinalImage());
		raceIconPnl.setPreferredSize(raceIcon.getImgSize());
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(raceIconPnl);
		this.add(Box.createVerticalStrut(2));
		this.add(raceLbl);
		this.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 2));
		
	}
	
	public String getSelectedRace()
	{
		return this.race;
	}

}
