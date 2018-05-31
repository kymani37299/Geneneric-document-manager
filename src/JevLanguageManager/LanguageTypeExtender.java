package JevLanguageManager;

public class LanguageTypeExtender {

	public static String getText(LanguageType type) {
		switch(type) {
			case English:
		        return JevLanguageManager.getInstance().getText("English");
			case SerbianCyrillic:
		        return JevLanguageManager.getInstance().getText("SerbianCyrillic");
			case SerbianLatin:
		        return JevLanguageManager.getInstance().getText("SerbianLatin");
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static LanguageType getType(String text) {
		if(text.equals(JevLanguageManager.getInstance().getText("English")))
	        return LanguageType.English;
		if(text.equals(JevLanguageManager.getInstance().getText("SerbianCyrillic")))
	        return LanguageType.SerbianCyrillic;
		if(text.equals(JevLanguageManager.getInstance().getText("SerbianLatin")))
	        return LanguageType.SerbianLatin;
		
		throw new IllegalArgumentException();
	}
}