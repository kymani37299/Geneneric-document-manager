package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import jevTree.model.IJevTreeNode;
import model.element.JevElement;
import model.element.JevElementType;

public class JevSlot extends Observable implements IJevTreeNode,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private JevElement element;
	private JevElementType type;

	public JevSlot(JevElementType type){
		super();
		this.name = "Slot";
		this.type = type;
	}
	
	private JevSlot(JevSlot slot){
		this.name = slot.name;
		if(slot.element != null ) 
			this.element = (JevElement) slot.element.clone();

		this.type = slot.type;
	}
	
	@Override
	public IJevTreeNode clone() {
		return new JevSlot(this);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
		this.setChanged();
		this.notifyObservers();	
		
	}
	
	public JevElementType getType() {
		return type;
	}

	@Override
	public boolean isEditable() {
		return false;
	}
	
	@Override
	public boolean isSerializable() {
		return false;
	}

	@Override
	public boolean getAllowsChildren() {
		return !hasChildren();
	}
	
	@Override
	public boolean hasChildren() {
		if(element==null) return false;
		else return true;
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		ArrayList<IJevTreeNode> children = new ArrayList<IJevTreeNode>(1);
		children.add((IJevTreeNode)element);
		return children;
	}

	@Override
	public void addChild(IJevTreeNode child) {
		this.element = (JevElement) child;
		this.setChanged();
		this.notifyObservers(true);	
	}

	@Override
	public void removeChild(IJevTreeNode child) {
		this.element = null;
		this.setChanged();
		this.notifyObservers(false);	
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Class getChildrenClass() {
		return JevElement.class;
	}
}
