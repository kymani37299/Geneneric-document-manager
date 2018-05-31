package jevTree.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import JevLanguageManager.JevLanguageManager;
import jevTree.model.JevTreeModel;
import jevTree.model.JevTreeNode;
import jevTree.view.JevTree;
import model.JevWorkspace;
import view.MainFrame;

@SuppressWarnings("serial")
public class NewWorkspaceAction extends JevTreeAction implements Observer{

	private JevTree tree;
	
	
	public NewWorkspaceAction(JevTree tree){
		JevLanguageManager.getInstance().addObserver(this);
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(NAME,JevLanguageManager.getInstance().getText("NewWorkspace"));
		putValue(SHORT_DESCRIPTION,JevLanguageManager.getInstance().getText("NewWorkspaceDescription"));
		putValue(SMALL_ICON,loadIcon("images/newWorkspaceIcon.png"));
		
		this.tree = tree;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		tree.setNewRoot(new JevTreeNode(new JevWorkspace()));
		tree.setSelectionPath(new TreePath(((JevTreeModel)tree.getModel()).getRoot()));
		MainFrame.getInstance().getDesktop().getController().clearDesktop();
		tree.update();
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		putValue(NAME,JevLanguageManager.getInstance().getText("NewWorkspace"));
		putValue(SHORT_DESCRIPTION,JevLanguageManager.getInstance().getText("NewWorkspaceDescription"));
	}

}
