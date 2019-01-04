package main.vue;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.box.Box;
import main.box.BoxPuzzle;
import main.lien.LienPuzzle;

public class CasePuzzle extends JPanel {

	private ImagePan[][] cases;

	public CasePuzzle() {
		cases = new ImagePan[3][3];
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cases[i][j] = new ImagePan();
				add(cases[i][j]);
			}
		}
	}

	public CasePuzzle(BoxPuzzle box, BufferedImage[] images) {
		this();

		setImages(box, images);
	}

	public void removeImages() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				cases[i][j].removeImage();
	}

	public void setImages(BoxPuzzle box, BufferedImage[] images) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cases[i][j].removeImage();
				if (i == 0 && j == 1) {
					Box box2 = box.getBox2()[0];
					if (box2 != null && box2.getLien() instanceof LienPuzzle)
						cases[i][j].setImage(images[((LienPuzzle) box2.getLien()).getType()]);
				} else if (i == 1 && j == 0) {
					Box box2 = box.getBox2()[3];
					if (box2 != null && box2.getLien() instanceof LienPuzzle)
						cases[i][j].setImage(images[((LienPuzzle) box2.getLien()).getType()]);
				} else if (i == 1 && j == 2) {
					Box box2 = box.getBox2()[1];
					if (box2 != null && box2.getLien() instanceof LienPuzzle)
						cases[i][j].setImage(images[((LienPuzzle) box2.getLien()).getType()]);
				} else if (i == 2 && j == 1) {
					Box box2 = box.getBox2()[2];
					if (box2 != null && box2.getLien() instanceof LienPuzzle)
						cases[i][j].setImage(images[((LienPuzzle) box2.getLien()).getType()]);
				} else
					cases[i][j].removeImage();
			}
		}
	}
}
