package grafeditor.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.event.EventListenerList;

import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.DeviceLinkElement;

public class DiagramModel implements Serializable, Observer{

	private String name;
	protected ArrayList<DiagramElement> diagramElements =new ArrayList <DiagramElement>();
	private transient EventListenerList listenerList;
	private transient UpdateEvent updateEvent = null;
	
	public DiagramModel(){
		this.listenerList = new EventListenerList();
	}
	
	public DiagramModel(DiagramModel model){
		this.name = model.name;
		this.diagramElements = new ArrayList<DiagramElement>();
		for(DiagramElement element : model.diagramElements) 
			this.diagramElements.add(element.clone());
		
		ArrayList<DiagramElement> diagramElementsList = new ArrayList<DiagramElement>(this.diagramElements);
		for(DiagramElement element : diagramElementsList)
			if(element instanceof DeviceLinkElement)
				if(!((DeviceLinkElement)element).refreshLinks(this))
					this.diagramElements.remove(element);
		
		for(DiagramElement element : diagramElementsList)
			element.addObserver(this);
		
		this.listenerList = new EventListenerList();
	}
	
	private Object readResolve(){
		listenerList = new EventListenerList();
		
		ArrayList<DiagramElement> diagramElementsList = new ArrayList<DiagramElement>(this.diagramElements);
		for(DiagramElement element : diagramElementsList) {
			if(element instanceof DeviceLinkElement) 
				if(!((DeviceLinkElement)element).refreshLinks(this))
					this.diagramElements.remove(element);
			
			element.refreshPainter();
		}

		return this;
	}
	
	public DiagramModel clone(){
		return new DiagramModel(this);
	}
	
	public int getElementAtPosition(Point point) {
		for(int i=getElementsCount()-1;i>=0;i--){
			DiagramElement element = getElementAt(i);
			if(element.getPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}	
	
	public void removeElement(DiagramElement element){
		
		diagramElements.remove(element);
		element.deleteObserver(this);
		fireUpdatePerformed();
	}	
	
	public int getElementsCount(){
		return diagramElements.size();
	}
	
	public DiagramElement getElementAt(int i){
		return diagramElements.get(i);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	
	public Iterator<DiagramElement> getElementsIterator(){
		return diagramElements.iterator();
	}
	
	public void addDiagramElement(DiagramElement element){
		diagramElements.add(element);
		element.addObserver(this);
		fireUpdatePerformed();
	}	
		
	 public void addUpdateListener(UpdateListener l) {
	     listenerList.add(UpdateListener.class, l);
	 }

	 public void removeUpdateListener(UpdateListener l) {
	     listenerList.remove(UpdateListener.class, l);
	 }
	 
	public ArrayList<DiagramElement>  getDiagramElements() {
			return diagramElements;
	}
		
	public void fireUpdatePerformed() {
	     Object[] listeners = listenerList.getListenerList();
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==UpdateListener.class) {
	             if (updateEvent == null)
	                 updateEvent = new UpdateEvent(this);
	             ((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
	         }
	     }
	 }

	@Override
	public void update(Observable o, Object arg) {
		this.fireUpdatePerformed();
	}
}
