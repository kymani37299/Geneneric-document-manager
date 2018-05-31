package grafeditor.state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;
import grafeditor.view.DiagramView.Handle;

public class SelectState extends State{
	private DiagramView diagramView;
	
	private int mouseButton=0;
	private int gotElement = -1;
	private Handle gotHandle = null;
	
	public SelectState(DiagramView view) {
		this.diagramView = view;
	}
	
	
	public void mousePressed(MouseEvent e) {
		mouseButton=e.getButton();
		Point position = e.getPoint();

		if(!e.isControlDown()){
			diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
		}				
		gotElement = diagramView.getDiagram().getModel().getElementAtPosition(position);
				
		if(gotElement != -1){
					
			DiagramElement element=diagramView.getDiagram().getModel().getElementAt(gotElement);
			if (diagramView.getDiagram().getSelectionModel().isElementSelected(element)){
				diagramView.getDiagram().getSelectionModel().removeFromSelectionList(element);
			}else
				diagramView.getDiagram().getSelectionModel().addToSelectionList(element);		
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		Point2D point = e.getPoint();
		diagramView.setMouseCursor(point);
	}	

	public void mouseDragged(MouseEvent e) {
		if(mouseButton == MouseEvent.BUTTON1){
			Point position = e.getPoint();
			gotHandle = diagramView.getDeviceAndHandleForPoint(position);
			if(gotHandle != null){
				diagramView.getStateManager().setResizeState();
			}else{
				gotElement = diagramView.getDiagram().getModel().getElementAtPosition(position);
				if(gotElement != -1)
					diagramView.getStateManager().setMoveState();
				else
					diagramView.getStateManager().setLassoState();
				
			}
		}
	}
}
