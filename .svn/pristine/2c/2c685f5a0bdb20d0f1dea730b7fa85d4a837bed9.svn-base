package jevTree.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import jevTree.controller.IJevController;
import jevTree.model.JevTreeNode;

@SuppressWarnings("serial")
public class RemoveNodeAction extends JevTreeAction implements Observer{

	private JevTreeNode selectedNode;
	private IJevController controller;

	public RemoveNodeAction(IJevController controller){
		JevLanguageManager.getInstance().addObserver(this);
		this.controller = controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(NAME, JevLanguageManager.getInstance().getText("Remove"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("RemoveDescription"));
		putValue(SMALL_ICON,loadIcon("images/removeNodeIcon.png"));
		
		
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		this.controller.removeNode(this.selectedNode);
		
	}
	
	public JevTreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(JevTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		
	}
	
	public void updateEnabled(){
		this.setEnabled(this.selectedNode != null && !this.selectedNode.isRoot());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Remove"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("RemoveDescription"));
	}
}
