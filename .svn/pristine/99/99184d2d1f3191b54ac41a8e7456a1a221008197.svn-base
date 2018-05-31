package jevDesktop.actions;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import JevLanguageManager.JevLanguageManager;
import jevDesktop.controller.JevDesktopController;

@SuppressWarnings("serial")
public class TileViewAction extends AbstractAction implements Observer{

	private JevDesktopController controller;
	
	public TileViewAction(JevDesktopController controller){		
		this.controller = controller;
		putValue(NAME, JevLanguageManager.getInstance().getText("TileView"));
		JevLanguageManager.getInstance().addObserver(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.setTileView();
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("TileView"));
	}

}
