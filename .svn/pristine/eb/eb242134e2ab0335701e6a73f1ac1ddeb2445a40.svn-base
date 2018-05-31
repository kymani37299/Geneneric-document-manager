package grafeditor.view.painters;

import java.awt.geom.GeneralPath;
import java.util.Observable;

import grafeditor.model.elements.InputOutputElement;

public class InputOutputPainter extends DevicePainter{
	
	private InputOutputElement inputOutput;
	
	public InputOutputPainter(InputOutputElement io) {
		super(io);
		this.inputOutput = io;
		this.setShape();
		this.inputOutput.addObserver(this);
	}
	
	public void setShape(){
		shape=new GeneralPath();
		if (inputOutput.getType()==InputOutputElement.INPUT){
 	           	((GeneralPath)shape).moveTo(inputOutput.getPosition().getX(),inputOutput.getPosition().getY());
                ((GeneralPath)shape).lineTo(inputOutput.getPosition().getX()-5,inputOutput.getPosition().getY());
		}else if (inputOutput.getType()==InputOutputElement.OUTPUT){
			    ((GeneralPath)shape).moveTo(inputOutput.getPosition().getX(),inputOutput.getPosition().getY());
                ((GeneralPath)shape).lineTo(inputOutput.getPosition().getX()+5,inputOutput.getPosition().getY());
        }
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setShape();
		
	}
		
}
