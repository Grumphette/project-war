package DesktopGUI;


import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class MainWindow implements ComponentListener
{
	private JFrame Window;
	private StartWindow WelcomScreen;
	private RaceSelection SelectPlayerRace;
	
	public MainWindow() throws IOException
	{
		this.setLookAndFeel();
		
		Window = new JFrame("Project War");
		
		WelcomScreen = new StartWindow();
		SelectPlayerRace = new RaceSelection();
		
		WelcomScreen.addComponentListener(this);
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
					SelectPlayerRace.buildRaceSelection();
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
	}


	@Override
	public void componentMoved(ComponentEvent e){} 
	@Override
	public void componentResized(ComponentEvent e){} 
	@Override
	public void componentShown(ComponentEvent e){} 
	
}
