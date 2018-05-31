package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import JevLanguageManager.JevLanguageManager;
import controller.JevTreeNodeEditingDialogListener;
import jevTree.controller.IJevController;
import jevTree.model.IJevTreeNode;
import jevTree.model.JevTreeNode;

@SuppressWarnings("serial")
public class JevTreeNodeEditingDialog extends JDialog {
	
	private JevTreeNode nodeParent;
	private JevTreeNode node;
	
	private JButton btnOK;
	private JButton btnCancel;
	private IJevTreeEditingPanel panel;
	
	public JevTreeNodeEditingDialog(Frame owner, IJevController controller,  JevTreeNode nodeParent, JevTreeNode node, IJevTreeEditingPanel panel) {
		super(owner, true);
		
		this.panel = panel;
		this.nodeParent = nodeParent;
		this.node = node;
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)d.getWidth() / 2, (int)d.getHeight() / 2); 
		this.setTitle((JevLanguageManager.getInstance().getText("Edit")));
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		this.btnOK = new JButton(JevLanguageManager.getInstance().getText("OK"));
		this.btnOK.addActionListener(JevTreeNodeEditingDialogListener.btnOK_actionPerformed(controller, this));
		buttonPane.add(this.btnOK);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		this.btnCancel = new JButton(JevLanguageManager.getInstance().getText("Cancel"));
		this.btnCancel.addActionListener(JevTreeNodeEditingDialogListener.btnCancel_actionPerformed(this));
		buttonPane.add(this.btnCancel);
		this.add(panel.getComponent(), BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);
	}
	
	public JevTreeNode getNodeParent() {
		return nodeParent;
	}

	public JevTreeNode getNode() {
		return node;
	}
	
	public void applyChanges() {
		this.panel.applyChanges();
	}
	
	public IJevTreeNode getValue() {
		return this.panel.getValue();
	}
	
	public boolean isNodeValid() {
		return this.panel.isNodeValid();
	}
	
	public boolean isShouldAdd() {
		return this.panel.isShouldAdd();
	}
}
