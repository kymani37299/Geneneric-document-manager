package grafeditor.model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

public class DefaultElements {
	
	private static DefaultElements instance;
	
	public static DefaultElements getInstance(){
		if(instance==null)
			instance = new DefaultElements();
		return instance;
	}
	
	public Stroke getStroke(ElementType type){
		return new BasicStroke(2);
	}
	
	public Paint getPaint(ElementType type){
		return Color.WHITE;
	}
	
	public Color getColor(ElementType type){
		return Color.BLACK;
	}
}
