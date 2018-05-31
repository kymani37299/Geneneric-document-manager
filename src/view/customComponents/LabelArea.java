package view.customComponents;

import javax.swing.JTextArea;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class LabelArea extends JTextArea {
	public LabelArea(String text)
	{
		super(2, 20);
		this.setText(text);
		this.setWrapStyleWord(true);
		this.setLineWrap(true);
		this.setOpaque(false);
		this.setEditable(false);
		this.setFocusable(false);
		this.setBackground(UIManager.getColor("Label.background"));
		this.setFont(UIManager.getFont("Label.font"));
		this.setBorder(UIManager.getBorder("Label.border"));
	}
}
