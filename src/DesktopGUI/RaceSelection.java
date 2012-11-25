package DesktopGUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sun.org.apache.bcel.internal.generic.PUTSTATIC;

import GUIobjects.ArmyRaceIcon;

import misc.CoreGeneralConfig;
import misc.GuiGeneralConfig;

@SuppressWarnings("serial")
public class RaceSelection extends JPanel
{
	private JLabel chooseUrArmyLbl;
	private JPanel horizontalLayoutPnl;
	private JPanel raceDescriptionLayoutPnl;
	private JPanel headerLayoutPnl;
	private JPanel armyRacesPnlBack;
	private JTextArea armyDescriptionTxt;
	private JPanel btnNext;
	private JLabel lblBtnNext;
	private JPanel btnReturn;
	private JLabel lblBtnReturn;
	//private JPanelWithImg separationPnl;
	private JPanel playersSelectedRace;
	private JPanelWithImg choiceValidationButton;
	
	private JScrollPane armyRacesScrollPnl;
	
	private ArrayList<ArmyRaceIcon> allArmyPnl;
	private ArrayList<String> racesAvailable;
	private int state;
	
	private MouseListener btnMouseListerner;
	
	private GuiGeneralConfig guiConfig;
	
	private boolean isAlreadyBuild;
	private String selectedRace;
	
	private int numberOfHumanPlayer;
	private int numberOfSelectedRace;
	
	private int i;
	
	public RaceSelection()
	{
		super();
		isAlreadyBuild = false;
		state = 0;
		selectedRace = null;
		this.numberOfHumanPlayer = 0;
	}
	
	public void buildRaceSelection(int numberOfHumanPlayer)
	{
		this.numberOfHumanPlayer = numberOfHumanPlayer;
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
				if(e.getSource().equals(btnNext))
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
					
					JLabel tmpLbl = new JLabel(selectedRace);
					tmpLbl.setFont(guiConfig.getToolTipFont());
					playersSelectedRace.add(tmpLbl);
					
					numberOfSelectedRace++;
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
		for(String tmp : racesAvailable)
		{
			ArmyRaceIcon tmpPnl = new ArmyRaceIcon(tmp);
			tmpPnl.addMouseListener(btnMouseListerner);
			allArmyPnl.add(tmpPnl);
			armyRacesPnlBack.add(tmpPnl);
			armyRacesPnlBack.add(Box.createHorizontalStrut(5));
		}
		
		
		armyRacesPnlBack.setBackground(guiConfig.getUIColor("grey"));
		
		armyRacesScrollPnl = new JScrollPane(armyRacesPnlBack);
		armyRacesScrollPnl.setAutoscrolls(true);
		armyRacesScrollPnl.setBorder(BorderFactory.createEmptyBorder());
		armyRacesScrollPnl.setMaximumSize(new Dimension(300,90));
		
		choiceValidationButton = new JPanelWithImg(guiConfig.getGeneralImage("ValidationImg").getFinalImage());
		
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl,BoxLayout.X_AXIS));
		horizontalLayoutPnl.add(armyRacesScrollPnl);
		horizontalLayoutPnl.add(Box.createHorizontalStrut(100-choiceValidationButton.getPreferredSize().width));
		horizontalLayoutPnl.add(choiceValidationButton);
		horizontalLayoutPnl.setOpaque(false);
		
		//BackImage separator = guiConfig.getGeneralImage("SeparatorVImg");
		//separationPnl = new JPanelWithImg(separator.getFinalImage());
		//separationPnl.setAlignmentX(CENTER_ALIGNMENT);
		
		armyDescriptionTxt = new JTextArea();
		armyDescriptionTxt.setEditable(false);
		armyDescriptionTxt.setFont(guiConfig.getToolTipFont());
		armyDescriptionTxt.setText("please select a race below to get its history background");
		armyDescriptionTxt.setPreferredSize(new Dimension(400,200));
		armyDescriptionTxt.setOpaque(false);
		
		raceDescriptionLayoutPnl = new JPanel();
		raceDescriptionLayoutPnl.setLayout(new BoxLayout(raceDescriptionLayoutPnl, BoxLayout.X_AXIS));
		raceDescriptionLayoutPnl.add(armyDescriptionTxt);
		raceDescriptionLayoutPnl.setOpaque(false);
		//raceDescriptionLayoutPnl.add(separationPnl);
		
		
		playersSelectedRace = new JPanel();
		playersSelectedRace.setOpaque(false);
		playersSelectedRace.setLayout(new GridLayout(2,this.numberOfHumanPlayer));
		for(Integer i=1;i<= this.numberOfHumanPlayer;i++)
		{
			JLabel tmpJlbl = new JLabel("Joueur"+i.toString());
			tmpJlbl.setFont(guiConfig.getToolTipFont());
			playersSelectedRace.add(tmpJlbl);
		}
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(headerLayoutPnl);
		this.add(armyDescriptionTxt);
		this.add(playersSelectedRace);
		this.add(horizontalLayoutPnl);
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
	public void resetChoise()
	{
		this.selectedRace = null;
		this.armyDescriptionTxt.setText("please select a race below to get its history background");
	}


}

