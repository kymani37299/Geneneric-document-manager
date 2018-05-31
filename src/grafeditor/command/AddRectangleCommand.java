package grafeditor.command;

import java.awt.geom.Point2D;

import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;

public class AddRectangleCommand extends Command{

	private DiagramView diagramView;
	private DiagramElement element;
	
	public AddRectangleCommand(DiagramView diagramView,Point2D position) {
		this.diagramView = diagramView;
		this.element = this.diagramView.getFactory().createRectangle(position);
	}
	
	@Override
	public void redo() {
		this.diagramView.getDiagram().getModel().addDiagramElement(this.element);
	}

	@Override
	public void undo() {
		this.diagramView.getDiagram().getModel().removeElement(this.element);
	}
	
}
