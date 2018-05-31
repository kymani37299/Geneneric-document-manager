package JevLanguageManager;

import jevTree.actions.JevTreeAction;

public class LanguageActionManager {
	
	private static EnglishAction englishAction = new EnglishAction();
	private static SerbianCyrillicAction serbianCyrillicAction = new SerbianCyrillicAction();
	private static SerbianLatinAction serbianLatinAction = new SerbianLatinAction();
	
	public static JevTreeAction getAction(LanguageType type) {
		switch(type) {
			case English:
				return englishAction;
			case SerbianCyrillic:
				return serbianCyrillicAction;
			case SerbianLatin:
				return serbianLatinAction;
			default:
				throw new IllegalArgumentException();
		}
	}
}
