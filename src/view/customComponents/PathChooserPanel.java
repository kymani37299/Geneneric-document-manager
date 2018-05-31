package view.customComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JevLanguageManager.JevLanguageManager;
import fileManagement.FileManager;
import fileManagement.UrlType;

@SuppressWarnings("serial")
public class PathChooserPanel extends JPanel {
	private File value;
	private JLabel pathLabel;
	private JButton btnBrowse;
	
	public PathChooserPanel(UrlType type) {
		super();
		this.pathLabel = new JLabel();
		this.btnBrowse = new JButton(JevLanguageManager.getInstance().getText("Browse"));
		this.btnBrowse.addActionListener(this.btnBrowse_actionPerformed(type));
		this.add(btnBrowse);
		this.add(pathLabel);
	}
	
	public File getValue() {
		return this.value;
	}
	
	public void setValue(File file) {
		this.value = file;
		if(this.value != null)
			pathLabel.setText(this.value.getAbsolutePath());
	}
	
	public boolean isPathValid() {
		return this.value != null;
	}
	
	private ActionListener btnBrowse_actionPerformed (UrlType type) {
	    return new ActionListener() {
	        @Override public void actionPerformed (ActionEvent e) {
	        	File file = FileManager.getInstance().browse(type);
	        	if(file != null) {
	        		value = file;
	        		pathLabel.setText(value.getAbsolutePath());
	        	}
	        }
	    };
	}
}
