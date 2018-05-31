package jevTree.controller;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import jevTree.view.JevTree;

public class JevTreeModelListener implements TreeModelListener {

	private JevTree tree;
	
	public JevTreeModelListener(JevTree tree) {
		this.tree = tree;
	}
	
	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		this.tree.update();
		
	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {
		this.tree.expandPath(e.getTreePath());
		this.tree.update();
		
	}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {
		this.tree.update();
		
	}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {
		this.tree.update();
		
	}

}
