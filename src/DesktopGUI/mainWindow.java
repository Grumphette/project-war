package DesktopGUI;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class mainWindow 
{
	private JFrame MainWindow;
	
	public mainWindow()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		MainWindow = new JFrame("Project War");
	}

}
