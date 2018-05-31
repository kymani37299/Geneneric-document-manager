package grafeditor.state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import grafeditor.command.AddLinkCommand;
import grafeditor.model.elements.CustomLinkElement;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.InputOutputElement;
import grafeditor.view.DiagramView;

public class LinkState extends State{
	private DiagramView med;
	
	private InputOutputElement startElement;
	private CustomLinkElement customLink;
	private boolean linking;
	
	public LinkState(DiagramView md) {
		this.med = md;
		
		this.startElement = null;
		this.customLink = null;
		this.linking = false;
	}
	
	public void mouseMoved(MouseEvent e) {
		Point2D point = e.getPoint();
		med.setMouseCursor(point);
	}	
	
	public void mousePressed(MouseEvent e) {
		this.startElement = null;
		this.customLink = null;
		Point mousePosition = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			int index = med.getDiagram().getModel().getElementAtPosition(mousePosition);
			if (index != -1){
				DiagramElement startGate = med.getDiagram().getModel().getElementAt(index);
				if(startGate instanceof DiagramDevice) {
					for(InputOutputElement ioElement : ((DiagramDevice) startGate).getOutputs())
						if(ioElement.getLink() == null)
							this.startElement = ioElement;
					if(this.startElement != null) {
						this.linking = true;
						Point2D startPosition = this.startElement.getPosition();
						this.customLink = (CustomLinkElement) med.getFactory().createCustomLink(startPosition, mousePosition);
						med.getDiagram().getModel().addDiagramElement(this.customLink);
					}
				}
			 }
		}
	}

	public void mouseDragged(MouseEvent e) {
		if(this.linking) {
			this.customLink.setEndPosition((Point2D)e.getPoint().clone());

			med.setLastPosition(e.getPoint());
			med.updatePerformed(null);
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.linking) {
			med.getDiagram().getModel().removeElement(this.customLink);
			this.customLink = null;
			Point position = e.getPoint();
			if (e.getButton() == MouseEvent.BUTTON1) {
				int index = med.getDiagram().getModel().getElementAtPosition(position);
				if (index != -1) {
					DiagramElement endGate = med.getDiagram().getModel().getElementAt(index);
					if(endGate instanceof DiagramDevice) {
						InputOutputElement endElement = null;
						for(InputOutputElement ioElement : ((DiagramDevice)endGate).getInputs())
							if(ioElement.getLink() == null)
								endElement = ioElement;
						if(endElement != null && endElement.getDevice() != startElement.getDevice()) {
							this.med.getCommandManager().addCommand(new AddLinkCommand(this.med, this.startElement, endElement));
						}
					}
				 }
			}
			this.linking = false;
		}
	}
}
