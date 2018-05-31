package grafeditor.view.painters;

import java.awt.geom.GeneralPath;
import java.util.Observable;

import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.RectangleElement;

public class RectanglePainter extends DevicePainter{

	private RectangleElement rectangle;
	
	public RectanglePainter(DiagramElement device) {
		super(device);
		this.rectangle = (RectangleElement) device;
		this.setShape();
		this.rectangle.addObserver(this);
	}

	private void setShape(){
		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY());
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getSize().width,rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setShape();
	}
}
