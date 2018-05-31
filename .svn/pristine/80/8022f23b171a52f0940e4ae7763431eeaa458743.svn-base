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
import model.JevProject;
import model.JevWorkspace;
import view.MainFrame;

public class OpenAction extends JevTreeAction implements Observer{

	private JevTree tree;
	
	public OpenAction(JevTree tree){
		JevLanguageManager.getInstance().addObserver(this);
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(NAME, JevLanguageManager.getInstance().getText("Open"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("OpenDescription"));
		putValue(SMALL_ICON,loadIcon("images/openIcon.png"));
		
		this.tree = tree;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JevTreeNode node = FileManager.getInstance().open();
			if(node.getValue() instanceof JevWorkspace){
				JevTreeNode newNode = JevTreeNode.buildTree(node.getValue());
				tree.setNewRoot(newNode);
				MainFrame.getInstance().getDesktop().getController().addPerformed(newNode);
			}
			else if(node.getValue() instanceof JevProject){
				JevTreeNode newNode = JevTreeNode.buildTree(node.getValue());
				((JevTreeNode)((JevTreeModel)tree.getModel()).getRoot()).add(newNode);
				MainFrame.getInstance().getDesktop().getController().addPerformed(newNode);
			}
			tree.update();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Open"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("OpenDescription"));
	}

}
