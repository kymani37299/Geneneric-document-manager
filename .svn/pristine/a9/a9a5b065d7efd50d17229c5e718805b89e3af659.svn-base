package grafeditor.model.elements;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.Observable;

import grafeditor.view.painters.ElementPainter;

@SuppressWarnings("serial")
public abstract class DiagramElement extends Observable implements Serializable {
	
	protected transient Paint paint;
	protected transient Stroke stroke;
	protected transient Color strokeColor;
	
	private ElementType type;
	protected String name;
	protected String description;
	
	protected transient ElementPainter elementPainter;
	
	abstract public DiagramElement clone();
	
	public DiagramElement(Stroke stroke, Paint paint, Color strokeColor, ElementType type){
		this.type = type;
		this.stroke = stroke;
		this.paint = paint;
		this.strokeColor = strokeColor;
	}
	
	public DiagramElement(DiagramElement element) {
		this.type = element.type;
		this.stroke = element.stroke;
		this.paint = element.paint;
		this.strokeColor = element.strokeColor;
		this.name = element.name;
		this.description = element.description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ElementPainter getPainter(){
		return elementPainter;
	}

	public Paint getPaint() {
		return paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public String toString(){
		return name;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}
	
	public abstract void refreshPainter();
}
