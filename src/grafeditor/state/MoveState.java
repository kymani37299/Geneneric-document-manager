package grafeditor.state;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

import grafeditor.command.MoveCommand;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;

public class MoveState extends State {

	private DiagramView diagramView;
	private DiagramDevice movedDevice;
	private Point2D firstPosition;
	private boolean release;
	
	public MoveState(DiagramView view){
		this.diagramView = view;
		this.release = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		diagramView.getFramework().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		Point2D lastPosition = e.getPoint();
		double xx=lastPosition.getX()-diagramView.getLastPosition().getX(); 
		double yy=lastPosition.getY()-diagramView.getLastPosition().getY();
		Iterator<DiagramElement> it = diagramView.getDiagram().getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			DiagramElement element =  it.next();
			if (element instanceof DiagramDevice){
				DiagramDevice device = (DiagramDevice) element;
				if(!release){
					firstPosition = device.getPosition();
					movedDevice = device;
					release = true;
				}
				Point2D newPosition = (Point2D)device.getPosition().clone();
				newPosition.setLocation(newPosition.getX() + xx,newPosition.getY() + yy);
				device.setPosition(newPosition);
			}
		}
		diagramView.setLastPosition(lastPosition);
		diagramView.updatePerformed(null);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		release = false;
		if(diagramView != null && firstPosition!=null)
			diagramView.getCommandManager().addCommand(new MoveCommand(diagramView,movedDevice, firstPosition, movedDevice.getPosition()));
		diagramView.getFramework().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Point2D lastPosition = e.getPoint();
		diagramView.setLastPosition(lastPosition);
		diagramView.getStateManager().setSelectState();
	}
	
	
}
