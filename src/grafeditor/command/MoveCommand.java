package grafeditor.command;

import java.awt.geom.Point2D;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.view.DiagramView;

public class MoveCommand extends Command {

	private DiagramView diagramView;
	private DiagramDevice diagramDevice;
	private Point2D lastPosition;
	private Point2D newPosition;
	
	public MoveCommand(DiagramView view,DiagramDevice device, Point2D lastPosition, Point2D newPosition){
		this.diagramView = view;
		this.diagramDevice = device;
		this.lastPosition = lastPosition;
		this.newPosition = newPosition;
	}
	
	@Override
	public void redo() {
		this.diagramDevice.setPosition(newPosition);	
		diagramView.updatePerformed(null);
		diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
	}

	@Override
	public void undo() {
		this.diagramDevice.setPosition(lastPosition);		
		diagramView.updatePerformed(null);
		diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
	}

}
