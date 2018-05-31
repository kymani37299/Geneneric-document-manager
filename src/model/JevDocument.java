package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.UUID;

import jevTree.model.IJevTreeNode;

public class JevDocument extends Observable implements IJevTreeNode,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<JevPage> pages;
	private UUID id;
	
	public JevDocument(){
		super();
		this.name = "Document";
		this.pages = new ArrayList<>();
		this.id = UUID.randomUUID();
		
	}
	
	private JevDocument(JevDocument document){
		this.name = document.name;
		this.pages = new ArrayList<>();
		for(JevPage p : document.pages){
			pages.add((JevPage) p.clone());
		}
		this.id = UUID.randomUUID();
	}
	
	@Override
	public IJevTreeNode clone() {
		return new JevDocument(this);
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
		return true;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	
	@Override
	public boolean hasChildren() {
		return !pages.isEmpty();
	}
	
	@Override
	public boolean isSerializable() {
		return false;
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		ArrayList<IJevTreeNode> children = new ArrayList<IJevTreeNode>(this.pages.size());
		for(JevPage page: this.pages)
			children.add(page);
		return children;
	}

	@Override
	public void addChild(IJevTreeNode child) {
		if(child instanceof JevPage){
			this.pages.add((JevPage) child);
		}	
		else
			throw new IllegalArgumentException();
		this.setChanged();
		this.notifyObservers(child);		
	}

	@Override
	public void removeChild(IJevTreeNode child) {
		if(child instanceof JevPage){
			this.pages.remove((JevPage) child);
		}	
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
		return JevPage.class;
	}

	public UUID getId() {
		return id;
	}
}
