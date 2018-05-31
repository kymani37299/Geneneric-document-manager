package grafeditor.model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import grafeditor.view.painters.InputOutputPainter;

@SuppressWarnings("serial")
public class InputOutputElement extends DiagramElement implements Observer{

	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	
	protected DiagramDevice device;

	protected int ioNo;
    protected int type;
    
    private transient DeviceLinkElement link;
    
    private UUID id;

	public InputOutputElement( Dimension size, Stroke stroke, Paint paint,Color strokeColor,
			                  DiagramDevice device, int ioNo, int type) {
		super(stroke, paint, strokeColor, ElementType.IO);
		
		this.device = device;
		this.device.addObserver(this);
		this.ioNo = ioNo;
		this.type = type;
		this.link = null;
		this.id = UUID.randomUUID();
		elementPainter=new InputOutputPainter(this);
	}
	

	public InputOutputElement(InputOutputElement element,DiagramDevice device) {
			super( element);
			this.device = device;
			this.device.addObserver(this);
			this.ioNo = element.ioNo;
			this.type = element.type;
			this.id = element.id; //Ovo ne bi radilo kada bi imali copy paste unutar grafickog editora, ali s obzirom na to da nemamo vremena da ispravimo, ostavljamo ovako
			elementPainter=new InputOutputPainter(this);

	}
	
	public Point2D getPosition() {
		int absoluteX = 0;
		int absoluteY = 0;
		
		if (this.type==INPUT){
			if(device instanceof TriangleElement){
				absoluteX=(int) device.getPosition().getX()+7;
				absoluteY=(int) (device.position.getY()+(device.getSize().getHeight()/(device.getInputNo() +1))*(ioNo));
			}else{
				absoluteX=(int) device.getPosition().getX();
				absoluteY=(int) (device.position.getY()+(device.getSize().getHeight()/(device.getInputNo() +1))*(ioNo));
			}        
		}else if (this.type==OUTPUT){
			if(device instanceof TriangleElement){
				absoluteX=(int) device.position.getX()+device.getSize().width-7;
				absoluteY=(int) (device.position.getY()+(device.getSize().getHeight()/((device.getOutputNo() +1)*(ioNo))));
			}else{
				absoluteX=(int) device.position.getX()+device.getSize().width;
				absoluteY=(int) (device.position.getY()+(device.getSize().getHeight()/((device.getOutputNo() +1)*(ioNo))));
			} 
		}
		return new Point(absoluteX,absoluteY);
	}

	public int getType() {
		return type;
	}

	@Override
	public DiagramElement clone() {
		return new InputOutputElement(this, device);
	}

	public DiagramDevice getDevice() {
		return device;
	}
	
	public DeviceLinkElement getLink() {
		return this.link;
	}
	
	public void setLink(DeviceLinkElement value) {
		this.link = value;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void refreshPainter() {
		elementPainter = new InputOutputPainter(this);
	}
	
	private Object readResolve(){
		paint =  Color.WHITE;
		stroke = new BasicStroke(2);
		strokeColor = Color.BLACK;
		return this;
	}
}
