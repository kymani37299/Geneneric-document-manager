package grafeditor.model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;

import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import grafeditor.model.elements.DiagramDevice;
import grafeditor.model.elements.DiagramElement;
import grafeditor.model.elements.DeviceLinkElement;
import grafeditor.view.painters.LinkPainter;


@SuppressWarnings("serial")
public class DiagramSelectionModel extends DefaultSingleSelectionModel {

	private ArrayList<DiagramElement> selectionList = new ArrayList<DiagramElement>();
	UpdateEvent updateEvent = null;	
	
	public void addToSelectionList(DiagramElement element) {
		selectionList.add(element);
		fireUpdatePerformed();
	}
	
	public void addToSelectionList(ArrayList<DiagramElement> list) {
		selectionList.addAll(list);
		fireUpdatePerformed();
	}
	
	public int getSelectionListSize() {
		return selectionList.size();
	}
	
	public DiagramElement getElementFromSelectionListAt(int index) {
		return (DiagramElement)selectionList.get(index);
	}
	
	public int getIndexByObject(DiagramElement element) {
		return selectionList.indexOf(element);
	}
	
	public void removeFromSelectionList(DiagramElement element) {
		selectionList.remove(element);
		fireUpdatePerformed();
	}
	
	public void removeAllFromSelectionList() {
		selectionList.clear();
		fireUpdatePerformed();
	}
	
	public ArrayList<DiagramElement>  getSelectionList() {
		return selectionList;
	}
	
	public Iterator<DiagramElement> getSelectionListIterator(){
		return selectionList.iterator();
	}
	
	public boolean isElementSelected(DiagramElement element){
		return selectionList.contains(element);
		
	}

	public void selectElements(Rectangle2D rec,ArrayList<DiagramElement> elements){
		Iterator<DiagramElement> it = elements.iterator();
		while(it.hasNext()){
			DiagramElement element=it.next();
			if (element instanceof DiagramDevice){
				DiagramDevice device=(DiagramDevice)element;
				if(rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getSize().getWidth(), device.getSize().getHeight())){
					if(!isElementSelected(device))
						selectionList.add(device);
				}
			}else{
				if(element instanceof DeviceLinkElement) {
					DeviceLinkElement link = (DeviceLinkElement)element;
					if(((LinkPainter)link.getPainter()).intersects(rec))
						if(!isElementSelected(link))
							selectionList.add(link);
				}
					
			}
		}
	}
	
	 public void addUpdateListener(UpdateListener l) {
	     listenerList.add(UpdateListener.class, l);
	 }

	 public void removeUpdateListener(UpdateListener l) {
	     listenerList.remove(UpdateListener.class, l);
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
}
