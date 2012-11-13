package DesktopGUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;

import GUIobjects.BackImage;


import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private JLabel chooseUrArmyLbl;
	private JPanel verticalLayoutPnl;
	private JPanel horizontalLayoutPnl;
	private JPanel raceDescriptionLayoutPnl;
	private JPanel headerLayoutPnl;
	private JPanel armyRacesPnlBack;
	private JTextArea armyDescriptionTxt;
	private JPanel btnNext;
	private JLabel lblBtnNext;
	private JPanel btnReturn;
	private JLabel lblBtnReturn;
	private JPanelWithImg separationPnl;
	
	private JScrollPane armyRacesScrollPnl;
	
	private ArrayList<ArmyRaceIcon> allArmyPnl;
	private ArrayList<String> racesAvailable;
	private int state;
	
	private MouseListener btnMouseListerner;
	
	private GuiGeneralConfig guiConfig;
	
	private boolean isAlreadyBuild;
	private String selectedRace;
	
	public RaceSelection()
	{
		super();
		isAlreadyBuild = false;
		state = 0;
		selectedRace = null;
	}
	
	public void buildRaceSelection()
	{
		isAlreadyBuild = true;
		CoreGeneralConfig  coreConfig = CoreGeneralConfig.getCoreConfigSingleton();
		guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		
		btnMouseListerner = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				if(e.getSource().equals(btnReturn))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(guiConfig.getUIColor("grey"));	
					state=1;
					hideRaceWindow();
				}
				if(e.getSource().equals(btnNext)   )
				{
					if(selectedRace != null)
					{
						JPanel Source = (JPanel)e.getSource();
						Source.setBackground(guiConfig.getUIColor("grey"));
						state=2;
						hideRaceWindow();
					}
					else
					{
						JPanel Source = (JPanel)e.getSource();
						Source.setBackground(guiConfig.getUIColor("red"));	
						
					}
					
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(e.getSource().equals(btnNext) || e.getSource().equals(btnReturn))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(guiConfig.getUIColor("blue"));
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				if(e.getSource().equals(btnNext) || e.getSource().equals(btnReturn))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(guiConfig.getUIColor("grey"));
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if(e.getSource().equals(btnNext) || e.getSource().equals(btnReturn))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(guiConfig.getUIColor("lightblue"));
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if((!e.getSource().equals(btnNext)) && (!e.getSource().equals(btnReturn)))
				{
					ArmyRaceIcon Source = (ArmyRaceIcon)e.getSource();
					armyDescriptionTxt.setText("");
					selectedRace = Source.getSelectedRace();
					armyDescriptionTxt.setText(guiConfig.getArmyDescitpions(selectedRace));
				}
			}
		};
		
		racesAvailable = coreConfig.getarmyRaces();
		
		chooseUrArmyLbl = new JLabel("Choose your army race");
		chooseUrArmyLbl.setFont(guiConfig.getStandarFont());
		chooseUrArmyLbl.setAlignmentX(CENTER_ALIGNMENT);
		
		lblBtnNext = new JLabel();
		lblBtnNext.setFont(guiConfig.getStandarFont());
		lblBtnNext.setText(">");
		btnNext = new JPanel();
		btnNext.setBackground(guiConfig.getUIColor("grey"));
		btnNext.addMouseListener(btnMouseListerner);
		btnNext.add(lblBtnNext);
		
		lblBtnReturn = new JLabel();
		lblBtnReturn.setFont(guiConfig.getStandarFont());
		lblBtnReturn.setText("<");
		btnReturn = new JPanel();
		btnReturn.setBackground(guiConfig.getUIColor("grey"));
		btnReturn.addMouseListener(btnMouseListerner);
		btnReturn.add(lblBtnReturn);
		
		headerLayoutPnl = new JPanel();
		headerLayoutPnl.setOpaque(false);
		headerLayoutPnl.setLayout(new BoxLayout(headerLayoutPnl, BoxLayout.X_AXIS));
		headerLayoutPnl.add(btnReturn);
		headerLayoutPnl.add(Box.createHorizontalGlue());
		headerLayoutPnl.add(chooseUrArmyLbl);
		headerLayoutPnl.add(Box.createHorizontalGlue());
		headerLayoutPnl.add(btnNext);
		
		allArmyPnl = new ArrayList<ArmyRaceIcon>();
		armyRacesPnlBack = new JPanel();
		armyRacesPnlBack.setLayout(new BoxLayout(armyRacesPnlBack, BoxLayout.X_AXIS));
		
		armyRacesPnlBack.add(Box.createHorizontalGlue());
		for(String tmp : racesAvailable)
		{
			ArmyRaceIcon tmpPnl = new ArmyRaceIcon(tmp);
			tmpPnl.addMouseListener(btnMouseListerner);
			allArmyPnl.add(tmpPnl);
			armyRacesPnlBack.add(tmpPnl);
			armyRacesPnlBack.add(Box.createHorizontalStrut(5));
		}
		armyRacesPnlBack.add(Box.createHorizontalGlue());
		armyRacesPnlBack.setBackground(guiConfig.getUIColor("grey"));
		
		armyRacesScrollPnl = new JScrollPane(armyRacesPnlBack);
		armyRacesScrollPnl.setAutoscrolls(true);
		armyRacesScrollPnl.setBorder(BorderFactory.createEmptyBorder());
		armyRacesScrollPnl.setMaximumSize(armyRacesScrollPnl.getPreferredSize());
		
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl,BoxLayout.X_AXIS));
		horizontalLayoutPnl.add(Box.createHorizontalStrut(200));
		horizontalLayoutPnl.add(armyRacesScrollPnl);
		horizontalLayoutPnl.add(Box.createHorizontalGlue());
		horizontalLayoutPnl.setBackground(Color.BLUE);
		//BackImage separator = guiConfig.getGeneralImage("SeparatorVImg");
		//separationPnl = new JPanelWithImg(separator.getFinalImage());
		//separationPnl.setAlignmentX(CENTER_ALIGNMENT);
		
		armyDescriptionTxt = new JTextArea();
		armyDescriptionTxt.setEditable(false);
		armyDescriptionTxt.setFont(guiConfig.getToolTipFont());
		armyDescriptionTxt.append("description de l'armée de la mort qui tue vraiment la mort");
		armyDescriptionTxt.setPreferredSize(new Dimension(400,200));
		armyDescriptionTxt.setOpaque(false);
		
		raceDescriptionLayoutPnl = new JPanel();
		raceDescriptionLayoutPnl.setLayout(new BoxLayout(raceDescriptionLayoutPnl, BoxLayout.X_AXIS));
		raceDescriptionLayoutPnl.add(armyDescriptionTxt);
		raceDescriptionLayoutPnl.setOpaque(false);
		
		verticalLayoutPnl = new JPanel();
		verticalLayoutPnl.setLayout(new BoxLayout(verticalLayoutPnl, BoxLayout.Y_AXIS));
		verticalLayoutPnl.add(headerLayoutPnl);
		verticalLayoutPnl.add(armyDescriptionTxt);
		verticalLayoutPnl.add(armyRacesScrollPnl);
		//raceDescriptionLayoutPnl.add(separationPnl);
		
		verticalLayoutPnl.setOpaque(false);
		this.add(verticalLayoutPnl);
		this.setBackground(guiConfig.getUIColor("grey"));
		
	}
	public boolean isBuilt()
	{
		return this.isAlreadyBuild;
	}
	
	public int getState()
	{
		return this.state;
	}
	private void hideRaceWindow()
	{
		this.setVisible(false);
	}


}
