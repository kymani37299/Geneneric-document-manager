package grafeditor.view.painters;

import java.awt.geom.GeneralPath;
import java.util.Observable;

import grafeditor.model.elements.CircleElement;
import grafeditor.model.elements.DiagramElement;

public class CirclePainter extends DevicePainter {

	private CircleElement circle;
	
	public CirclePainter(DiagramElement device) {
		super(device);
		this.circle = (CircleElement) device;
		this.SetShape();
		this.circle.addObserver(this);
	}
	
	private void SetShape() {
		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(circle.getPosition().getX()+circle.getSize().getWidth()/2,circle.getPosition().getY());
		
		((GeneralPath)shape).quadTo(circle.getPosition().getX()+circle.getSize().getWidth(), circle.getPosition().getY(), 
				circle.getPosition().getX()+circle.getSize().getWidth(), circle.getPosition().getY()+circle.getSize().getHeight()/2);
		
		((GeneralPath)shape).quadTo(circle.getPosition().getX()+circle.getSize().getWidth(), circle.getPosition().getY()+circle.getSize().getHeight(),
				circle.getPosition().getX()+circle.getSize().getWidth()/2, circle.getPosition().getY()+circle.getSize().getHeight());
		
		((GeneralPath)shape).quadTo(circle.getPosition().getX(), circle.getPosition().getY()+circle.getSize().getHeight(),
				circle.getPosition().getX(), circle.getPosition().getY()+circle.getSize().getHeight()/2);


		((GeneralPath)shape).quadTo(circle.getPosition().getX(), circle.getPosition().getY(),
				circle.getPosition().getX()+circle.getSize().getWidth()/2,circle.getPosition().getY());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.SetShape();
	}	
}
