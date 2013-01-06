package GUIobjects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public abstract class Button extends JPanel
{
	protected boolean selected;
	protected GroupButton group;
	
	public Button()
	{
		super();
		this.selected = false;
	}
	
	
	public void setGroup(GroupButton aGrp)
	{
		this.group = aGrp;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean state) 
	{
		this.selected = state;
	}

}
