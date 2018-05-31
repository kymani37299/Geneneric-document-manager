package resources;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import JevLanguageManager.JevLanguageManager;

public final class Bios {
	
	private static Bios instance;
	
	private Image teamImagePath;
	private Image lukaImagePath;
	private Image markoImagePath;
	private Image nikolaImagePath ;
	private Image jovanImagePath;
	
	private Bios() {
		try {
			teamImagePath = ImageIO.read(getClass().getResource("images/teamImage.jpg"));
		    lukaImagePath = ImageIO.read(getClass().getResource("images/lukaImage.jpg"));
			markoImagePath = ImageIO.read(getClass().getResource("images/markoImage.jpg"));
			nikolaImagePath = ImageIO.read(getClass().getResource("images/nikolaImage.jpg"));
			jovanImagePath = ImageIO.read(getClass().getResource("images/jovanImage.jpg"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Image getTeamImagePath() {
		return teamImagePath;
	}

	public Image getLukaImagePath() {
		return lukaImagePath;
	}

	public Image getMarkoImagePath() {
		return markoImagePath;
	}

	public Image getNikolaImagePath() {
		return nikolaImagePath;
	}

	public Image getJovanImagePath() {
		return jovanImagePath;
	}
	
	public static Bios getInstance() {
		if(instance == null)
			instance = new Bios();
		return instance;
	}
}
