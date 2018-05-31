package jevTree.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import controller.Clipboard;
import jevTree.controller.IJevController;
import jevTree.model.JevTreeNode;

@SuppressWarnings("serial")
public class PasteAction extends JevTreeAction implements Observer{

	private IJevController controller;
	private JevTreeNode selectedNode;
	private boolean parentSelected;
	
	public PasteAction(IJevController controller){
		this.controller =controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/pasteNodeIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("Paste"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("PasteDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Clipboard.getInstance().getClipboard() == null) return;
		if(parentSelected) 
			controller.addNewChild(selectedNode, Clipboard.getInstance().getClipboard().getValue().clone());
		else
			controller.addNewChild((JevTreeNode)selectedNode.getParent(), Clipboard.getInstance().getClipboard().getValue().clone());
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Paste"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("PasteDescription"));
	}
	
	public void updateEnabled(){
		if(Clipboard.getInstance().getClipboard() != null){
			if(selectedNode.getValue().getChildrenClass() != null && selectedNode.getValue().getChildrenClass().isAssignableFrom(Clipboard.getInstance().getClipboard().getValue().getClass())) {
				this.parentSelected = true;
				this.setEnabled(true);
				return;
			}
			else if(selectedNode.getValue().getClass().isAssignableFrom(Clipboard.getInstance().getClipboard().getValue().getClass())) {
				this.parentSelected = false;
				this.setEnabled(true);
				return;
			}
		}
		this.setEnabled(false);
	}

	public void setSelectedNode(JevTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		this.updateEnabled();
	}
	
}
