package DesktopGUI;


import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Core.CoreGame;

import misc.GuiGeneralConfig;


public class MainWindow implements ComponentListener
{
	private JFrame Window;
	private StartWindow WelcomScreen;
	private RaceSelection SelectPlayerRace;
	
	public MainWindow()
	{
		GuiGeneralConfig guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		guiConfig.loadGuiConfig();
		
		
		this.setLookAndFeel();
		
		Window = new JFrame("Project War");
		
		WelcomScreen = new StartWindow();
		SelectPlayerRace = new RaceSelection();
		
		WelcomScreen.addComponentListener(this);
		SelectPlayerRace.addComponentListener(this);
		
		WelcomScreen.buildStartWindow();
		Window.add(WelcomScreen);
		Window.pack();
		Window.setVisible(true);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setResizable(false);
	}

	
	private void setLookAndFeel()
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


	@Override
	public void componentHidden(ComponentEvent e) 
	{
		if(e.getComponent().equals(WelcomScreen))
		{
			switch(WelcomScreen.getState())
			{
				case 1:
					System.out.println("load single player panel");
					Window.remove(WelcomScreen);
					if(SelectPlayerRace.isBuilt() == true)
					{
						SelectPlayerRace.setVisible(true);
					}
					else
					{
						SelectPlayerRace.buildRaceSelection();
					}
					
					Window.add(SelectPlayerRace);
					Window.pack();
					break;
				case 2:
					System.out.println("load multy player panel");
					break;
				case 3:
					System.out.println("load credit panel");
					break;
				case 4:
					System.out.println("Quit");
					break;
			}
		}
		if(e.getComponent().equals(SelectPlayerRace))
		{
			switch(SelectPlayerRace.getState())
			{
				case 1:
					System.out.println("retunr to start window");
					Window.remove(SelectPlayerRace);
					if(WelcomScreen.isBuilt() == true)
					{
						WelcomScreen.setVisible(true);
					}
					else
					{
						WelcomScreen.buildStartWindow();
					}
					Window.add(WelcomScreen);
					Window.pack();
					break;
				case 2:
					System.out.println("load army builder");
					break;
			}
		}
	}


	@Override
	public void componentMoved(ComponentEvent e){} 
	@Override
	public void componentResized(ComponentEvent e){} 
	@Override
	public void componentShown(ComponentEvent e){} 
	
}
