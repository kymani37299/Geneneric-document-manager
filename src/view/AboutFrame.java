package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JPanel;

import JevLanguageManager.JevLanguageManager;
import resources.Bios;
import view.customComponents.BioPanel;

@SuppressWarnings("serial")
public class AboutFrame extends JDialog implements Observer{
	
	private BioPanel teamBioPanel;
	private BioPanel lukaBioPanel;
	private BioPanel markoBioPanel;
	private BioPanel nikolaBioPanel;
	private BioPanel jovanBioPanel;
	private JPanel panel;
	private Box box;
	
	public AboutFrame(Frame owner){
		super(owner, true);
		
		JevLanguageManager.getInstance().addObserver(this);
		this.setSize(450, 950); 
		this.setTitle(JevLanguageManager.getInstance().getText("AboutUs"));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.teamBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("teamBio"), Bios.getInstance().getTeamImagePath());
		this.lukaBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("lukaBio"), Bios.getInstance().getLukaImagePath());
		this.markoBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("mareBio"), Bios.getInstance().getMarkoImagePath());
		this.nikolaBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("nikolaBio"), Bios.getInstance().getNikolaImagePath());
		this.jovanBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("jovanBio"), Bios.getInstance().getJovanImagePath());
		
	    this.panel = new JPanel();
		this.box = Box.createVerticalBox();
		
		this.box.add(this.teamBioPanel);
		this.box.add(Box.createVerticalStrut(10));
		this.box.add(this.lukaBioPanel);
		this.box.add(Box.createVerticalStrut(10));
		this.box.add(this.markoBioPanel);
		this.box.add(Box.createVerticalStrut(10));
		this.box.add(this.nikolaBioPanel);
		this.box.add(Box.createVerticalStrut(10));
		this.box.add(this.jovanBioPanel);
		
	    this.panel.add(box, BorderLayout.WEST);
		this.add(this.panel);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.teamBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("teamBio"), Bios.getInstance().getTeamImagePath());
		this.lukaBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("lukaBio"), Bios.getInstance().getLukaImagePath());
		this.markoBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("mareBio"), Bios.getInstance().getMarkoImagePath());
		this.nikolaBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("nikolaBio"), Bios.getInstance().getNikolaImagePath());
		this.jovanBioPanel = new BioPanel(JevLanguageManager.getInstance().getText("jovanBio"), Bios.getInstance().getJovanImagePath());
		
	}
}
