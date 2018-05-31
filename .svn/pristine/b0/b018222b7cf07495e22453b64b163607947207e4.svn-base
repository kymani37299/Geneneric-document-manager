package jevDesktop.view;

import java.awt.Color;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import jevDesktop.actions.JevDesktopActionManager;
import jevDesktop.controller.JevDesktopController;

@SuppressWarnings("serial")
public class JevDesktop extends JDesktopPane{
	private JevDesktopController controller;
	private int openFrameCount;
	private JevDesktopActionManager actionManager;
	
	public JevDesktop(){
		this.setBackground(Color.DARK_GRAY);
	}
	
	public void addController(JevDesktopController controller){
		this.controller = controller;
	}
	
	public void addActionManager(JevDesktopActionManager actionManager){
		this.actionManager = actionManager;
	}
	
	public JevDesktopController getController(){
		return this.controller;
	}
	
	public JevDesktopActionManager getActionManager(){
		return this.actionManager;
	}
	
	public boolean containsFrame(JevInternalFrame frame){
		JInternalFrame frames[] = this.getAllFrames();
		for(int i=0;i<frames.length;i++){
			if(frame==frames[i]) return true;
		}
		return false;
	}
	
	public void update(){
		this.updateUI();
	}
	
	public void addFrame(JevInternalFrame frame){
		this.openFrameCount++;
		this.add(frame);
		this.selectFrame(frame);
		frame.setVisible(true);
	}
	
	public int getOpenFrameCount(){
		return this.openFrameCount;
	}
	
	public void selectFrame(JevInternalFrame frame){
		if(frame==null) return;
		JevInternalFrame selFrame = (JevInternalFrame) this.getSelectedFrame();
		try {
			if(selFrame!=null)
				selFrame.setSelected(false);
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
}
