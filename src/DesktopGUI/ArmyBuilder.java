package DesktopGUI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArmyBuilder extends JPanel 
{
	private JPanel headerPnl;
	private JPanel troopListPnl;
	private JPanel unitListPnl;
	private JPanel btnPnl;
	private JPanel horizontalLayoutPnl;

	private JButton previousBtn;
	private JButton nextBtn;
	private JButton addToTroopBtn;
	private JButton removeFromTroopBtn;
	private JButton newTroopBtn;
	private JButton deleteTroopBtn;
	
	private JLabel createYourAmryLbl;
	
	private boolean isAlreadyBuild;
	private int state;
	private String selectedRace;
	
	public ArmyBuilder(String selectedRace)
	{
		super();
		isAlreadyBuild = false;
		state = 0;
		this.selectedRace = selectedRace;
	}
	
	public void buildArmyBuilder()
	{
		headerPnl = new JPanel();
		headerPnl.setLayout(new BoxLayout(headerPnl,BoxLayout.X_AXIS));
		headerPnl.add(previousBtn);
		headerPnl.add(Box.createHorizontalGlue());
		headerPnl.add(createYourAmryLbl);
		headerPnl.add(Box.createHorizontalGlue());
		headerPnl.add(nextBtn);
		
		troopListPnl = new JPanel();
		troopListPnl.setLayout(new BoxLayout(troopListPnl, BoxLayout.Y_AXIS));
		
		btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		
		unitListPnl = new JPanel();
		unitListPnl.setLayout(new BoxLayout(unitListPnl, BoxLayout.Y_AXIS));
		
		horizontalLayoutPnl = new JPanel();
		horizontalLayoutPnl.setLayout(new BoxLayout(horizontalLayoutPnl, BoxLayout.X_AXIS));
		horizontalLayoutPnl.add(troopListPnl);
		horizontalLayoutPnl.add(Box.createHorizontalGlue());
		horizontalLayoutPnl.add(btnPnl);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(headerPnl);
		
	}
}
