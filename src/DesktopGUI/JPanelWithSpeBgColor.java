package DesktopGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JPanelWithSpeBgColor extends JPanel implements MouseListener 
{
	
	Color grey = new Color(230,230,230,255);
	Color lighBlue = new Color (121,186,255,74);
	
	
	public JPanelWithSpeBgColor()
	{
		this.addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		this.setBackground(this.lighBlue);
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		this.setBackground(this.grey);
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{}
}
