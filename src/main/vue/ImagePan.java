package main.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class ImagePan extends JPanel {

	BufferedImage image;

	public ImagePan() {
		image = null;
	}

	public ImagePan(String s) {
		try {
			image = ImageIO.read(new File(s));
		} catch (IOException e) {
			image = null;
		}
	}

	public ImagePan(BufferedImage image) {
		this.image = image;
	}

	public void setImage(String s) {
		try {
			image = ImageIO.read(new File(s));
		} catch (IOException e) {
			image = null;
		}
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void removeImage() {
		image = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image == null)
			return;
		Image img = image.getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH);
		g.drawImage(img, 0, 0, null);
	}
}
