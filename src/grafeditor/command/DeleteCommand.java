package grafeditor.command;

import java.util.ArrayList;

import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.DeviceLinkElement;
import grafeditor.model.elements.InputOutputElement;
import grafeditor.view.DiagramView;

public class DeleteCommand extends Command{

	private ArrayList<DiagramElement> elements;
	private DiagramView diagramView;
	
	public DeleteCommand(DiagramView diagramView){
		this.diagramView = diagramView;
		this.elements = new ArrayList<DiagramElement>();
		for(DiagramElement element : diagramView.getDiagram().getSelectionModel().getSelectionList()){
			this.elements.add(element);
			if(element instanceof DiagramDevice) {
				for(InputOutputElement ioElement : ((DiagramDevice)element).getInputs())
					if(ioElement.getLink() != null && !this.elements.contains(ioElement.getLink())) 
						this.elements.add(ioElement.getLink());
					
				for(InputOutputElement ioElement : ((DiagramDevice)element).getOutputs())
					if(ioElement.getLink() != null && !this.elements.contains(ioElement.getLink())) 
						this.elements.add(ioElement.getLink());
			}
		}
	}
	
	@Override
	public void redo() {
		for(DiagramElement element : elements){
			if(element instanceof DeviceLinkElement){
				DeviceLinkElement linkElement = (DeviceLinkElement)element;
				linkElement.delete();
			}
			this.diagramView.getDiagram().getModel().removeElement(element);
		}
		this.diagramView.getDiagram().getSelectionModel().removeAllFromSelectionList();
	}

	@Override
	public void undo() {
		for(DiagramElement element : elements){
			this.diagramView.getDiagram().getModel().addDiagramElement(element);
			if(element instanceof DeviceLinkElement){
				DeviceLinkElement linkElement = (DeviceLinkElement)element;
				linkElement.refreshLinks(this.diagramView.getDiagram().getModel());
			}
		}
	}
}
