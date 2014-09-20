package Gallhp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Spring;

public class JImageComponent extends JComponent{
	
	private BufferedImage image;
	
	public JImageComponent(String imagePath) {
		URL resource = getClass().getResource(imagePath);
		try {
			image = ImageIO.read(resource);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}
