package grafeditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class UndoAction extends AbstractEditorAction {

	private DiagramView diagramView;
	
	public UndoAction(DiagramView view){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_U);
		putValue(SMALL_ICON, loadIcon("images/undoIcon.png"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("Undo"));
		this.diagramView = view;
		this.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		diagramView.getCommandManager().undoCommand();
	}

}
