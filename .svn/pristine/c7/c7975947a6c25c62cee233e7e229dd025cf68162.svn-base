package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import fileManagement.FileManager;
import jevTree.model.IJevTreeNode;

public class JevWorkspace implements IJevTreeNode,Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private ArrayList<JevProject> projects;
	
	public JevWorkspace(){
		super();
		this.projects = new ArrayList<>();
		this.name = "Workspace";
	}
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		out.writeObject(this.name);
		int count = 1;
		ArrayList<File> paths = new ArrayList<>();
		for(JevProject p : this.projects){
			if(p.getPath()==null){
				File f = new File(FileManager.getInstance().getSaveFilePath().getParent() + "/Project"+count++ + ".bin");
				p.setPath(f);
			}
			paths.add(p.getPath());
			FileOutputStream fos = new FileOutputStream(p.getPath());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.close();
		}
		out.writeObject(paths);
	}
	
	private void readObject(java.io.ObjectInputStream in) throws ClassNotFoundException, IOException{
		HashMap<UUID, JevDocument> documentMap = new HashMap<>();
		this.name = (String) in.readObject();
		ArrayList<File> paths = (ArrayList<File>) in.readObject();
		this.projects = new ArrayList<>();
		for(File f : paths){
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				JevProject newProject = (JevProject) ois.readObject();
				for(IJevTreeNode childNode : newProject.getChildren()) {
					JevDocument document = (JevDocument)childNode;
					UUID documentID = document.getId();
					if(!documentMap.containsKey(document.getId())) 
						documentMap.put(documentID, document);
					else {
						newProject.removeChild(childNode);
						newProject.addChild(documentMap.get(documentID));
					}
				}
				this.projects.add(newProject);
				ois.close();
			}
		}
	}
	
	@Override
	public IJevTreeNode clone() {
		throw new UnsupportedOperationException("Workspace is not allowed to be cloned.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
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
		return !projects.isEmpty();
	}

	@Override
	public List<IJevTreeNode> getChildren() {
		ArrayList<IJevTreeNode> children = new ArrayList<IJevTreeNode>(this.projects.size());
		for(JevProject proj : this.projects){
			children.add(proj);
		}
		return children;
	}

	@Override
	public void addChild(IJevTreeNode child) {
		if(child instanceof JevProject){
			this.projects.add((JevProject) child);
		}	else{
			throw new IllegalArgumentException();
		}
		
	}
	
	@Override
	public void removeChild(IJevTreeNode child) {
		if(child instanceof JevProject){
			this.projects.remove((JevProject) child);
		}	else{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public String toString() {
		return name;
	}

	public ArrayList<JevProject> getProjects() {
		return projects;
	}

	@Override
	public Class getChildrenClass() {
		return JevProject.class;
	}
}
