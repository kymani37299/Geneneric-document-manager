package jevDesktop.controller;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.HashMap;

import javax.swing.JInternalFrame;

import jevDesktop.view.JevDesktop;
import jevDesktop.view.JevInternalFrame;
import jevTree.model.JevTreeNode;
import model.JevDocument;
import model.JevPage;
import model.JevProject;
import model.JevWorkspace;

public class JevDesktopController {

	private JevDesktop desktop;
	private HashMap<JevDocument, JevInternalFrame> frameMap;
	
	public JevDesktopController(JevDesktop desktop){
		this.desktop = desktop;
		this.desktop.setDesktopManager(new JevDesktopManager());
		this.frameMap = new HashMap<>();
	}
	
	private void addFrame(JevTreeNode node){
		JevInternalFrame frame = new JevInternalFrame((JevDocument)node.getValue());
		this.desktop.addFrame(frame);
		this.frameMap.put((JevDocument) node.getValue(), frame);
		
		for(int i=0;i<node.getChildCount();i++){
			JevTreeNode pageNode = (JevTreeNode) node.getChildAt(i);
			frame.addPage((JevPage) pageNode.getValue(),i+1);
		}
		
		this.desktop.update();
	}
	
	private void removeFrame(JevTreeNode node){
		JevInternalFrame frame = this.frameMap.get(node.getValue());
		if(frame!=null){
			try {
				frame.setClosed(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			this.frameMap.remove(node.getValue());
			this.desktop.update();
		}
	}
	
	public void selectFrame(JevTreeNode node){
		if(node!=null && node.getValue() instanceof JevDocument){
			this.desktop.selectFrame(this.frameMap.get(node.getValue()));
		}
	}
	
	public void openFrame(JevTreeNode node){
		if(node.getValue() instanceof JevDocument){
			JevInternalFrame frame = this.frameMap.get(node.getValue());
			if(frame!=null && !this.desktop.containsFrame(frame)){
				this.desktop.addFrame(frame);
				this.desktop.update();
			}
		}
	}
	
	public void clearDesktop(){
		this.desktop.removeAll();
		this.frameMap.clear();
		this.desktop.update();
	}
	
	public void addPerformed(JevTreeNode node){
		if(node.getValue() instanceof JevWorkspace){
			this.clearDesktop();
			for(int i=0;i<node.getChildCount();i++){
				JevTreeNode pj = (JevTreeNode) node.getChildAt(i);
				this.addPerformed(pj);
			}
		}else if(node.getValue() instanceof JevProject){
			for(int i=0;i<node.getChildCount();i++){
				JevTreeNode doc = (JevTreeNode) node.getChildAt(i);
				this.addPerformed(doc);
			}
		}else if(node.getValue() instanceof JevDocument){
			if(!this.desktop.containsFrame(frameMap.get(node.getValue())))
				this.addFrame(node);
		}
	}
	
	public void removePerformed(JevTreeNode node){
		if(node.getValue() instanceof JevProject){
			for(int i=0;i<node.getChildCount();i++){
				JevTreeNode pj = (JevTreeNode) node.getChildAt(i);
				this.removePerformed(pj);
			}
		}
		else if(node.getValue() instanceof JevDocument){
			this.removeFrame(node);
		}
		this.desktop.update();
	}
	
	public void setTileView(){
		JInternalFrame[] allframes =desktop.getAllFrames();
	    int count = allframes.length;
	    if (count == 0)
	      return;

	    int sqrt = (int) Math.sqrt(count);
	    int rows = sqrt;
	    int cols = sqrt;
	    if (rows * cols < count) {
	      cols++;
	      if (rows * cols < count) {
	        rows++;
	      }
	    }

	    Dimension size = desktop.getSize();

	    int w = size.width / cols;
	    int h = size.height / rows;
	    int x = 0;
	    int y = 0;
	    
	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols && ((i * cols) + j < count); j++) {
	    	  JInternalFrame f = allframes[(i * cols) + j];

	        if (!f.isClosed() && f.isIcon()) {
	          try {
	            f.setIcon(false);
	          } catch (PropertyVetoException ignored) {
	          }
	        }

	        desktop.getDesktopManager().resizeFrame(f, x, y, w, h);
	        x += w;
	      }
	      y += h;
	      x = 0;
	    }
	    this.desktop.update();
	}
	
	public void setCascadeView(){
		JInternalFrame ifs[] = this.desktop.getAllFrames();
		for (int i = ifs.length-1; i >=0 ; i--) {
		 ifs[i].setBounds(
		    i*20
		    ,i*20
		    ,JevInternalFrame.frameWidth
		    ,JevInternalFrame.frameHeight
		  );
		}
	}
	
	public void setVerticalTileView(){
		JInternalFrame frames[] = this.desktop.getAllFrames();
		Dimension desktopSize = this.desktop.getSize();
		int frameWidth = (int) (this.desktop.getSize().getWidth() / frames.length);
		for(int i=0;i<frames.length;i++){
			frames[i].setBounds(i*frameWidth,0,frameWidth,(int) desktopSize.getHeight());
		}
	}
	
	public void setHorizontalTileView(){
		JInternalFrame frames[] = this.desktop.getAllFrames();
		Dimension desktopSize = this.desktop.getSize();
		int frameHeight = (int) (this.desktop.getSize().getHeight() / frames.length);
		for(int i=0;i<frames.length;i++){
			frames[i].setBounds(0,i*frameHeight,(int) desktopSize.getWidth(),frameHeight);
		}
	}
	
}
