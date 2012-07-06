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
	
	public MainWindow() throws IOException
	{
		this.setLookAndFeel();
		
		Window = new JFrame("Project War");
		
		WelcomScreen = new StartWindow();
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
}
