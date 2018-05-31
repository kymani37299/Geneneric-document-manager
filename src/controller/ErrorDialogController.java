package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.JevErrorDialog;

public class ErrorDialogController {
	public static ActionListener btnOK_actionPerformed (JevErrorDialog dialog) {
	    return new ActionListener() {
	        @Override public void actionPerformed (ActionEvent e) {
	        	dialog.setVisible(false);
	        }
	    };
	}
}
