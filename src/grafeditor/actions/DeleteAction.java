package grafeditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import grafeditor.command.DeleteCommand;
import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class DeleteAction extends AbstractEditorAction{
	
	private DiagramView diagramView;
	
	public DeleteAction(DiagramView view) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/delIcon.png"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("Delete"));
		this.diagramView = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.diagramView.getStateManager().setSelectState();
		this.diagramView.getCommandManager().addCommand(new DeleteCommand(this.diagramView));
	}
}
