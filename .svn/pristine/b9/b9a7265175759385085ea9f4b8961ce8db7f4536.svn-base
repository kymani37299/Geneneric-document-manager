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
public class EditNodeAction extends JevTreeAction implements Observer{

	private IJevController controller;
	private JevTreeNode selectedNode;

	public EditNodeAction(IJevController controller){

		this.controller = controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/editNodeIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("Edit"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("EditDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.createEditingPanel(selectedNode);
	}
	
	public JevTreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(JevTreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	
	public void updateEnabled(){
		this.setEnabled(this.selectedNode.getValue().isEditable());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Edit"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("EditDescription"));
	}
}
