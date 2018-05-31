package JevThemeManager;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import JevLanguageManager.JevLanguageManager;
import jevTree.actions.JevTreeAction;

@SuppressWarnings("serial")
public class WebLafThemeAction extends JevTreeAction implements Observer{
	
	public WebLafThemeAction() {
		putValue(NAME, JevLanguageManager.getInstance().getText("WebLaf"));
		JevLanguageManager.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JevThemeManager.setTheme(ThemeType.WebLaf);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("WebLaf"));
	}
}
