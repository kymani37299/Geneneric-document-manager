package jevDesktop.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import JevLanguageManager.JevLanguageManager;
import jevDesktop.controller.JevDesktopController;

public class CascadeViewAction extends AbstractAction implements Observer{

	private JevDesktopController controller;
	
	public CascadeViewAction(JevDesktopController controller){
		putValue(NAME,JevLanguageManager.getInstance().getText("CascadeView"));
		this.controller = controller;
		JevLanguageManager.getInstance().addObserver(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.setCascadeView();
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME,JevLanguageManager.getInstance().getText("CascadeView"));
	}

}
