package view.modelEditing;

import JevLanguageManager.JevLanguageManager;
import model.element.JevElementType;

public class JevElementTypeExtender {
	public static String getText(JevElementType type) {
		switch(type) {
			case Text:
		        return JevLanguageManager.getInstance().getText("Text");
			case Graphic:
		        return JevLanguageManager.getInstance().getText("Graphic");
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static JevElementType getType(String text) {
		if(text.equals(JevLanguageManager.getInstance().getText("Text")))
		        return JevElementType.Text;
		if(text.equals(JevLanguageManager.getInstance().getText("Graphic")))
		        return JevElementType.Graphic;
		
		throw new IllegalArgumentException();
	}
}
