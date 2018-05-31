package grafeditor.model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import grafeditor.model.DiagramModel;
import grafeditor.view.painters.LinkPainter;

public class DeviceLinkElement extends LinkElement implements Observer {

	private static final long serialVersionUID = 1L;
	
	private UUID startID;
	private UUID endID;
	private transient InputOutputElement startElement;
	private transient InputOutputElement endElement;
	
	public DeviceLinkElement(Stroke stroke, Paint paint, Color strokeColor, InputOutputElement startElement, InputOutputElement endElement) {
		super(stroke, paint, strokeColor);
		
		this.startElement = startElement;
		this.startElement.setLink(this);
		this.startElement.addObserver(this);
		this.endElement = endElement;
		this.endElement.setLink(this);
		this.endElement.addObserver(this);

		this.startID = this.startElement.getId();
		this.endID = this.endElement.getId();
		
		elementPainter = new LinkPainter(this);
	}
	
	public DeviceLinkElement(DeviceLinkElement link){
		super(link);
		
		this.startID = link.startID;
		this.endID = link.endID;
	}

	@Override
	public DiagramElement clone() {
		return new DeviceLinkElement(this);
	}

	@Override
	public Point2D getStartPosition() {
		return this.startElement.getPosition();
	}

	@Override
	public Point2D getEndPosition() {
		return this.endElement.getPosition();
	}

	public UUID getStartID() {
		return startID;
	}

	public void setStartID(UUID startID) {
		this.startID = startID;
	}

	public UUID getEndID() {
		return endID;
	}

	public void setEndID(UUID endID) {
		this.endID = endID;
	}
	
	public boolean refreshLinks(DiagramModel model) {
		this.startElement = null;
		this.endElement = null;
		for(DiagramElement element : model.getDiagramElements())
			if(element instanceof DiagramDevice) {
				for(InputOutputElement ioElement : ((DiagramDevice)element).getOutputs())
					if(ioElement.getId().equals(startID))
						this.startElement = ioElement;
			}

		for(DiagramElement element : model.getDiagramElements())
			if(element instanceof DiagramDevice) {
				for(InputOutputElement ioElement : ((DiagramDevice)element).getInputs())
					if(ioElement.getId().equals(endID))
						this.endElement = ioElement;
			}

		if(this.startElement != null && this.endElement != null) {
            elementPainter = new LinkPainter(this);
            this.startElement.addObserver(this);
            this.startElement.setLink(this);
            this.endElement.addObserver(this);
            this.endElement.setLink(this);
        }
		return this.startElement != null && this.endElement != null;
	}
	
	public void delete() {
		this.startElement.setLink(null);
		this.endElement.setLink(null);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}
	
	private Object readResolve(){
		paint =  Color.WHITE;
		stroke = new BasicStroke(2);
		strokeColor = Color.BLACK;
		return this;
	}

	@Override
	public void refreshPainter() {
        elementPainter = new LinkPainter(this);
	}
}
