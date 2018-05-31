package jevTree.model;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class JevTreeNode extends DefaultMutableTreeNode {
	
	private IJevTreeNode value;

	public JevTreeNode(IJevTreeNode value) {
		super();
		this.value = value;
	}
	
	public static JevTreeNode buildTree(IJevTreeNode value) {

		JevTreeNode root = new JevTreeNode(value); 
		if(value.hasChildren())
			for(IJevTreeNode child : value.getChildren()) 
				root.add(JevTreeNode.buildTree(child));
		return root;
	}

	public IJevTreeNode getValue() {
		return value;
	}

	public void setValue(IJevTreeNode value) {
		this.value = value;
	}
	
	@Override
	public boolean getAllowsChildren() {
		return this.value.getAllowsChildren();
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
	
	public void add(IJevTreeNode child) {
		this.value.addChild(child);
	}
	
	public void remove(IJevTreeNode child) {
		this.value.removeChild(child);
	}

	public void refreshChildren(JevTreeModel model) {
		if(this.getChildCount() > 0) {
			ArrayList<JevTreeNode> childrenList = new ArrayList<>();
			for(Object child : this.children)
				childrenList.add((JevTreeNode)child);
			
			for(JevTreeNode child : childrenList) {
				if(!this.value.getChildren().contains(child.value))
					model.removeNodeFromParent(child);
				else
					child.refreshChildren(model);
			}
			
			ArrayList<IJevTreeNode> childrenValues = new ArrayList<>();
			for(Object child : this.children)
				childrenValues.add(((JevTreeNode)child).value);
			
			for(IJevTreeNode child : this.value.getChildren()) {
				if(!childrenValues.contains(child))
					model.insertNodeInto(buildTree(child), this, this.getChildCount());
			}
		}
	}
}
