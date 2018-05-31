package grafeditor.view.painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.Iterator;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.InputOutputElement;

public abstract class DevicePainter extends ElementPainter {
	
	protected Shape shape;
	
	public DevicePainter(DiagramElement device){
		super(device);
	}
	
	public void paint(Graphics2D g, DiagramElement element){
		
		if (element instanceof DiagramDevice){
			
			  DiagramDevice device=(DiagramDevice )element;
  	   		  Iterator it = device.getInputIterator();
			  while(it.hasNext()){
				    InputOutputElement d = (InputOutputElement) it.next();
				    d.getPainter().paint(g,d);
   			  } 
			  Iterator it2 = device.getOutputIterator();
			  while(it2.hasNext()){
				    InputOutputElement d2 = (InputOutputElement) it2.next();
				    d2.getPainter().paint(g,d2);
		     }	
			  
			  g.setPaint(Color.BLACK);
		}

		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(getShape());

		
		g.setPaint(element.getPaint());
		g.fill(getShape());	
	}
	
	public boolean isElementAt( Point pos){
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
