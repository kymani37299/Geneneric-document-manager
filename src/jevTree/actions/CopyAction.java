package jevTree.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import controller.Clipboard;
import jevTree.model.JevTreeNode;
import model.JevWorkspace;

public class CopyAction extends JevTreeAction implements Observer{

	private JevTreeNode selectedNode;
	
	public CopyAction(){
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/copyNodeIcon.png"));
		putValue(NAME, JevLanguageManager.getInstance().getText("Copy"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("CopyDescription"));
		JevLanguageManager.getInstance().addObserver(this);
		this.setEnabled(false);
	}
	
	public void setSelectedNode(JevTreeNode selectedNode){
		this.selectedNode = selectedNode;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard.getInstance().setClipboard(this.selectedNode);
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
		putValue(NAME, JevLanguageManager.getInstance().getText("Copy"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("CopyDescription"));
	}
	
}
