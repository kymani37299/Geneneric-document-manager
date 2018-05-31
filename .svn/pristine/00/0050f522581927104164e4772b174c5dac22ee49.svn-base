package grafeditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class PCircleAction extends AbstractEditorAction {

	private DiagramView diagramView;
	
	public PCircleAction(DiagramView view) {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/circleIcon.png"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("Circle"));
		this.diagramView = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
		this.diagramView.getStateManager().setCircleState();
	}

}
