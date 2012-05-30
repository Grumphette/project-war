package DesktopGUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class JPanelWithBgImg extends JPanel
{
	Image bgImg;
	
	public JPanelWithBgImg(Image img)
	{
		super();
		this.bgImg=img;
	}

	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, null);
	}

}
