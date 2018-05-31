package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JevLanguageManager.JevLanguageManager;
import jevTree.controller.IJevController;
import jevTree.model.IJevTreeNode;
import view.JevErrorDialog;
import view.JevTreeNodeEditingDialog;


public class JevTreeNodeEditingDialogListener {
	
	public static ActionListener btnOK_actionPerformed (IJevController controller, JevTreeNodeEditingDialog dialog) {
	    return new ActionListener() {
	        @Override public void actionPerformed (ActionEvent e) {
	        	if(dialog.isNodeValid()) {
		        	IJevTreeNode value = dialog.getValue();
	        		if(dialog.isShouldAdd()) 
	        			controller.addNewChild(dialog.getNodeParent(), value);
	        		else
	        			controller.editNode(dialog.getNode(), value);
		        	dialog.setVisible(false);
	        	}
	        	else
	        		(new JevErrorDialog(null, JevLanguageManager.getInstance().getText("NotAllDataValid"))).setVisible(true);;
	        		
	        }
	    };
	}
	public static ActionListener btnCancel_actionPerformed (JevTreeNodeEditingDialog dialog) {
	    return new ActionListener() {
	        @Override public void actionPerformed (ActionEvent e) {
	        	dialog.setVisible(false);
	        }
	    };
	}
}
