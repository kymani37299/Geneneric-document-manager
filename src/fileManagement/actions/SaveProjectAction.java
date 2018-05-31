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
import jevTree.model.JevTreeNode;
import model.JevWorkspace;

public class SaveProjectAction extends JevTreeAction implements Observer{

	private JevTreeNode selectedNode;

	public SaveProjectAction(){
		this.setEnabled(true);
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(NAME, JevLanguageManager.getInstance().getText("SaveProject"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("SaveProjectDescription"));
		putValue(SMALL_ICON,loadIcon("images/saveIcon.png"));
		this.setEnabled(false);
		JevLanguageManager.getInstance().addObserver(this);
	}
	
	public void setSelectedNode(JevTreeNode node){
		this.selectedNode = node;
		if(this.selectedNode.getValue() instanceof JevWorkspace) {
			this.setEnabled(false);
		}else {
			this.setEnabled(true);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			FileManager.getInstance().saveAs(selectedNode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		putValue(NAME, JevLanguageManager.getInstance().getText("SaveProject"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("SaveProjectDescription"));
	}

}