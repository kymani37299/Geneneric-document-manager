package grafeditor.factory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

import grafeditor.model.elements.CircleElement;
import grafeditor.model.elements.CustomLinkElement;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.DeviceLinkElement;
import grafeditor.model.elements.InputOutputElement;
import grafeditor.model.elements.RectangleElement;
import grafeditor.model.elements.TriangleElement;

public class DiagramElementFactory implements DiagramElementAbstractFactory {

	@Override
	public DiagramElement createRectangle(Point2D pos) {
		Point2D position = (Point2D) pos.clone();
        RectangleElement rectangleElement=new RectangleElement(position, new Dimension(60,40), new BasicStroke(2), Color.WHITE, Color.BLACK);
		return rectangleElement;
	}

	@Override
	public DiagramElement createCircle(Point2D pos) {
		Point2D position = (Point2D) pos.clone();
	    CircleElement circleEl=new CircleElement(position, new Dimension(40,40), new BasicStroke(2), Color.WHITE, Color.BLACK);
		return circleEl;
	}

	@Override
	public DiagramElement createTriangle(Point2D pos) {
		Point2D position = (Point2D) pos.clone();
	    TriangleElement triangleEl = new TriangleElement(position, new Dimension(40,40), new BasicStroke(2), Color.WHITE, Color.BLACK);
		return triangleEl;
	}

	@Override
	public DiagramElement createCustomLink(Point2D startPosition, Point2D endPosition) {
		
		return new CustomLinkElement(new BasicStroke(2), Color.WHITE, Color.BLACK, (Point2D)startPosition.clone(), (Point2D)endPosition.clone());
	}

	@Override
	public DiagramElement createLink(InputOutputElement startElement, InputOutputElement endElement) {
		return new DeviceLinkElement(new BasicStroke(2), Color.WHITE, Color.BLACK, startElement, endElement);
	}

}
