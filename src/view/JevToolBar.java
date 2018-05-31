package view;


import javax.swing.JToolBar;

import jevTree.actions.JevTreeActionManager;
import jevTree.view.JevTree;


@SuppressWarnings("serial")
public class JevToolBar extends JToolBar{
	
	public JevToolBar(JevTree tree){

	    JevTreeActionManager treeActionManager = tree.getActionManager();
	    this.add(treeActionManager.getAddChildAction());
	    this.add(treeActionManager.getRemoveChildAction());
	    this.add(treeActionManager.getEditNodeAction());
	    this.add(treeActionManager.getCutAction());
	    this.add(treeActionManager.getCopyAction());
	    this.add(treeActionManager.getPasteAction());
	    this.add(treeActionManager.getAddLinkAction());
	}

}
