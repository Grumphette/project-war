package DesktopGUI;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import misc.ConfigFileHandler;

public class MainWindow 
{
	private JFrame Window;
	private ConfigFileHandler gameConfigSettings;
	
	public MainWindow(ConfigFileHandler config)
	{
		this.gameConfigSettings = config;
		
		this.setLookAndFeel();
		
		Window = new JFrame("Project War");
		Window.pack();
		Window.setVisible(true);
		
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
