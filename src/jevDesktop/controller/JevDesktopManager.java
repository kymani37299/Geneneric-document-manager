package jevDesktop.controller;

import java.awt.Dimension;

import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class JevDesktopManager extends DefaultDesktopManager {

 public void dragFrame(JComponent f, int x, int y) {
   if (f instanceof JInternalFrame) {
     JInternalFrame frame = (JInternalFrame) f;
     JDesktopPane desk = frame.getDesktopPane();
     Dimension d = desk.getSize();

     if (x < 0) {
       x = 0;
     } else {
       if (x + frame.getWidth() > d.width) {
         x = d.width - frame.getWidth();
       }
     }
     if (y < 0) {
       y = 0;
     } else {
       if (y + frame.getHeight() > d.height) {
         y = d.height - frame.getHeight();
                         
       }
     }
   }

   super.dragFrame(f, x, y);
 }
}
