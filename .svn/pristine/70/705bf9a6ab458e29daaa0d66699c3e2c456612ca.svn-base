package grafeditor.model.elements;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public abstract class LinkElement extends DiagramElement {

	public LinkElement(Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor, ElementType.Link);
	}
	public LinkElement(LinkElement link){
		this(link.stroke, link.paint, link.strokeColor);
	}
	
	public abstract Point2D getStartPosition();
	public abstract Point2D getEndPosition();
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
}
