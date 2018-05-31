package jevTree.actions;

import java.util.Observable;
import java.util.Observer;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import controller.Clipboard;
import fileManagement.actions.SaveProjectAction;
import jevTree.controller.IJevController;
import jevTree.model.JevTreeNode;
import view.MainFrame;

public class JevTreeActionManager implements TreeSelectionListener,Observer{
	
	private AddChildAction addChildAction;
	private RemoveNodeAction removeChildAction;
	private EditNodeAction editNodeAction;
	private SaveProjectAction saveProjectAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private CutAction cutAction;
	private AddLinkAction addLinkAction;

	public JevTreeActionManager(IJevController controller)
	{
		this.addChildAction = new AddChildAction(controller);
		this.removeChildAction = new RemoveNodeAction(controller);
		this.editNodeAction = new EditNodeAction(controller);
		this.saveProjectAction = new SaveProjectAction();
		this.copyAction = new CopyAction();
		this.pasteAction = new PasteAction(controller);
		this.cutAction = new CutAction(this,controller);
		this.addLinkAction = new AddLinkAction(controller);
		
		Clipboard.getInstance().addObserver(this);
	}
	
	private void updateEnabled(){
		this.addChildAction.updateEnabled();
		this.copyAction.updateEnabled();
		this.cutAction.updateEnabled();
		this.editNodeAction.updateEnabled();
		this.pasteAction.updateEnabled();
		this.removeChildAction.updateEnabled();
		this.addLinkAction.updateEnabled();
	}
	
	public SaveProjectAction getSaveProjectAction() {
		return this.saveProjectAction;
	}
	
	public AddChildAction getAddChildAction() {
		return this.addChildAction;
	}
	
	public RemoveNodeAction getRemoveChildAction() {
		return this.removeChildAction;
	}
	
	public EditNodeAction getEditNodeAction() {
		return editNodeAction;
	}
	
	public CopyAction getCopyAction(){
		return copyAction;
	}
	
	public PasteAction getPasteAction(){
		return pasteAction;
	}
	
	public CutAction getCutAction(){
		return cutAction;
	}
	
	public AddLinkAction getAddLinkAction(){
		return addLinkAction;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TreePath path = e.getPath();
		if(path != null) {
			JevTreeNode selectedNode = (JevTreeNode)path.getPathComponent(path.getPathCount() - 1);
			this.addChildAction.setSelectedNode(selectedNode);
			this.removeChildAction.setSelectedNode(selectedNode);
			this.editNodeAction.setSelectedNode(selectedNode);
			this.saveProjectAction.setSelectedNode(selectedNode);
			this.copyAction.setSelectedNode(selectedNode);
			this.pasteAction.setSelectedNode(selectedNode);
			this.cutAction.setSelectedNode(selectedNode);
			this.addLinkAction.setSelectedNode(selectedNode);
			this.updateEnabled();
			
			MainFrame.getInstance().getDesktop().getController().selectFrame(selectedNode);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.updateEnabled();
	}
}
