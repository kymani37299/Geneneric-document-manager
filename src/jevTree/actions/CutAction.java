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
import model.JevWorkspace;

public class CutAction extends JevTreeAction implements Observer{

	private JevTreeNode selectedNode;
	private JevTreeActionManager actionManager;
	private IJevController controller;
	
	public CutAction(JevTreeActionManager actionManager,IJevController controller){
		this.actionManager = actionManager;
		this.controller = controller;
		
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/cutNodeIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("Cut"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("CutDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		
		this.setEnabled(false);
	}
	
	public void setSelectedNode(JevTreeNode selectedNode){
		this.selectedNode = selectedNode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard.getInstance().setClipboard(this.selectedNode);
		controller.removeNode(this.selectedNode);
		actionManager.getPasteAction().updateEnabled();
	}
	
	public void updateEnabled(){
		if(selectedNode==null || selectedNode.getValue() instanceof JevWorkspace){
			this.setEnabled(false);
			return;
		}else{
			this.setEnabled(true);
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("Cut"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("CutDescription"));
	}
	
}
