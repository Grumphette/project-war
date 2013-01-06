package GUIobjects;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import misc.GuiGeneralConfig;

public class ConfirmationButton extends JPanelWithImg implements MouseListener
{
	private GuiGeneralConfig guiConfig;
	private BackImage validationImg;
	private Image initialImage;
	private int nbClick;
	private boolean confirmation;

	public ConfirmationButton(Image img) 
	{
		super(img);
		guiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		validationImg = guiConfig.getGeneralImage("ValidationImg");
		this.addMouseListener(this);
		nbClick=0;
		confirmation = false;
		initialImage = img;
		
	}

	@Override
	public void mouseClicked(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		nbClick++;
		if(nbClick == 1)
		{
			//load confirmation image
			this.changeImg(validationImg.getFinalImage());
		}
		else
		{
			//restore initial image
			this.changeImg(initialImage);
			confirmation = true;
			nbClick=0;
		}
		this.mustClearRect(true);
		this.repaint();
		//this.mustClearRect(false);
	}
	
	public boolean asConfirmed()
	{
		return confirmation;
	}

}
