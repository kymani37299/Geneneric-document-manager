package grafeditor.view.painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Observer;

import grafeditor.model.elements.DiagramElement;

public abstract class ElementPainter implements Observer{

	public abstract void paint(Graphics2D g, DiagramElement element);
	
	public abstract boolean isElementAt( Point pos);

	protected DiagramElement element;
	
	public ElementPainter(DiagramElement element) {
		this.element=element;
	}

}
