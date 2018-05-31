package view.customComponents;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    this.setPreferredSize(new Dimension(this.img.getWidth(null), this.img.getHeight(null)));
	  }
	  
	  @Override
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);
	      g.drawImage(img, (int)(this.getSize().getWidth() - this.img.getWidth(null)) / 2,
	          (int)(this.getSize().getHeight() - this.img.getHeight(null)) / 2, null);
	  }
}
