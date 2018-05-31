package grafeditor.factory;

import java.awt.geom.Point2D;

import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.InputOutputElement;

public interface DiagramElementAbstractFactory {
	DiagramElement createRectangle(Point2D pos);
	DiagramElement createCircle(Point2D pos);
	DiagramElement createTriangle(Point2D pos);
	DiagramElement createCustomLink(Point2D startPosition, Point2D endPosition);
	DiagramElement createLink(InputOutputElement startElement, InputOutputElement endElement);
}
