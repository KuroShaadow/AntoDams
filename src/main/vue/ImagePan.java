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

	public ImagePan() {
		this.image = null;
	}

	public ImagePan(String s) {
		try {
			this.image = ImageIO.read(new File(s));
			System.out.println(image);
		} catch (IOException e) {
			this.image = null;
		}
	}

	public void setImage(String s) {
		try {
			this.image = ImageIO.read(new File(s));
		} catch (IOException e) {
			this.image = null;
		}
	}

	public void removeImage() {
		this.image = null;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.image, 0, 0, this);
	}
}
