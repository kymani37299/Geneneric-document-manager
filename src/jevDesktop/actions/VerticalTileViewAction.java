package jevDesktop.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import JevLanguageManager.JevLanguageManager;
import jevDesktop.controller.JevDesktopController;

public class VerticalTileViewAction extends AbstractAction implements Observer{

	private JevDesktopController controller;
	
	public VerticalTileViewAction(JevDesktopController controller){
		putValue(NAME,JevLanguageManager.getInstance().getText("VerticalTileView"));
		this.controller = controller;
		JevLanguageManager.getInstance().addObserver(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.setVerticalTileView();
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME,JevLanguageManager.getInstance().getText("VerticalTileView"));
	}

}
