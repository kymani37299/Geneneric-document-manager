package grafeditor.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import grafeditor.command.AddRectangleCommand;
import grafeditor.view.DiagramView;

public class RectangleState extends State {
	
	private DiagramView diagramView; 
	
	public RectangleState(DiagramView view) {
		this.diagramView = view;
	}

	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1 && diagramView.getDiagram().getModel().getElementAtPosition(position) == -1)
			this.diagramView.getCommandManager().addCommand(new AddRectangleCommand(diagramView, position));
	}
}
