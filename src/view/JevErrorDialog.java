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
import controller.ErrorDialogController;
import view.customComponents.LabelArea;

@SuppressWarnings("serial")
public class JevErrorDialog extends JDialog {
	
	private JButton btnOK;
	
	public JevErrorDialog(Frame owner, String message) {
		super(owner, true);
		

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)d.getWidth() / 4, (int)d.getHeight() / 4); 
		this.setTitle(JevLanguageManager.getInstance().getText("Error"));
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		this.btnOK = new JButton("OK");
		this.btnOK.addActionListener(ErrorDialogController.btnOK_actionPerformed(this));
		buttonPane.add(this.btnOK);
		this.add(new LabelArea(message), BorderLayout.CENTER);
		this.add(buttonPane, BorderLayout.SOUTH);
	}
}
