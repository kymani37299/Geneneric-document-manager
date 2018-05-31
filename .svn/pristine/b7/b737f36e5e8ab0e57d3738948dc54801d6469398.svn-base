package grafeditor.model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import grafeditor.view.painters.RectanglePainter;

@SuppressWarnings("serial")
public class RectangleElement extends DiagramDevice {

	public RectangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint, strokeColor, ElementType.Rectangle, 2, 1);
		elementPainter = new RectanglePainter(this);
	}
	
	public RectangleElement(RectangleElement rectangle){
		super(rectangle);
		
		elementPainter=new RectanglePainter(this);
	}

	@Override
	public DiagramElement clone() {
		return new RectangleElement(this);
	}
	
	@Override
	public void refreshPainter() {
		super.refreshPainter();
		elementPainter = new RectanglePainter(this);
	}
	
	private Object readResolve(){
		paint =  Color.WHITE;
		stroke = new BasicStroke(2);
		strokeColor = Color.BLACK;
		return this;
	}
}
