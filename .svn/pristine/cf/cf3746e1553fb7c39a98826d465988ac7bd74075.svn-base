package JevThemeManager;

import JevLanguageManager.JevLanguageManager;

public class ThemeTypeExtender {

	public static String getText(ThemeType type) {
		switch(type) {
			case Metal:
		        return JevLanguageManager.getInstance().getText("Metal");
			case SeaGlass:
		        return JevLanguageManager.getInstance().getText("SeaGlass");
			case WebLaf:
		        return JevLanguageManager.getInstance().getText("WebLaf");
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static ThemeType getType(String text) {
		if(text.equals(JevLanguageManager.getInstance().getText("Metal")))
	        return ThemeType.Metal;
		if(text.equals(JevLanguageManager.getInstance().getText("SeaGlass")))
	        return ThemeType.SeaGlass;
		if(text.equals(JevLanguageManager.getInstance().getText("WebLaf")))
	        return ThemeType.WebLaf;
		
		throw new IllegalArgumentException();
	}
}