package JevLanguageManager;

import java.util.Observable;
import java.util.ResourceBundle;

public class JevLanguageManager extends Observable {

	private static JevLanguageManager instance;
	private ResourceBundle bundle;
	
	private JevLanguageManager() {
		bundle = ResourceBundle.getBundle("resources.language_en");
	}
	
	public void setLanguage(LanguageType type) {
		
		switch(type) {
			case English:
				this.bundle = ResourceBundle.getBundle("resources.language_en");
				break;
			case SerbianLatin:
				this.bundle = ResourceBundle.getBundle("resources.language_sl");
				break;
			case SerbianCyrillic:
				this.bundle = ResourceBundle.getBundle("resources.language_sc");
				break;
			default:
				throw new IllegalArgumentException();
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public ResourceBundle getBundle() {
		return this.bundle;
	}
	
	public static JevLanguageManager getInstance() {
		if(instance == null)
			instance = new JevLanguageManager();
		return instance;
	}
	
	public String getText(String tag) {
		try {
			return new String(JevLanguageManager.getInstance().getBundle().getString(tag).getBytes("ISO-8859-1"), "UTF-8"); 
		}
		catch (Exception e) {
			return null;
		}
	}

}
