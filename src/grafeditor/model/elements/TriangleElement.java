package grafeditor.model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import grafeditor.view.painters.TrianglePainter;

@SuppressWarnings("serial")
public class TriangleElement extends DiagramDevice {

	public TriangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color strokeColor){
		super(position, size, stroke, paint, strokeColor, ElementType.Triangle, 1, 1);
		
		elementPainter = new TrianglePainter(this);
	}
	
	public TriangleElement(TriangleElement triangle){
		super(triangle);
		
		elementPainter=new TrianglePainter(this);
	}

	@Override
	public DiagramElement clone() {
		return new TriangleElement(this);
	}
	
	@Override
	public void refreshPainter() {
		super.refreshPainter();
		elementPainter = new TrianglePainter(this);
	}
	
	private Object readResolve(){
		paint =  Color.WHITE;
		stroke = new BasicStroke(2);
		strokeColor = Color.BLACK;
		return this;
	}
}
