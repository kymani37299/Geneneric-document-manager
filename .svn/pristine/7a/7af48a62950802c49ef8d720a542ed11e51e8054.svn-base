package JevLanguageManager;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import jevTree.actions.JevTreeAction;

@SuppressWarnings("serial")
public class EnglishAction extends JevTreeAction implements Observer{

	public EnglishAction() {
		putValue(NAME, JevLanguageManager.getInstance().getText("English"));
		JevLanguageManager.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JevLanguageManager.getInstance().setLanguage(LanguageType.English);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("English"));
	}

}
