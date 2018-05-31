package JevThemeManager;

import jevTree.actions.JevTreeAction;

public class ThemeActionManager {
	private static MetalThemeAction metalAction = new MetalThemeAction();
	private static WebLafThemeAction webLafAction = new WebLafThemeAction();
	private static SeaGlassThemeAction seaGlassAction = new SeaGlassThemeAction();
	
	public static JevTreeAction getAction(ThemeType type) {
		switch(type) {
			case Metal:
				return metalAction;
			case SeaGlass:
				return webLafAction;
			case WebLaf:
				return seaGlassAction;
			default:
				throw new IllegalArgumentException();
		}
		
	}
}
