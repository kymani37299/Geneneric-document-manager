package model.element;

import jevTree.model.IJevTreeNode;

@SuppressWarnings("serial")
public class JevTextElement extends JevElement {
	
	private String text;

	public JevTextElement(String text) {
		super(JevElementType.Text);
		this.text = text;
	}
	
	public JevTextElement(JevTextElement element){
		super(element);
		this.text = new String(element.text);
	}

	@Override
	public IJevTreeNode clone() {
		return new JevTextElement(this);
	}
	
	@Override
	public String toString() {
		return "Text";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {	
		this.text = text;
		this.setChanged();
		this.notifyObservers();
	}

}
