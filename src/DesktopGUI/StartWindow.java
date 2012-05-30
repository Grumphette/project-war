package DesktopGUI;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StartWindow extends JPanelWithBgImg 
{

	private JPanelWithBgImg Logo;
	private JPanelWithBgImg btnPnl;
	private JPanelWithBgImg btnStartSolo;
	private JPanelWithBgImg btnStartMulti;
	private JPanelWithBgImg btnQuit;
	private JPanelWithBgImg btnCredit;
	
	public StartWindow(Image imgStartBg, Image imgLogo, Image bgPnlBg ) 
	{
		super(imgStartBg);
		
		Logo = new JPanelWithBgImg(imgLogo);
		btnPnl = new JPanelWithBgImg(bgPnlBg);
		btnStartSolo = new JPanelWithBgImg(bgPnlBg);
		btnStartMulti = new JPanelWithBgImg(bgPnlBg);
		btnQuit = new JPanelWithBgImg(bgPnlBg);
		btnCredit = new JPanelWithBgImg(bgPnlBg);
		
		/**Logo panel configuration*/
		
		/**Start solo game button panel configuration*/
		
		/**Start multi game button panel configuration*/
		
		/**Quit button panel configuration*/
		
		/**Credit button panel configuration*/
		
		/**Adding all the button in the button panel*/
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		btnPnl.setOpaque(false);
		btnPnl.add(btnStartSolo);
		btnPnl.add(btnStartMulti);
		btnPnl.add(btnCredit);
		btnPnl.add(btnCredit);
		
		
		/**Adding the panel with all the buttons and the logo,
		 * a vertical glue is added to push the logo at the top
		 * and the button panel at the bottom*/
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(Logo);
		this.add(Box.createHorizontalGlue());
		this.add(btnPnl);
	}
	

	
}
