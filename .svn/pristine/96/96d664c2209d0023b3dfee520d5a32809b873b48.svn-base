package controller;

import java.util.Observable;

import jevTree.model.JevTreeNode;

public class Clipboard extends Observable{
	private static Clipboard instance;
	private JevTreeNode clipboard;
	
	public JevTreeNode getClipboard() {
		return this.clipboard;
	}
	
	public void setClipboard(JevTreeNode clipboard) {
		this.clipboard = clipboard;
		this.setChanged();
		this.notifyObservers();
	}
	
	public static Clipboard getInstance(){
		if(instance==null) instance = new Clipboard();
		return instance;
	}
	
}
