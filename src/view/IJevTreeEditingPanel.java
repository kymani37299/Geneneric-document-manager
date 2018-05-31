package view;

import java.awt.Component;

import jevTree.model.IJevTreeNode;

public interface IJevTreeEditingPanel {
	void initializeForAdd();
	void initializeForEdit(IJevTreeNode node);
	void applyChanges();
	IJevTreeNode getValue();
	Component getComponent();
	boolean isNodeValid();
	boolean isShouldAdd();
}
