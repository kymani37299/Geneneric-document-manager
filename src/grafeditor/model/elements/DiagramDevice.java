package grafeditor.model.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public abstract class DiagramDevice extends DiagramElement {

	protected Dimension size;
	protected Point2D position;
	
	protected int inputNo;
	protected int outputNo;
	
	protected ArrayList<InputOutputElement> inputs=new ArrayList<InputOutputElement>();
	protected ArrayList<InputOutputElement> outputs=new ArrayList<InputOutputElement>();
	
	public DiagramDevice(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor, ElementType type, int inputNo, int outputNo){
		super(stroke, paint, strokeColor, type);
		
		this.size = size;
		position.setLocation(position.getX()-size.getWidth()/2,position.getY()-size.getHeight()/2);
		this.position = position;
		this.inputNo=inputNo;
		this.outputNo=outputNo;
		
		for (int i=0;i<inputNo;i++)
			addInput(new InputOutputElement(new Dimension(40, 25), stroke, paint, Color.BLACK, this, i + 1, InputOutputElement.INPUT));
      	
		for (int i=0;i<outputNo;i++)
			addOutput(new InputOutputElement(new Dimension(40, 25), stroke, paint, Color.BLACK, this, i + 1, InputOutputElement.OUTPUT));
	}
	
	public DiagramDevice(DiagramDevice device){
		super(device);
		this.size=device.size;
		this.position=device.position;

		
		this.inputNo=device.inputNo;
		this.outputNo=device.outputNo;	
		
		for(int i=0;i<device.inputs.size();i++)
			this.inputs.add(new InputOutputElement(device.inputs.get(i),this));
		for(int i=0;i<device.outputs.size();i++)
			this.outputs.add(new InputOutputElement(device.outputs.get(i),this));
	}	
	
	public void addInput(InputOutputElement p){
		inputs.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeInput(InputOutputElement p){
		inputs.remove(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public InputOutputElement getInputAt(int i){
		return inputs.get(i);
	}
	
	public int getInputCount(){
		return inputs.size();
	}
	
	@SuppressWarnings("rawtypes")
	public Iterator getInputIterator(){
		return inputs.iterator();
	}
	
	public void addOutput(InputOutputElement p){
		outputs.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeOutput(InputOutputElement p){
		outputs.remove(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	public InputOutputElement getOutputAt(int i){
		return outputs.get(i);
	}
	
	public int getIOutputCount(){
		return outputs.size();
	}
	
	@SuppressWarnings("rawtypes")
	public Iterator getOutputIterator(){
		return outputs.iterator();
	}
	
	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
		this.setChanged();
		this.notifyObservers();
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
		this.setChanged();
		this.notifyObservers();
	}

	public int getInputNo() {
		return inputNo;
	}

	public ArrayList<InputOutputElement> getInputs() {
		return inputs;
	}

	public int getOutputNo() {
		return outputNo;
	}

	public ArrayList<InputOutputElement> getOutputs() {
		return outputs;
	}	
	
	public void refreshPainter()
	{
		for(InputOutputElement ioElement : this.inputs)
			ioElement.refreshPainter();
			
		for(InputOutputElement ioElement : this.outputs)
			ioElement.refreshPainter();
	}
}
