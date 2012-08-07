package DesktopGUI;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUIobjects.BackImage;
import misc.ConfigFileHandler;


@SuppressWarnings("serial")
public class StartWindow extends JPanel
{
	
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
	private MouseListener btnMouseListerner;
	private int state;
	
	
	public StartWindow() throws IOException 
	{
		super();
		state = 0;
		
		btnMouseListerner = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				if(e.getSource().equals(btnCredit) || e.getSource().equals(btnQuit) || e.getSource().equals(btnStartMulti) || e.getSource().equals(btnStartSolo))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("lightblue"));
				}
				if(e.getSource().equals(btnStartSolo))
				{
					state=1;
				}
				else if(e.getSource().equals(btnStartMulti))
				{
					state=2;
				}
				else if(e.getSource().equals(btnCredit))
				{
					state=3;
				}
				else
				{
					state=4;
				}
				hideStartWindow();
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				if(e.getSource().equals(btnCredit) || e.getSource().equals(btnQuit) || e.getSource().equals(btnStartMulti) || e.getSource().equals(btnStartSolo))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("blue"));
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				if(e.getSource().equals(btnCredit) || e.getSource().equals(btnQuit) || e.getSource().equals(btnStartMulti) || e.getSource().equals(btnStartSolo))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if(e.getSource().equals(btnCredit) || e.getSource().equals(btnQuit) || e.getSource().equals(btnStartMulti) || e.getSource().equals(btnStartSolo))
				{
					JPanel Source = (JPanel)e.getSource();
					Source.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("lightblue"));
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		};
		
		
		this.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		BackImage LogImgInfo = ConfigFileHandler.getGlobalConfigSettings().getGeneralImage("LogoImg");
		Logo = new JPanelWithImg(LogImgInfo.getFinalImage());
		
		btnPnl = new JPanel();
		btnStartSolo = new JPanel();
		btnStartMulti = new JPanel();
		btnQuit = new JPanel();
		btnCredit = new JPanel();
		btnLayoutPnl = new JPanel();
		
		/**Logo panel configuration*/
		Logo.setPreferredSize(LogImgInfo.getImgSize());
		
		/**Start solo game button panel configuration*/
		lblStartSolo = new JLabel();
		lblStartSolo.setFont(ConfigFileHandler.getGlobalConfigSettings().getFont());
		lblStartSolo.setText("Start Solo game");
		btnStartSolo.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		btnStartSolo.addMouseListener(btnMouseListerner);
		btnStartSolo.add(lblStartSolo);
		
		
		/**Start multi game button panel configuration*/
		lblStartMulti = new JLabel();
		lblStartMulti.setFont(ConfigFileHandler.getGlobalConfigSettings().getFont());
		lblStartMulti.setText("Start multi-player game");
		btnStartMulti.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		btnStartMulti.addMouseListener(btnMouseListerner);
		btnStartMulti.add(lblStartMulti);
		
		/**Quit button panel configuration*/
		lblQuit = new JLabel();
		lblQuit.setFont(ConfigFileHandler.getGlobalConfigSettings().getFont());
		lblQuit.setText("Quit");
		btnQuit.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		btnQuit.addMouseListener(btnMouseListerner);
		btnQuit.add(lblQuit);
		
		/**Credit button panel configuration*/
		lblCredit = new JLabel();
		lblCredit.setFont(ConfigFileHandler.getGlobalConfigSettings().getFont());
		lblCredit.setText("Credits");
		btnCredit.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		btnCredit.addMouseListener(btnMouseListerner);
		btnCredit.add(lblCredit);
		
		
		/**Adding all the button in the button panel*/
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		btnPnl.add(btnStartSolo);
		btnPnl.add(btnStartMulti);
		btnPnl.add(btnCredit);
		btnPnl.add(btnQuit);
		
		
		btnLayoutPnl.setLayout(new BoxLayout(btnLayoutPnl, BoxLayout.X_AXIS));
		btnLayoutPnl.setBackground(ConfigFileHandler.getGlobalConfigSettings().getUIColor("grey"));
		btnLayoutPnl.add(Box.createHorizontalGlue());
		btnLayoutPnl.add(btnPnl);
		btnLayoutPnl.add(Box.createHorizontalGlue());
		
		
		
		/**Adding the panel with all the buttons and the logo,
		 * a vertical glue is added to push the logo at the top
		 * and the button panel at the bottom*/
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.add(Logo);
		this.add(Box.createVerticalStrut(30));
		this.add(btnLayoutPnl);
		
	}
	
	public int getState()
	{
		return this.state;
	}
	private void hideStartWindow()
	{
		this.setVisible(false);
	}
	
	public void showStartWindow()
	{
		this.state = 0;
		this.setVisible(false);
	}
}
