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
import model.JevProject;
import view.IJevTreeEditingPanel;

@SuppressWarnings("serial")
public class ProjectEditingPanel extends JPanel implements IJevTreeEditingPanel {

	private boolean shouldAdd;
	private JevProject project;
	private JLabel lblName;
	private JTextField txtName;
	private Box box;
	
	public ProjectEditingPanel()
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
		if(node instanceof JevProject)
			this.project = (JevProject)node;
		else
			throw new IllegalArgumentException("Node must be of type JevProject");

		this.txtName.setText(this.project.getName());

	}

	@Override
	public void applyChanges() {
		if(this.project == null) {
			this.project = new JevProject();
		}
		
		this.project.setName(this.txtName.getText());
	}

	@Override
	public IJevTreeNode getValue() {
		this.applyChanges();
		return this.project;
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
