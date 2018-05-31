package grafeditor.actions;

import grafeditor.view.DiagramView;

public class JevGraphicActionManager {
	
	private PRectangleAction pRectangleAction;
	private PTriangleAction pTriangleAction;
	private PHandCursorAction pHandCursorAction;
	private PCircleAction pCircleAction;
	private DeleteAction deleteAction;
	private LinkAction linkAction;
	private UndoAction undoAction;
	private RedoAction redoAction;
	
	public JevGraphicActionManager(DiagramView view){
		initialiseActions(view);
	}

	private void initialiseActions(DiagramView view) {
		
		pHandCursorAction = new PHandCursorAction(view);
		pRectangleAction = new PRectangleAction(view);
		pTriangleAction = new PTriangleAction(view);
		pCircleAction = new PCircleAction(view);
		deleteAction = new DeleteAction(view);
		linkAction = new LinkAction(view);
		undoAction = new UndoAction(view);
		redoAction = new RedoAction(view);
	}
	
	public PRectangleAction getpRectangleAction() {
		return pRectangleAction;
	}

	public void setpRectangleAction(PRectangleAction pRectangleAction) {
		this.pRectangleAction = pRectangleAction;
	}

	public PTriangleAction getpTriangleAction() {
		return pTriangleAction;
	}

	public void setpTriangleAction(PTriangleAction pTriangleAction) {
		this.pTriangleAction = pTriangleAction;
	}

	public PHandCursorAction getPhandCursorAction() {
		return pHandCursorAction;
	}

	public void setpHandCursorAction(PHandCursorAction pHandCursorAction) {
		this.pHandCursorAction = pHandCursorAction;
	}

	public PCircleAction getpCircleAction() {
		return pCircleAction;
	}

	public void setpCircleAction(PCircleAction pCircleAction) {
		this.pCircleAction = pCircleAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	public void setDeleteAction(DeleteAction deleteAction) {
		this.deleteAction = deleteAction;
	}

	public LinkAction getLinkAction() {
		return linkAction;
	}

	public void setLinkAction(LinkAction linkAction) {
		this.linkAction = linkAction;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}		
}
