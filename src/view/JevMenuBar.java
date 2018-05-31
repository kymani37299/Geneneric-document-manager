package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import JevLanguageManager.JevLanguageManager;
import JevLanguageManager.LanguageActionManager;
import JevLanguageManager.LanguageType;
import JevThemeManager.ThemeActionManager;
import JevThemeManager.ThemeType;
import controller.JevMenuListeners;
import fileManagement.actions.OpenAction;
import fileManagement.actions.SaveWorkspaceAction;
import jevDesktop.actions.JevDesktopActionManager;
import jevDesktop.view.JevDesktop;
import jevTree.actions.JevTreeActionManager;
import jevTree.actions.NewWorkspaceAction;
import jevTree.view.JevTree;

@SuppressWarnings("serial")
public class JevMenuBar extends JMenuBar implements Observer {

	private JMenu nodeMenu;
	private JMenu themeMenu;
	private JMenu languageMenu;
	private JMenu fileMenu;
	private JMenu viewMenu;
	private JMenu helpMenu;
	private JMenuItem miAbout;
	
	public JevMenuBar(JevTree tree , JevDesktop desktop) {
	    JevLanguageManager.getInstance().addObserver(this);		
		this.nodeMenu = new JMenu();
		this.nodeMenu.setText(JevLanguageManager.getInstance().getText("Node"));

		JevTreeActionManager treeActionManager = tree.getActionManager();
		
		this.fileMenu = new JMenu();
		this.fileMenu.setText(JevLanguageManager.getInstance().getText("File"));
		this.fileMenu.add(new NewWorkspaceAction(tree));
		this.fileMenu.add(new OpenAction(tree));
		this.fileMenu.add(new SaveWorkspaceAction(tree));
		this.fileMenu.add(treeActionManager.getSaveProjectAction());
		
		this.nodeMenu.add(treeActionManager.getAddChildAction());
		this.nodeMenu.add(treeActionManager.getRemoveChildAction());
		this.nodeMenu.add(treeActionManager.getEditNodeAction());
		this.nodeMenu.add(treeActionManager.getCutAction());
		this.nodeMenu.add(treeActionManager.getCopyAction());
		this.nodeMenu.add(treeActionManager.getPasteAction());
	    
		this.languageMenu = new JMenu();
		this.languageMenu.setText(JevLanguageManager.getInstance().getText("Language"));
		this.languageMenu.add(LanguageActionManager.getAction(LanguageType.English));
		this.languageMenu.add(LanguageActionManager.getAction(LanguageType.SerbianLatin));
		this.languageMenu.add(LanguageActionManager.getAction(LanguageType.SerbianCyrillic));
		
		this.themeMenu = new JMenu();
		this.themeMenu.setText(JevLanguageManager.getInstance().getText("Theme"));
		
		this.themeMenu.add(ThemeActionManager.getAction(ThemeType.Metal));
		this.themeMenu.add(ThemeActionManager.getAction(ThemeType.SeaGlass));
		this.themeMenu.add(ThemeActionManager.getAction(ThemeType.WebLaf));
		
		this.helpMenu = new JMenu();
		this.helpMenu.setText(JevLanguageManager.getInstance().getText("Help"));
		
		this.miAbout = new JMenuItem();
		this.miAbout.setText(JevLanguageManager.getInstance().getText("About"));
		this.miAbout.addActionListener(JevMenuListeners.miAbout_actionPerformed());
	    this.helpMenu.add(this.miAbout);
	    
		JevDesktopActionManager desktopActionManager = desktop.getActionManager();
		this.viewMenu = new JMenu();
		this.viewMenu.setText(JevLanguageManager.getInstance().getText("View"));
		this.viewMenu.add(desktopActionManager.getTileViewAction());
		this.viewMenu.add(desktopActionManager.getCascadeViewAction());
		this.viewMenu.add(desktopActionManager.getHorizontalTileViewAction());
		this.viewMenu.add(desktopActionManager.getVerticalTileViewAction());
		
		this.add(fileMenu);
		this.add(nodeMenu);
		this.add(viewMenu);
		this.add(languageMenu);
		this.add(themeMenu);
		this.add(helpMenu);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.nodeMenu.setText(JevLanguageManager.getInstance().getText("Node"));
		this.fileMenu.setText(JevLanguageManager.getInstance().getText("File"));
		this.themeMenu.setText(JevLanguageManager.getInstance().getText("Theme"));
		this.languageMenu.setText(JevLanguageManager.getInstance().getText("Language"));
		this.helpMenu.setText(JevLanguageManager.getInstance().getText("Help"));
		this.miAbout.setText(JevLanguageManager.getInstance().getText("About"));
		this.viewMenu.setText(JevLanguageManager.getInstance().getText("View"));
	}
}