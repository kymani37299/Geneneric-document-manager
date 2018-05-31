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
import model.JevDocument;
import model.JevProject;

@SuppressWarnings("serial")
public class AddLinkAction extends JevTreeAction implements Observer{

	private IJevController controller;
	private JevTreeNode selectedNode;
	
	public AddLinkAction(IJevController controller){
		this.controller =controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/addLinkIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("AddLink"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("AddLinkDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		this.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Clipboard.getInstance().getClipboard() == null) return;
		if(this.selectedNode.getValue() instanceof JevProject) 
			controller.addNewChild(selectedNode, Clipboard.getInstance().getClipboard().getValue());
		else
			controller.addNewChild((JevTreeNode)selectedNode.getParent(), Clipboard.getInstance().getClipboard().getValue());
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Paste"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("PasteDescription"));
	}
	
	public void updateEnabled(){
		if(this.selectedNode != null && (this.selectedNode.getValue() instanceof JevProject || this.selectedNode.getValue() instanceof JevDocument) 
				&& Clipboard.getInstance().getClipboard() != null && Clipboard.getInstance().getClipboard().getValue() instanceof JevDocument){
			this.setEnabled(true);
		}else
			this.setEnabled(false);
	}

	public void setSelectedNode(JevTreeNode selectedNode) {
		this.selectedNode = selectedNode;
		this.updateEnabled();
	}
	
}
