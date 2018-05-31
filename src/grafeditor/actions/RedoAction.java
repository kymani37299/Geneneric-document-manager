package grafeditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class RedoAction extends AbstractEditorAction {
	
	private DiagramView diagramView;
	
	public RedoAction(DiagramView view){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_R);
		putValue(SMALL_ICON, loadIcon("images/redoIcon.png"));
		putValue(SHORT_DESCRIPTION,JevLanguageManager.getInstance().getText("Redo"));
		this.diagramView = view;
		this.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		diagramView.getCommandManager().doCommand();
	}
}
