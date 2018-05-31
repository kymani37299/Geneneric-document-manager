package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import jevTree.model.IJevTreeNode;

@SuppressWarnings("serial")
public class JevPage extends Observable implements IJevTreeNode,Serializable {
	
	private String name;
	private ArrayList<JevSlot> slots;
	
	public JevPage(){
		super();
		this.name = "Page";
		this.slots = new ArrayList<>();
		
	}
	
	private JevPage(JevPage page){
		this.name = page.name;
		this.slots = new ArrayList<>();
		for(JevSlot s : page.slots){
			slots.add((JevSlot) s.clone());
		}
	}
	
	@Override
	public IJevTreeNode clone() {
		return new JevPage(this);
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
		return true;
	}
	
	@Override
	public boolean hasChildren() {
		return !slots.isEmpty();
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		ArrayList<IJevTreeNode> children = new ArrayList<IJevTreeNode>(this.slots.size());
		for(JevSlot slot: this.slots)
			children.add(slot);
		return children;
	}

	@Override
	public void addChild(IJevTreeNode child) {
		if(child instanceof JevSlot)
			this.slots.add((JevSlot) child);
		else
			throw new IllegalArgumentException();
		this.setChanged();
		this.notifyObservers(child);		
	}

	@Override
	public void removeChild(IJevTreeNode child) {
		if(child instanceof JevSlot)
			this.slots.remove((JevSlot) child);
		else
			throw new IllegalArgumentException();
		this.setChanged();
		this.notifyObservers(child);	
		
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Class getChildrenClass() {
		return JevSlot.class;
	}
}
