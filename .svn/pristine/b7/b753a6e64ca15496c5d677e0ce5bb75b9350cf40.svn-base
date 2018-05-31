package grafeditor.state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

import grafeditor.command.ResizeCommand;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.view.DiagramView;
import grafeditor.view.DiagramView.Handle;

public class ResizeState extends State {
	
	private DiagramView diagramView;
	private DiagramDevice changedDevice;
	private Dimension firstSize;
	private Dimension newSize;
	private Point2D position;
	private Point2D lastPosition;
	private boolean release = false;
	private Handle gotHandle = null;
	
	public ResizeState(DiagramView view){
		this.diagramView = view;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point2D position = e.getPoint();
		if (gotHandle==null){
			gotHandle = diagramView.getDeviceAndHandleForPoint(position);
		}
		if (gotHandle!=null){
			Iterator<DiagramElement> it = diagramView.getDiagram().getSelectionModel().getSelectionListIterator();
			while(it.hasNext()){
				DiagramElement element =  it.next();
				if (element instanceof DiagramDevice ){
					DiagramDevice device=(DiagramDevice) element;

					this.changedDevice = device;
					
					if(!release){
						this.firstSize = device.getSize();
						this.lastPosition = device.getPosition();
						release = true;
					}
					
					switch(gotHandle.ordinal()){
						case 0:{	
							double posX=(device.getPosition().getX())-position.getX();
							double posY=(device.getPosition().getY())-position.getY();					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							Point newPosition = new Point();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							newPosition.setLocation(device.getPosition().getX()-posX, device.getPosition().getY()-posY);
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
					
						case 1:{	
							double posX=0;
							double posY=device.getPosition().getY()-position.getY();					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							Point newPosition = new Point();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							newPosition.setLocation(device.getPosition().getX(), device.getPosition().getY()-posY);
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						case 2:{	
							double posX = position.getX()-(device.getPosition().getX()+device.getSize().getWidth());
							double posY = device.getPosition().getY() - position.getY();			
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							Point newPosition = new Point();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							newPosition.setLocation(device.getPosition().getX(), device.getPosition().getY()-posY);
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						case 3:{	
							double posX=device.getPosition().getX()-position.getX();
							double posY=0;					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							Point newPosition = new Point();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							newPosition.setLocation(device.getPosition().getX()-posX, device.getPosition().getY());
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						case 4:{	
							double posX=position.getX()-(device.getPosition().getX()+device.getSize().getWidth());
							double posY=0;					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							Point2D newPosition = device.getPosition();
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						
						case 5:{	
							double posX=device.getPosition().getX()-position.getX();
							double posY=(device.getPosition().getY()+device.getSize().getHeight())-position.getY();					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()-posY;
							Dimension newSize = new Dimension();
							Point newPosition = new Point();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							newPosition.setLocation(device.getPosition().getX()-posX, device.getPosition().getY());
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						case 6:{	
							double posX=0;
							double posY=position.getY()-(device.getPosition().getY()+device.getSize().getHeight());					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							Point2D newPosition = device.getPosition();
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
						case 7:{	
							double posX=position.getX()-(device.getPosition().getX()+device.getSize().getWidth());
							double posY=position.getY()-(device.getPosition().getY()+device.getSize().getHeight());					
							double newWidth = device.getSize().getWidth()+posX;
							double newHeight = device.getSize().getHeight()+posY;
							Dimension newSize = new Dimension();
							newSize.setSize(newWidth, newHeight);
							device.setSize(newSize);
							Point2D newPosition = device.getPosition();
							device.setPosition(newPosition);
							this.newSize = newSize;
							this.position = newPosition;
							break;
						}
					}
				}
				diagramView.updatePerformed(null);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		release = false;
		diagramView.getCommandManager().addCommand(new ResizeCommand(diagramView, changedDevice, firstSize, newSize, position, lastPosition));
		diagramView.getStateManager().setSelectState();		
		gotHandle = null;
	}
}
