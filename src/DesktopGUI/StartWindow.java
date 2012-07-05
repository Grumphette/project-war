package DesktopGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kitfox.svg.SVGDiagram;

import misc.ConfigFileHandler;
import misc.Dimension2D;
import misc.GeneralConfig;

public class StartWindow extends JPanel
{

	private JPanelWithImg Logo;
	private JPanel btnPnl;
	private JPanel btnStartSolo;
	private JPanelWithSpeBgColor btnStartMulti;
	private JPanelWithSpeBgColor btnQuit;
	private JPanelWithSpeBgColor btnCredit;
	private JLabel lblStartSolo;
	private JLabel lblStartMulti;
	private JLabel lblQuit;
	private JLabel lblCredit;
	private JPanel btnLayoutPnl;
	
	public StartWindow(ConfigFileHandler config) throws IOException 
	{
		super();
		Logo = new JPanelWithImg(config.getGlobalConfigSettings().getGeneralImage("LogoImg"));
		
		btnPnl = new JPanel();
		btnStartSolo = new JPanelWithSpeBgColor();
		btnStartMulti = new JPanelWithSpeBgColor();
		btnQuit = new JPanelWithSpeBgColor();
		btnCredit = new JPanelWithSpeBgColor();
		btnLayoutPnl = new JPanel();
		
		/**Logo panel configuration*/
		Logo.setPreferredSize(new Dimension((int)(config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.2)));
		
		
		
		/**Start solo game button panel configuration*/
		btnStartSolo.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblStartSolo = new JLabel("Start Solo game");
		btnStartSolo.add(lblStartSolo);
		
		
		/**Start multi game button panel configuration*/
		btnStartMulti.setPreferredSize(new Dimension((int)(config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
		btnStartMulti.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblStartMulti = new JLabel("Start multi-player game");
		btnStartMulti.add(lblStartMulti);
		
		/**Quit button panel configuration*/
		btnQuit.setPreferredSize(new Dimension((int)(config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
		btnQuit.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblQuit = new JLabel("Quit");
		btnQuit.add(lblQuit);
		
		/**Credit button panel configuration*/
		btnCredit.setPreferredSize(new Dimension((int)(config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
		btnCredit.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblCredit = new JLabel("Credits");
		btnCredit.add(lblCredit);
		
		
		/**Adding all the button in the button panel*/
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		btnPnl.setBorder(BorderFactory.createEmptyBorder(8, 8, 4, 4));
		//btnPnl.setOpaque(true);
		//btnPnl.setBackground(Color.blue);
		
		btnPnl.add(btnStartSolo);
		btnPnl.add(Box.createVerticalStrut(5));
		btnPnl.add(btnStartMulti);
		btnPnl.add(Box.createVerticalGlue());
		btnPnl.add(btnCredit);
		btnPnl.add(Box.createVerticalGlue());
		btnPnl.add(btnQuit);
		btnPnl.add(Box.createVerticalGlue());
		
		btnLayoutPnl.setLayout(new BoxLayout(btnLayoutPnl, BoxLayout.X_AXIS));
		btnLayoutPnl.add(Box.createHorizontalStrut(5));
		btnLayoutPnl.add(btnPnl);
		btnLayoutPnl.add(Box.createHorizontalStrut(5));
		
		/**Adding the panel with all the buttons and the logo,
		 * a vertical glue is added to push the logo at the top
		 * and the button panel at the bottom*/
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.add(Logo);
		this.add(Box.createHorizontalGlue());
		this.add(btnLayoutPnl);
	}
	

	
}
