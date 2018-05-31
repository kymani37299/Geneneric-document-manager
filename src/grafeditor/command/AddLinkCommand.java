package grafeditor.command;

import grafeditor.model.elements.DeviceLinkElement;
import grafeditor.model.elements.InputOutputElement;
import grafeditor.view.DiagramView;

public class AddLinkCommand extends Command{

	private DiagramView diagramView;
	private DeviceLinkElement element;
	
	public AddLinkCommand(DiagramView diagramView, InputOutputElement startElement, InputOutputElement endElement) {
		this.diagramView = diagramView;
		this.element = (DeviceLinkElement)this.diagramView.getFactory().createLink(startElement, endElement);
	}
	
	@Override
	public void redo() {
		this.diagramView.getDiagram().getModel().addDiagramElement(this.element);
		this.element.refreshLinks(this.diagramView.getDiagram().getModel());
	}

	@Override
	public void undo() {
		this.diagramView.getDiagram().getModel().removeElement(this.element);
		this.element.delete();
	}
	
}
