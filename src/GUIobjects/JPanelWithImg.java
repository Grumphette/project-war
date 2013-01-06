package GUIobjects;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class JPanelWithImg extends JPanel 
{
	private Image bgImg;
	private boolean hasToClearRect;

	public JPanelWithImg(Image img)
	{
		super();
		hasToClearRect = false;
		this.bgImg=img;
		if(this.bgImg != null)
		{
			this.setPreferredSize(new Dimension(this.bgImg.getWidth(null),this.bgImg.getHeight(null)));
		}
	}
	
	public void changeImg(Image img)
	{
		this.bgImg=img;
		if(this.bgImg != null)
		{
			this.setPreferredSize(new Dimension(this.bgImg.getWidth(null),this.bgImg.getHeight(null)));
		}
		
	}
	public void mustClearRect(boolean bool)
	{
		hasToClearRect = bool;
	}
	
	public void paintComponent(Graphics g)
	{
		if(hasToClearRect == true)
		{
			g.clearRect(0, 0, this.bgImg.getWidth(null), this.bgImg.getHeight(null));
		}
		super.paintComponents(g);
		if(this.bgImg != null)
		{
			g.drawImage(this.bgImg, 0, 0, null);
		}
	}
}
