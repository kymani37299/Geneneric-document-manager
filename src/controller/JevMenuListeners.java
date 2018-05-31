package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AboutFrame;

public class JevMenuListeners {
	
	public static ActionListener miAbout_actionPerformed () {
	    return new ActionListener() {
	        @Override 
	        public void actionPerformed (ActionEvent e) {
	        	AboutFrame aboutFrame = new AboutFrame(null);
	        	aboutFrame.setVisible(true);
	        }
	    };
	}
}