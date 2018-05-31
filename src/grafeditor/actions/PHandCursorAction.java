package grafeditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import JevLanguageManager.JevLanguageManager;
import grafeditor.view.DiagramView;

@SuppressWarnings("serial")
public class PHandCursorAction extends AbstractEditorAction {

	private DiagramView diagramView;
	
	public PHandCursorAction(DiagramView view) {
		
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/handc.png"));
		putValue(SHORT_DESCRIPTION, JevLanguageManager.getInstance().getText("SelectMode"));
		
		this.diagramView = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		this.diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
		this.diagramView.getStateManager().setSelectState();
	}

}
