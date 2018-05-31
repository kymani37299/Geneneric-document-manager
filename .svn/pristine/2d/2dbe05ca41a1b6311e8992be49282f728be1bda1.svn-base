package grafeditor.model.elements;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import grafeditor.view.painters.LinkPainter;

public class CustomLinkElement extends LinkElement {

	private Point2D startPosition;
	private Point2D endPosition;
	
	public CustomLinkElement(Stroke stroke, Paint paint, Color strokeColor, Point2D startPosition, Point2D endPosition) {
		super(stroke, paint, strokeColor);
		
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		elementPainter = new LinkPainter(this);
	}
	
	public CustomLinkElement(CustomLinkElement link){
		super(link);
		
		this.startPosition = link.startPosition;
		this.endPosition = link.endPosition;
	}

	@Override
	public DiagramElement clone() {
		return new CustomLinkElement(this);
	}

	@Override
	public Point2D getStartPosition() {
		return this.startPosition;
	}

	public void setStartPosition(Point2D pos) {
		this.startPosition = pos;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public Point2D getEndPosition() {
		return this.endPosition;
	}

	public void setEndPosition(Point2D pos) {
		this.endPosition = pos;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void refreshPainter() {
        elementPainter = new LinkPainter(this);
	}
}
