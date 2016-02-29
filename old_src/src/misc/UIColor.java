package misc;

import java.awt.Color;

public class UIColor 
{
	private String btnState;
	private Color btnColor;
	public UIColor(String btnState, int R, int G, int B, int A)
	{
		btnColor = new Color(R,G,B,A);
		this.btnState = btnState;
	}
	
	public String GetBtnState()
	{
		return this.btnState;
	}
	
	public Color getColor()
	{
		return this.btnColor;
	}
}
