package main.vue;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class ImageLab extends ImageIcon {

	public ImageLab(String s) {
		try {
			setImage(ImageIO.read(new File(s)));
		} catch (IOException e) {
			setImage(null);
		}
	}
	
	public ImageLab(String s, int width, int height) {
		try {
			setImage(ImageIO.read(new File(s)).getScaledInstance(width, height, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			setImage(null);
		}
	}
	
	public ImageLab(String s, int size) {
		try {
			setImage(ImageIO.read(new File(s)).getScaledInstance(size, size, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			setImage(null);
		}
	}
}
