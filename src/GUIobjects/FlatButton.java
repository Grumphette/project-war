package GUIobjects;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import misc.GuiGeneralConfig;


public class FlatButton extends JPanel implements MouseListener
{
	private GuiGeneralConfig GuiConfig;

	public FlatButton()
	{
		super();
		GuiConfig = GuiGeneralConfig.getGuiConfigSingleton();
		this.addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		this.setOverlapColor();
	}
	@Override
	public void mouseExited(MouseEvent e) 
	{
		this.setSteadyColor();
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		this.setPressedColor();
	}
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		this.setOverlapColor();
	}
	
	public void setErrorColor( )
	{
		this.setBackground(GuiConfig.getUIColor("red"));	
	}
	public void setOverlapColor()
	{
		this.setBackground(GuiConfig.getUIColor("lightblue"));
	}
	public void setSteadyColor()
	{
		this.setBackground(GuiConfig.getUIColor("grey"));
	}
	public void setPressedColor()
	{
		this.setBackground(GuiConfig.getUIColor("blue"));
	}
}
