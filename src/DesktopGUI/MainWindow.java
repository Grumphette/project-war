package DesktopGUI;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import misc.ConfigFileHandler;

public class MainWindow 
{
	private JFrame Window;
	private StartWindow WelcomScreen;
	private ConfigFileHandler gameConfigSettings;
	
	public MainWindow(ConfigFileHandler config) throws IOException
	{
		this.gameConfigSettings = config;
		
		this.setLookAndFeel();
		
		Window = new JFrame("Project War");
		
		WelcomScreen = new StartWindow(config);
		Window.add(WelcomScreen);
		Window.pack();
		Window.setVisible(true);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setResizable(false);
		//Window.setBackground(Color.WHITE);
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
}
