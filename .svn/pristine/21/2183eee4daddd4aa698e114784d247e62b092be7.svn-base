package jevTree.view;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import jevTree.actions.JevTreeActionManager;
import jevTree.controller.IJevController;
import jevTree.controller.JevTreeModelListener;
import jevTree.model.JevTreeModel;
import jevTree.model.JevTreeNode;

@SuppressWarnings("serial")
public class JevTree extends JTree{

	private IJevController controller;
	private JevTreeModel model;
	private JevTreeActionManager actionManager;

	public JevTree(JevTreeNode root, IJevController controller) {
		this.controller = controller;
		this.controller.setTree(this);
		this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.model = new JevTreeModel(root);
		this.setModel(this.model);
		this.model.addTreeModelListener(new JevTreeModelListener(this));
		this.actionManager = new JevTreeActionManager(controller);
		this.addTreeSelectionListener(this.actionManager);
		this.setEditable(false);
	}
	
	private void selectRoot() {
		TreePath path = new TreePath(model.getRoot());
		this.setSelectionPath(path);
	}
	
	public void setNewRoot(JevTreeNode root){
		this.model = new JevTreeModel(root);
		this.model.addTreeModelListener(new JevTreeModelListener(this));
		this.setModel(this.model);
		this.selectRoot();
	}
	
	
	public void update() {
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public IJevController getController() {
		return this.controller;
	}
	
	public JevTreeActionManager getActionManager() {
		return actionManager;
	}
}
