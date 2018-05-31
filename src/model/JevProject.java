package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import jevTree.model.IJevTreeNode;

public class JevProject extends Observable implements IJevTreeNode,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<JevDocument> documents;
	private File path;
	
	public JevProject(){
		super();
		this.documents = new ArrayList<>();
		this.name = "Project";
	}
	
	private JevProject(JevProject project){
		this.name = project.name;
		this.documents = new ArrayList<>();
		for(JevDocument d : project.documents){
			this.documents.add((JevDocument) d.clone());
		}
	}
	
	public File getPath(){
		return this.path;
	}
	
	public void setPath(File path){
		this.path = path;
	}
	
	@Override
	public IJevTreeNode clone() {
		return new JevProject(this);
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
	public boolean isSerializable() {
		return true;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	
	@Override
	public boolean hasChildren() {
		return !documents.isEmpty();
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		ArrayList<IJevTreeNode> children = new ArrayList<IJevTreeNode>(this.documents.size());
		for(JevDocument document: this.documents)
			children.add(document);
		return children;
	}
	
	@Override
	public void addChild(IJevTreeNode child) {
		if(child instanceof JevDocument){
			this.documents.add((JevDocument) child);
		}	
		else
			throw new IllegalArgumentException();
		this.setChanged();
		this.notifyObservers();		
	}

	@Override
	public void removeChild(IJevTreeNode child) {
		if(child instanceof JevDocument){
			this.documents.remove((JevDocument) child);
		}	
		else
			throw new IllegalArgumentException();
		this.setChanged();
		this.notifyObservers();	
		
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public Class getChildrenClass() {
		return JevDocument.class;
	}
}
