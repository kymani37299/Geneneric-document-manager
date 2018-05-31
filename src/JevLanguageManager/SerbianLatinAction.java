package JevLanguageManager;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import jevTree.actions.JevTreeAction;

@SuppressWarnings("serial")
public class SerbianLatinAction extends JevTreeAction implements Observer {
	
	public SerbianLatinAction() {
		putValue(NAME, JevLanguageManager.getInstance().getText("SerbianLatin"));
		JevLanguageManager.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JevLanguageManager.getInstance().setLanguage(LanguageType.SerbianLatin);
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("SerbianLatin"));
	}
}
