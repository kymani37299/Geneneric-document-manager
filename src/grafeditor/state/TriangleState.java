package grafeditor.state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import grafeditor.command.AddTriangleCommand;
import grafeditor.view.DiagramView;

public class TriangleState extends State {
	
	private DiagramView diagramView; 
	
	public TriangleState(DiagramView view) {
		this.diagramView = view;
	}
	
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1 && diagramView.getDiagram().getModel().getElementAtPosition(position) == -1)
			this.diagramView.getCommandManager().addCommand(new AddTriangleCommand(diagramView, position));
	}
}
