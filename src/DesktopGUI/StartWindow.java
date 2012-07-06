package DesktopGUI;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import misc.ConfigFileHandler;


public class StartWindow extends JPanel implements MouseListener
{
	private ConfigFileHandler config;
	
	private JPanelWithImg Logo;
	private JPanel btnPnl;
	private JPanel btnStartSolo;
	private JPanel btnStartMulti;
	private JPanel btnQuit;
	private JPanel btnCredit;
	private JLabel lblStartSolo;
	private JLabel lblStartMulti;
	private JLabel lblQuit;
	private JLabel lblCredit;
	private JPanel btnLayoutPnl;
	
	public StartWindow(ConfigFileHandler config) throws IOException 
	{
		super();
		this.config = config;
		Logo = new JPanelWithImg(this.config.getGlobalConfigSettings().getGeneralImage("LogoImg"));
		
		btnPnl = new JPanel();
		btnStartSolo = new JPanel();
		btnStartMulti = new JPanel();
		btnQuit = new JPanel();
		btnCredit = new JPanel();
		btnLayoutPnl = new JPanel();
		
		/**Logo panel configuration*/
		Logo.setPreferredSize(new Dimension((int)(this.config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(this.config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.2)));
		
		
		
		/**Start solo game button panel configuration*/
		btnStartSolo.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblStartSolo = new JLabel("Start Solo game");
		btnStartSolo.add(lblStartSolo);
		btnStartSolo.addMouseListener(this);
		
		
		/**Start multi game button panel configuration*/
		btnStartMulti.setPreferredSize(new Dimension((int)(this.config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(this.config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
		btnStartMulti.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblStartMulti = new JLabel("Start multi-player game");
		btnStartMulti.add(lblStartMulti);
		
		/**Quit button panel configuration*/
		btnQuit.setPreferredSize(new Dimension((int)(this.config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(this.config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
		btnQuit.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		lblQuit = new JLabel("Quit");
		btnQuit.add(lblQuit);
		
		/**Credit button panel configuration*/
		btnCredit.setPreferredSize(new Dimension((int)(this.config.getGlobalConfigSettings().getDefaultSize().getWidth()*0.4), (int)(this.config.getGlobalConfigSettings().getDefaultSize().getHeight()*0.05)));
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		this.setBackground(this.config.getGlobalConfigSettings().getBtnColor("btnOver"));
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
}
