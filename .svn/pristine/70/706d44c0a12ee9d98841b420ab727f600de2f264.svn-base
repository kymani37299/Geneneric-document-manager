package view.modelEditing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import JevLanguageManager.JevLanguageManager;
import model.element.JevTextElement;

@SuppressWarnings("serial")
public class TextEditingPanel extends JFrame implements Observer {
	
	private JPanel mainPanel;
	private JTextArea textArea;
	private JevTextElement element;

	public TextEditingPanel(JevTextElement element) {
		
		this.element = element;

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)d.getWidth() / 2, (int)d.getHeight() / 2); 
		this.setTitle((JevLanguageManager.getInstance().getText("Edit")));
		this.setLocationRelativeTo(null);
		
		this.mainPanel = new JPanel(new BorderLayout());
		this.textArea = new JTextArea();
		this.textArea.setEditable(true);
		JScrollPane scText = new JScrollPane(textArea);
		this.mainPanel.add(scText);
		this.add(this.mainPanel);
		this.element.addObserver(this);
		this.textArea.getDocument().addDocumentListener(textAreaChangeListener(this.element));
		this.textArea.setText(this.element.getText());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!this.element.getText().isEmpty() && this.element.getText() != null && !this.element.getText().equals(this.textArea.getText()))
			this.textArea.setText(this.element.getText());
	}
	
	private static DocumentListener textAreaChangeListener(JevTextElement element) {
		return new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
				    SwingUtilities.invokeLater(SetText(element, e.getDocument().getText(0, e.getDocument().getLength())));
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
				    SwingUtilities.invokeLater(SetText(element, e.getDocument().getText(0, e.getDocument().getLength())));
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
				    SwingUtilities.invokeLater(SetText(element, e.getDocument().getText(0, e.getDocument().getLength())));
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		};
	}
	
	private static Runnable SetText(JevTextElement element, String text) {
		return new Runnable() {
	        @Override
	        public void run() {
				element.setText(text);
	        }
	    };
	}
}
