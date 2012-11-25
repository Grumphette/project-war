package GUIobjects;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.GuiGeneralConfig;

import DesktopGUI.JPanelWithImg;

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
		raceLbl.setFont(guiConfig.getToolTipFont());
		raceLbl.setAlignmentX(CENTER_ALIGNMENT);
		raceIcon = guiConfig.getArmyIcons(race);
		raceIconPnl = new JPanelWithImg(raceIcon.getFinalImage());
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(raceIconPnl);
		this.add(Box.createVerticalStrut(2));
		this.add(raceLbl);
		this.setBackground(guiConfig.getUIColor("grey"));
		this.setMaximumSize(new Dimension(raceIcon.getImgSize().width,raceIcon.getImgSize().height+2+raceLbl.getPreferredSize().height));
	}
	
	public String getSelectedRace()
	{
		return this.race;
	}
	public Dimension getSize()
	{
		return this.getMaximumSize();
	}

}
