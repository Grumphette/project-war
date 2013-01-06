package GUIobjects;

import java.util.ArrayList;


public class ConfirmationButtonGroup
{
	private ArrayList<ConfirmationButton> btnList;
	
	public ConfirmationButtonGroup ()
	{
		btnList = new ArrayList<ConfirmationButton>();
	}
	
	public void add (ConfirmationButton aBtn)
	{
		btnList.add(aBtn);
	}
	
	

	
}
