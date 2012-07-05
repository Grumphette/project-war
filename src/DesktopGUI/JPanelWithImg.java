package DesktopGUI;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JPanel;



public class JPanelWithImg extends JPanel 
{
	Image bgImg;
	
	
	
	
	public JPanelWithImg(Image img)
	{
		super();
		this.bgImg=img;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		if(this.bgImg != null)
		{	
			g.drawImage(this.bgImg, 0, 0, null);
		}
	}
}
