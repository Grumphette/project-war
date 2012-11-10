package DesktopGUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class JPanelWithImg extends JPanel 
{
	Image bgImg;
	

	public JPanelWithImg(Image img)
	{
		super();
		this.bgImg=img;
		if(this.bgImg != null)
		{
			this.setPreferredSize(new Dimension(this.bgImg.getWidth(null),this.bgImg.getHeight(null)));
		}
		this.setBackground(Color.CYAN);
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
