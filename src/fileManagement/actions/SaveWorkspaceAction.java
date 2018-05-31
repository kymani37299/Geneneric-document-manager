package fileManagement.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import fileManagement.FileManager;
import jevTree.actions.JevTreeAction;
import jevTree.model.JevTreeModel;
import jevTree.model.JevTreeNode;
import jevTree.view.JevTree;

public class SaveWorkspaceAction extends JevTreeAction implements Observer{

	private JevTree tree;
	
	public SaveWorkspaceAction(JevTree tree) {
		this.tree = tree;
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		putValue(NAME, JevLanguageManager.getInstance().getText("SaveWorkspace"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("SaveWorkspaceDescription"));
		putValue(SMALL_ICON,loadIcon("images/saveIcon.png"));
		JevLanguageManager.getInstance().addObserver(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JevTreeNode root = ((JevTreeNode)((JevTreeModel)tree.getModel()).getRoot());
		try {
			FileManager.getInstance().saveAs(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		putValue(NAME, JevLanguageManager.getInstance().getText("SaveWorkspace"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("SaveWorkspaceDescription"));
	}
	
	
}
