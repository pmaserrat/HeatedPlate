package Gallhp;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class JImageComponent extends JComponent{
	
	private Image image;
	
	public JImageComponent(String imagePath) {
		URL resource = getClass().getResource(imagePath);
		try {
			image = ImageIO.read(resource);
			//image = new ImageIcon(this.getClass().getResource(imagePath)).getImage();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 3, 4, this);
	}
}
