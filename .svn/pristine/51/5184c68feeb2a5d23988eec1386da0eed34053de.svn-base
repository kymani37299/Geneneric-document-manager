package JevThemeManager;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import JevLanguageManager.JevLanguageManager;
import jevTree.actions.JevTreeAction;

@SuppressWarnings("serial")
public class SeaGlassThemeAction extends JevTreeAction implements Observer{

	public SeaGlassThemeAction(){
		putValue(NAME, JevLanguageManager.getInstance().getText("SeaGlass"));
		JevLanguageManager.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JevThemeManager.setTheme(ThemeType.SeaGlass);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("SeaGlass"));
	}

}

