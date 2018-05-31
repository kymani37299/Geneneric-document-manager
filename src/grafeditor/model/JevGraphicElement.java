package grafeditor.model;

import java.io.Serializable;
import java.util.Enumeration;

import grafeditor.event.UpdateEvent;
import grafeditor.event.UpdateListener;
import jevTree.model.IJevTreeNode;
import model.element.JevElement;
import model.element.JevElementType;


@SuppressWarnings("serial")
public class JevGraphicElement extends JevElement implements Serializable, UpdateListener{
	
	private DiagramModel model;
	private transient DiagramSelectionModel selectionModel;
	
	public JevGraphicElement() {
		super(JevElementType.Graphic);

		this.model = new DiagramModel();
		this.model.addUpdateListener(this);
		this.setChanged();
		this.notifyObservers();
	}
	
	private JevGraphicElement(JevGraphicElement element){
		super(element);
		this.model = element.model.clone();
		this.model.addUpdateListener(this);
	}
	
	public DiagramModel getModel() {
		return model;
	}
	
	public void setModel(DiagramModel model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Diagram";
	}

	@SuppressWarnings("rawtypes")
	public Enumeration children() {
		return null;
	}
	
	public DiagramSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new DiagramSelectionModel();
		return selectionModel;
	}

	@Override
	public IJevTreeNode clone() {
		return new JevGraphicElement(this);
	}
	private Object readResolve() {
		this.model.addUpdateListener(this);
		return this;
	}
	
	@Override
	public void updatePerformed(UpdateEvent e) {
		this.setChanged();
		this.notifyObservers();
	}
}
