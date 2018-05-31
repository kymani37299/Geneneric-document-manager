package view.modelEditing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JevLanguageManager.JevLanguageManager;
import jevTree.model.IJevTreeNode;
import model.JevSlot;
import model.element.JevElementType;
import view.IJevTreeEditingPanel;

@SuppressWarnings("serial")
public class SlotEditingPanel extends JPanel implements IJevTreeEditingPanel {
	
	private JevSlot slot;
	private JLabel lblType;
	private JComboBox<String> cmbType;
	private Box box;
	
	public SlotEditingPanel()
	{
		this.lblType = new JLabel("*" + JevLanguageManager.getInstance().getText("Type") + ":");
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(this.lblType);
		this.cmbType = new JComboBox<String>();
		this.cmbType.setPreferredSize(new Dimension(90, 30));
		this.cmbType.setMaximumSize(new Dimension(80, 35));
		for(JevElementType type : JevElementType.values())
			this.cmbType.addItem(JevElementTypeExtender.getText(type));
		
		this.cmbType.setSelectedItem(null);
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(this.cmbType);

		this.box = Box.createVerticalBox();
		
		this.box.add(panel1);
		this.box.add(panel2);
		this.add(this.box, BorderLayout.SOUTH);
	}
	
	@Override
	public void initializeForAdd() {
	}

	@Override
	public void initializeForEdit(IJevTreeNode node) {
		
		throw new IllegalArgumentException("Slots cannot be edited");
	}

	@Override
	public void applyChanges() {
		this.slot = new JevSlot(JevElementTypeExtender.getType((String)this.cmbType.getSelectedItem()));
	}

	@Override
	public IJevTreeNode getValue() {
		this.applyChanges();
		return this.slot;
	}

	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public boolean isNodeValid() {
		if(((String)this.cmbType.getSelectedItem()) == null)
			return false;
		return true;
	}

	@Override
	public boolean isShouldAdd() {
		return true;
	}
}
