package grafeditor.state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import grafeditor.view.DiagramView;

public class LassoState extends State {
	
	Rectangle2D rect=new Rectangle2D.Double();
	private DiagramView diagramView; 
	
	public LassoState(DiagramView view) {
		this.diagramView = view;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D mousePos=e.getPoint();

		if(!e.isControlDown()){
			diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
		}
		
		double width=mousePos.getX()-diagramView.getLastPosition().getX();
		double height=mousePos.getY()-diagramView.getLastPosition().getY();
		
		if((width<0)&&(height<0)){
			rect.setRect(mousePos.getX(), mousePos.getY(),Math.abs(width),Math.abs(height));
		}
		else if((width<0)&&(height>=0)){
			rect.setRect(mousePos.getX(), diagramView.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		else if((width>0)&&(height<0)){
			rect.setRect(diagramView.getLastPosition().getX(), mousePos.getY(), Math.abs(width),Math.abs(height));
		}
		else{
			rect.setRect(diagramView.getLastPosition().getX(), diagramView.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		
		diagramView.getFramework().setSelectionRectangle(rect);
		diagramView.getDiagram().getSelectionModel().selectElements(rect, diagramView.getDiagram().getModel().getDiagramElements()); 
		diagramView.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {		
		diagramView.getFramework().setSelectionRectangle(new Rectangle2D.Double(0,0,0,0));
		diagramView.repaint();
		diagramView.getStateManager().setSelectState();
	}
}
