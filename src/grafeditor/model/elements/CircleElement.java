package grafeditor.model.elements;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import grafeditor.view.painters.CirclePainter;

public class CircleElement extends DiagramDevice {

	public CircleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint, strokeColor, ElementType.Circle, 2, 1);
		
		elementPainter = new CirclePainter(this);
	}
	
	public CircleElement(CircleElement circle){
		super(circle);
		
		elementPainter = new CirclePainter(this);
	}

	@Override
	public DiagramElement clone() {
		return new CircleElement(this);
	}
	
	@Override
	public void refreshPainter() {
		super.refreshPainter();
		elementPainter = new CirclePainter(this);
	}
	
	private Object readResolve(){
		paint =  Color.WHITE;
		stroke = new BasicStroke(2);
		strokeColor = Color.BLACK;
		return this;
	}
}
