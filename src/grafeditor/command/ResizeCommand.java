package grafeditor.command;

import java.awt.Dimension;
import java.awt.geom.Point2D;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.view.DiagramView;

public class ResizeCommand extends Command{
	
	private DiagramView diagramView;
	private DiagramDevice diagramDevice;
	private Dimension firstSize;
	private Dimension newSize;
	private Point2D position;
	private Point2D lastPosition;
	
	public ResizeCommand(DiagramView view, DiagramDevice device, Dimension lastSize, Dimension newSize, Point2D newPosition, Point2D lastPosition){
		this.diagramView = view;
		this.diagramDevice = device;
		this.firstSize = lastSize;
		this.newSize = newSize;
		this.position = newPosition;
		this.lastPosition = lastPosition;
	}
	
	@Override
	public void redo() {
		this.diagramDevice.setSize(newSize);
		this.diagramDevice.setPosition(position);
		diagramView.updatePerformed(null);
		diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
	}

	@Override
	public void undo() {
		this.diagramDevice.setSize(firstSize);
		this.diagramDevice.setPosition(lastPosition);
		diagramView.updatePerformed(null);
		diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
		
	}
}
