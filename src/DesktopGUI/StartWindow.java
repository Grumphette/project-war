package DesktopGUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.ConfigFileHandler;
import misc.GeneralConfig;

public class StartWindow extends JPanelWithBgImg 
{

	private JPanelWithBgImg Logo;
	private JPanelWithBgImg btnPnl;
	private JPanelWithBgImg btnStartSolo;
	private JPanelWithBgImg btnStartMulti;
	private JPanelWithBgImg btnQuit;
	private JPanelWithBgImg btnCredit;
	private JLabel lblStartSolo;
	private JLabel lblStartMulti;
	private JLabel lblQuit;
	private JLabel lblCredit;
	
	public StartWindow(ConfigFileHandler config) 
	{
		
		super(config.getGlobalConfigSettings().getGeneralImage("BackImg"));
		Logo = new JPanelWithBgImg(config.getGlobalConfigSettings().getGeneralImage("LogoImg"));
		Image bgPnlBg = config.getGlobalConfigSettings().getGeneralImage("PanelBgImg");
		btnPnl = new JPanelWithBgImg(bgPnlBg);
		btnStartSolo = new JPanelWithBgImg(bgPnlBg);
		btnStartMulti = new JPanelWithBgImg(bgPnlBg);
		btnQuit = new JPanelWithBgImg(bgPnlBg);
		btnCredit = new JPanelWithBgImg(bgPnlBg);
		
		/**Logo panel configuration*/
		Logo.setSize(config.getGlobalConfigSettings().getDefaultSize().getWidth(), (int)(config.getGlobalConfigSettings().getDefaultSize().getHeigh()*0.2));
		Logo.setBackground(Color.black);
		Logo.setOpaque(true);
		
		/**Start solo game button panel configuration*/
		lblStartSolo = new JLabel("Start Solo game");
		btnStartSolo.add(lblStartSolo);
		
		/**Start multi game button panel configuration*/
		lblStartMulti = new JLabel("Start multi-player game");
		btnStartMulti.add(lblStartMulti);
		
		/**Quit button panel configuration*/
		lblQuit = new JLabel("Quit");
		btnQuit.add(lblQuit);
		
		/**Credit button panel configuration*/
		lblCredit = new JLabel("Credits");
		btnCredit.add(lblCredit);
		
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
