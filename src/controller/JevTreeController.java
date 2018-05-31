package controller;

import javax.swing.tree.TreePath;

import grafeditor.model.JevGraphicElement;
import grafeditor.view.DiagramView;
import jevTree.controller.IJevController;
import jevTree.model.IJevTreeNode;
import jevTree.model.JevTreeModel;
import jevTree.model.JevTreeNode;
import jevTree.view.JevTree;
import model.JevDocument;
import model.JevPage;
import model.JevProject;
import model.JevSlot;
import model.JevWorkspace;
import model.element.JevElement;
import model.element.JevElementType;
import model.element.JevTextElement;
import view.IJevTreeEditingPanel;
import view.JevTreeNodeEditingDialog;
import view.MainFrame;
import view.modelEditing.DocumentEditingPanel;
import view.modelEditing.ProjectEditingPanel;
import view.modelEditing.SlotEditingPanel;
import view.modelEditing.TextEditingPanel;
import view.modelEditing.WorkspaceEditingPanel;

public class JevTreeController implements IJevController{

	private JevTree tree;

	@Override
	public void setTree(JevTree tree) {
		this.tree = tree;
	}
	
	@Override
	public void createAddingPanel(JevTreeNode parent) {
		
		IJevTreeNode parentValue = parent.getValue();
		IJevTreeEditingPanel editingPanel = null;
		
		if(parentValue instanceof JevWorkspace) 
			editingPanel = new ProjectEditingPanel();
		
		else if(parentValue instanceof JevProject) 
			editingPanel = new DocumentEditingPanel();
		
		else if(parentValue instanceof JevDocument) {
			this.addNewChild(parent, new JevPage());
			return;
		}
		
		else if(parentValue instanceof JevPage)
			editingPanel = new SlotEditingPanel();
		
		else{
			JevSlot slot = (JevSlot)parentValue; 
			if(slot.getType() == JevElementType.Graphic) {
				JevGraphicElement child = new JevGraphicElement();
    			this.addNewChild(parent, child);
				(new DiagramView(child)).setVisible(true);
			}
			else {
				JevTextElement child = new JevTextElement("");
    			this.addNewChild(parent, child);
				(new TextEditingPanel(child)).setVisible(true);
			}
		}
		if(editingPanel != null){
			editingPanel.initializeForAdd();
			(new JevTreeNodeEditingDialog(null, this, parent, null, editingPanel)).setVisible(true);
		}
	}

	@Override
	public void addNewChild(JevTreeNode parent, IJevTreeNode value) {
		
		JevTreeNode newNode = JevTreeNode.buildTree(value);
		((JevTreeModel)this.tree.getModel()).insertNodeInto(newNode, parent, parent.getChildCount());
		parent.add(value);
		JevTreeModel model = ((JevTreeModel)this.tree.getModel());
		model.refreshChildren();
		this.tree.expandPath(new TreePath(parent.getPath()));
		this.tree.setSelectionPath(new TreePath(newNode.getPath()));
		MainFrame.getInstance().getDesktop().getController().addPerformed(newNode);
	}

	@Override
	public void editNode(JevTreeNode node, IJevTreeNode value) {
		if(node.getParent() != null) {
			IJevTreeNode parentValue = ((JevTreeNode)node.getParent()).getValue();
			parentValue.removeChild(node.getValue());
			parentValue.addChild(value);
			node.setValue(value);
		}
		((JevTreeModel)this.tree.getModel()).nodeChanged(node);
	}

	@Override
	public void removeNode(JevTreeNode node) {
		MainFrame.getInstance().getDesktop().getController().removePerformed(node);
		JevTreeNode parentNode = (JevTreeNode)node.getParent();
		parentNode.remove(node.getValue());
		JevTreeModel model = ((JevTreeModel)this.tree.getModel());
		model.removeNodeFromParent(node);
		model.refreshChildren();
		this.tree.setSelectionPath(new TreePath(parentNode.getPath()));
	}

	@Override
	public void createEditingPanel(JevTreeNode node) {
		IJevTreeNode nodeValue = node.getValue();
		IJevTreeEditingPanel editingPanel = null;
		if(nodeValue instanceof JevWorkspace) 
			editingPanel = new WorkspaceEditingPanel();
		
		else if(nodeValue instanceof JevProject) 
			editingPanel = new ProjectEditingPanel();
		
		else if(nodeValue instanceof JevDocument) 
			editingPanel = new DocumentEditingPanel();
		
		else {
			JevElement element = (JevElement)nodeValue; 
			if(element.getType() == JevElementType.Graphic)
				(new DiagramView((JevGraphicElement)element)).setVisible(true);
			else
				(new TextEditingPanel((JevTextElement)element)).setVisible(true);
		}

		if(editingPanel != null){
			editingPanel.initializeForEdit(nodeValue);
			(new JevTreeNodeEditingDialog(null, this, null, node, editingPanel)).setVisible(true);
		}
	}

	@Override
	public void addNewChild(JevTreeNode parent, JevTreeNode value) {
		
		((JevTreeModel)this.tree.getModel()).insertNodeInto(value, parent, parent.getChildCount());
		parent.add(value);
		this.tree.expandPath(new TreePath(parent.getPath()));
		this.tree.setSelectionPath(new TreePath(value.getPath()));
		
	}

}
