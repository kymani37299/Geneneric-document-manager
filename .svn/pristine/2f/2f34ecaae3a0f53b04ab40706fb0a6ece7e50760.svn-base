package jevTree.actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.TreePath;

import jevTree.model.JevTreeNode;
import jevTree.view.JevTree;
import model.JevDocument;
import view.MainFrame;

public class OpenDocumentAction implements MouseListener{

	private JevTree tree;
	
	public OpenDocumentAction(JevTree tree) {
		this.tree = tree;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		TreePath path = tree.getPathForLocation(e.getX(), e.getY());
		if(path == null)return;
		JevTreeNode node = (JevTreeNode)path.getLastPathComponent();
		if(node == null)return;
		if(e.getClickCount()==2){
			if(node.getValue() instanceof JevDocument){
				MainFrame.getInstance().getDesktop().getController().openFrame(node);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
