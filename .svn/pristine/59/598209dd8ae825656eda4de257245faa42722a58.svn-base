package model.element;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;

import jevTree.model.IJevTreeNode;

public abstract class JevElement extends Observable implements IJevTreeNode, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private JevElementType elementType;
	
	public JevElement(JevElementType elementType){
		this.name = "Element";
		this.elementType = elementType;
	}
	
	protected JevElement(JevElement element){
		this.name = element.name;
		this.elementType = element.elementType;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}
	
	public JevElementType getType() {
		return this.elementType;
	}
	
	@Override
	public abstract IJevTreeNode clone();
	
	@Override
	public boolean isEditable() {
		return true;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addChild(IJevTreeNode child) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeChild(IJevTreeNode child) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public boolean isSerializable() {
		return true;
	}

	@Override
	public Class getChildrenClass() {
		return null;
	}
	
}
