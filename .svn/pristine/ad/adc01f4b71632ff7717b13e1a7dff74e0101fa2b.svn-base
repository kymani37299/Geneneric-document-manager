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
public class AddChildAction extends JevTreeAction implements Observer{

	private IJevController controller;
	private JevTreeNode selectedNode;

	public AddChildAction(IJevController controller){

		this.controller = controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/addNodeIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("Add"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("AddDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.createAddingPanel(this.selectedNode);
	}

	public void setSelectedNode(JevTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		
	}
	
	public void updateEnabled(){
		this.setEnabled(this.selectedNode != null && this.selectedNode.getAllowsChildren());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Add"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("AddDescription"));
	}
}
