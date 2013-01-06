package GUIobjects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class ImageButton extends Button 
{
	private Image bgImage;
	private boolean hasToClearRect;
	
	public ImageButton(Image img)
	{
		super();
		hasToClearRect = false;
		this.bgImage=img;
		if(this.bgImage != null)
		{
			this.setPreferredSize(new Dimension(this.bgImage.getWidth(null),this.bgImage.getHeight(null)));
		}
	}
	
	
	public void changeImg(Image img)
	{
		this.bgImage=img;
		if(this.bgImage != null)
		{
			this.setPreferredSize(new Dimension(this.bgImage.getWidth(null),this.bgImage.getHeight(null)));
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
			g.clearRect(0, 0, this.bgImage.getWidth(null), this.bgImage.getHeight(null));
			hasToClearRect = false;
		}
		super.paintComponents(g);
		if(this.bgImage != null)
		{
			g.drawImage(this.bgImage, 0, 0, null);
		}
	}
	
}
