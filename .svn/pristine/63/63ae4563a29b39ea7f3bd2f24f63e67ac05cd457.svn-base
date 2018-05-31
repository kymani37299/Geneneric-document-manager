package grafeditor.view.painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.Observable;

import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.LinkElement;

public class LinkPainter extends ElementPainter{

	protected Shape shape;
	private LinkElement link;
	
	public LinkPainter(DiagramElement element) {
		super(element);
		this.link = (LinkElement) element;
		this.link.addObserver(this);
		this.createShape();
	}

	public void paint(Graphics2D g, DiagramElement element) {
		
		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(this.shape);
	}
	
	public boolean isElementAt(Point pos){
		return this.shape.contains(pos);
	}

	private void createShape() {
		
		shape = new GeneralPath();
		
		((GeneralPath)shape).moveTo(link.getStartPosition().getX(), link.getStartPosition().getY());
		
		double halfX = link.getStartPosition().getX() + (link.getEndPosition().getX() - link.getStartPosition().getX()) / 2;
		
		((GeneralPath)shape).lineTo(halfX, link.getStartPosition().getY());
		
		((GeneralPath)shape).lineTo(halfX, link.getEndPosition().getY());
		
		((GeneralPath)shape).lineTo(link.getEndPosition().getX(), link.getEndPosition().getY());
		
	}
	
	public boolean intersects(Rectangle2D rec) {
		PathIterator iterator = shape.getPathIterator(null);
		float previousX;
		float previousY;
		float[] points = new float[6];
		iterator.currentSegment(points);
		previousX = points[0];
		previousY = points[1];
		iterator.next();
		while(!iterator.isDone()) {
			iterator.currentSegment(points);
			float newX = points[0];
			float newY = points[1];
			if(rec.intersectsLine(previousX, previousY, newX, newY)) 
				return true;
			
			previousX = newX;
			previousY = newY;
			iterator.next();
			
		}
		return false;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.createShape();
	}
}
