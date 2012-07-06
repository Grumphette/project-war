package misc;

import java.awt.Color;

public class BtnColor 
{
	private String btnState;
	private Color btnColor;
	public BtnColor(String btnState, int R, int G, int B, int A)
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
