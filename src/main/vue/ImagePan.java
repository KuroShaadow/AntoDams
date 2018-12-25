package main.vue;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class ImagePan extends JPanel {
	private BufferedImage image;

	public ImagePan(String s) {
		File f = new File(s);
		BufferedImage image = null;
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.image = image;
		paintComponent(image.getGraphics());
	}
	
	public void setImage(String s) {
		File f = new File(s);
		BufferedImage image = null;
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.image = image;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.image, 0, 0, this);
	}
}
