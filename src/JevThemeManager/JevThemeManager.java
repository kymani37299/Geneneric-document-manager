package JevThemeManager;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import view.MainFrame;

public class JevThemeManager {

	public static void setTheme(ThemeType type){
		String laf = null;
		switch(type) {
			case Metal:
				try {
					laf = UIManager.getCrossPlatformLookAndFeelClassName();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case WebLaf:
				laf = "com.alee.laf.WebLookAndFeel";
				break;
			case SeaGlass:
				laf = "com.seaglasslookandfeel.SeaGlassLookAndFeel";
				break;
		}
		if(laf != null) {
			try {
				UIManager.setLookAndFeel(laf);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
	}
}
