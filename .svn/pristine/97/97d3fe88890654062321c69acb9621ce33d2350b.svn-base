package jevTree.model;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("serial")
public class JevTreeModel extends DefaultTreeModel{

	public JevTreeModel(JevTreeNode root){
		super(root);
	}
	
	public void refreshChildren() {
		((JevTreeNode)this.root).refreshChildren(this);
	}
}
