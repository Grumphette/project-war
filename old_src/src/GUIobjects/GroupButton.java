package GUIobjects;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

public class GroupButton extends Observable
{

	private Vector<Button> groupList;
	private Button selection;
	
	public GroupButton()
	{
		this.groupList = new Vector<Button>();
		this.selection = null;
	}
	
	public void add(Button aBtn)
	{
		this.groupList.add(aBtn);
		
		if(aBtn.isSelected() == true)
		{
			if(selection == null)
			{
				selection = aBtn;
			}
			else
			{
				aBtn.setSelected(false);
			}
		}
		
		aBtn.setGroup(this);
	}
	
	public void setSelected(Button aBtn)
	{
		if(aBtn != null && aBtn != this.selection)
		{
			Button oldSelection = this.selection;
			this.selection = aBtn;
			
			if(this.selection != null)
			{
				this.selection.setSelected(false);
			}
		}
		aBtn.setSelected(true);
		
		setChanged();
		notifyObservers();
		
	}
	
}
