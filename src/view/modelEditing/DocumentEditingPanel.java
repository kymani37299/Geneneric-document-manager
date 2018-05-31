package view.modelEditing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JevLanguageManager.JevLanguageManager;
import jevTree.model.IJevTreeNode;
import model.JevDocument;
import view.IJevTreeEditingPanel;

@SuppressWarnings("serial")
public class DocumentEditingPanel extends JPanel implements IJevTreeEditingPanel {

	private boolean shouldAdd;
	private JevDocument document;
	private JLabel lblName;
	private JTextField txtName;
	private Box box;
	
	public DocumentEditingPanel()
	{
		this.shouldAdd = false;
		
		this.lblName = new JLabel("*" + JevLanguageManager.getInstance().getText("Name") + ":");
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(this.lblName);
		this.txtName = new JTextField();
		this.txtName.setColumns(40);
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(this.txtName);
		
		this.box = Box.createVerticalBox();
		
		this.box.add(panel1);
		this.box.add(panel2);
		this.add(this.box, BorderLayout.SOUTH);
	}
	
	@Override
	public void initializeForAdd() {
		this.shouldAdd = true;

	}

	@Override
	public void initializeForEdit(IJevTreeNode node) {
		this.shouldAdd = false;
		if(node instanceof JevDocument)
			this.document = (JevDocument)node;
		else
			throw new IllegalArgumentException("Node must be of type JevDocument");

		this.txtName.setText(this.document.getName());

	}

	@Override
	public void applyChanges() {
		if(this.document == null) {
			this.document = new JevDocument();
		}
		
		this.document.setName(this.txtName.getText());
	}

	@Override
	public IJevTreeNode getValue() {
		this.applyChanges();
		return this.document;
	}

	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public boolean isNodeValid() {
		if(this.txtName.getText().isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean isShouldAdd() {
		return this.shouldAdd;
	}
}
