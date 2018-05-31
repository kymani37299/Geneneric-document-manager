package view.customComponents;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class BioPanel extends JPanel{

	private ImagePanel imagePanel;
	private LabelArea lblAreaBio;
	
	public BioPanel(String bio, Image image)
	{
		this.imagePanel = new ImagePanel(image);
		
		this.lblAreaBio = new LabelArea(bio);

		this.add(this.imagePanel, BorderLayout.WEST);
	    this.add(this.lblAreaBio, BorderLayout.CENTER);
	}
}
