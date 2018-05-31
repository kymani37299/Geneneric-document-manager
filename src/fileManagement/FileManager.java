package fileManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import jevTree.model.IJevTreeNode;
import jevTree.model.JevTreeNode;
import model.JevProject;

public class FileManager {

	private static FileManager instance;
	
	private File saveFilePath;
	private File openFilePath;
	
	private FileManager(){
		this.saveFilePath = null;
		this.openFilePath = null;
	}
	
	public static FileManager getInstance(){
		if(instance==null){
			instance = new FileManager();
		}
		return instance;
	}
	
	public File getSaveFilePath(){
		return this.saveFilePath;
	}
	
	public File browse(UrlType type) {
		JFileChooser chooser = new JFileChooser();
		
		if(this.openFilePath != null && this.openFilePath.exists()) {
			chooser.setCurrentDirectory(this.openFilePath.getParentFile());
			chooser.setSelectedFile(this.openFilePath);
		}
		
		chooser.setDialogTitle("Browse");
		chooser.setApproveButtonText("Select");
		switch(type) {
			case Both:
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				break;
			case Directory:
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				break;
			case File:
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				break;
			default:
				throw new IllegalArgumentException(type.toString());
		}
		if (chooser.showOpenDialog(new JButton("Select")) == JFileChooser.APPROVE_OPTION) {
			File path = chooser.getSelectedFile();
			this.openFilePath = path;
			return path;
		}
		return null;
	}
	
	public JevTreeNode open() throws IOException, ClassNotFoundException{
		JFileChooser chooser = new JFileChooser();
		
		if(this.openFilePath != null && this.openFilePath.exists()) {
			chooser.setCurrentDirectory(this.openFilePath.getParentFile());
			chooser.setSelectedFile(this.openFilePath);
		}
		
		chooser.setFileFilter(new ExtensionFileFilter("Binary file", "bin"));
		chooser.setDialogTitle("Open");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		JevTreeNode node = null;
		if (chooser.showOpenDialog(new JButton()) == JFileChooser.APPROVE_OPTION){
			FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
			ObjectInputStream in = new ObjectInputStream(fis);
			node = new JevTreeNode((IJevTreeNode) in.readObject());
			this.openFilePath = chooser.getSelectedFile();
			in.close();
		}
		return node;
	}
	
	public void save(File path,JevTreeNode node) throws IOException{
		if(node==null) return;
		
		while(!node.getValue().isSerializable()){
			node = (JevTreeNode) node.getParent();
		}
		
		if(node.getValue() instanceof JevProject){
			((JevProject)node.getValue()).setPath(path);
		}
		
		if(!path.exists()){
			path.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(node.getValue());
		out.close();
	}
	
	public void saveAs(JevTreeNode node) throws IOException{
		JButton save = new JButton("Save");
		JFileChooser chooser = new JFileChooser();
		
		if(this.saveFilePath != null && this.saveFilePath.exists()) {
			chooser.setCurrentDirectory(this.saveFilePath.getParentFile());
			chooser.setSelectedFile(this.saveFilePath);
		}
		
		chooser.setFileFilter(new ExtensionFileFilter("Binary file", "bin"));
		chooser.setDialogTitle("Save");
		chooser.setApproveButtonText("Save");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (chooser.showOpenDialog(save) == JFileChooser.APPROVE_OPTION) {	
			File path = chooser.getSelectedFile();
			if(!path.getAbsolutePath().toLowerCase().endsWith(".bin")){
				String newPath = path.getAbsolutePath().concat(".bin");
				path = new File(newPath);
			}
			this.saveFilePath = path;
			save(path, node);
		}
	}
	
	
	static class ExtensionFileFilter extends FileFilter {
		  
		String description;
		String extensions[];
	
		public ExtensionFileFilter(String description, String extension) {
			this(description, new String[] { extension });
		}
	
		public ExtensionFileFilter(String description, String extensions[]) {
			if (description == null) 
				this.description = extensions[0];
			else 
				this.description = description;
	    
			this.extensions = (String[]) extensions.clone();
			toLower(this.extensions);
		}
	
		private void toLower(String array[]) {
			for (int i = 0, n = array.length; i < n; i++) 
				array[i] = array[i].toLowerCase();
		}
	
		public String getDescription() {
			return description;
		}
	
		public boolean accept(File file) {
			if (file.isDirectory()) 
				return true;
			else {
				String path = file.getAbsolutePath().toLowerCase();
				for (int i = 0, n = extensions.length; i < n; i++) {
					String extension = extensions[i];
					if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) 
						return true;
				}
			}
			return false;
		}
	}
	
}
