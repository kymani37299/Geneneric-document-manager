package JevLanguageManager;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import jevTree.actions.JevTreeAction;

@SuppressWarnings("serial")
public class SerbianCyrillicAction extends JevTreeAction implements Observer{
	
	public SerbianCyrillicAction(){
		putValue(NAME, JevLanguageManager.getInstance().getText("SerbianCyrillic"));
		JevLanguageManager.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JevLanguageManager.getInstance().setLanguage(LanguageType.SerbianCyrillic);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("SerbianCyrillic"));
	}
}

