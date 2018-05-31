package grafeditor.view.painters;

import java.awt.geom.GeneralPath;
import java.util.Observable;

import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.TriangleElement;

public class TrianglePainter extends DevicePainter {

	private TriangleElement triangle;
	
	public TrianglePainter(DiagramElement device) {
		super(device);
		this.triangle = (TriangleElement) device;
		this.SetShape();
		this.triangle.addObserver(this);
		
	}

	private void SetShape() {

		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(triangle.getPosition().getX(),triangle.getPosition().getY()+triangle.getSize().height);
		
		((GeneralPath)shape).lineTo(triangle.getPosition().getX() + triangle.getSize().width/2,triangle.getPosition().getY()+triangle.getSize().height-triangle.getSize().height);
		
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+ triangle.getSize().width,triangle.getPosition().getY()+triangle.getSize().height);
	
		((GeneralPath)shape).closePath();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.SetShape();
	}	
}
