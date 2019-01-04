package main.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import main.Joueur;
import main.box.Box;
import main.box.BoxPuzzle;
import main.controleur.ControleurPuzzle;
import main.lien.LienDomino;
import main.planche.PlanchePuzzle;

@SuppressWarnings("serial")
public class VuePuzzle extends Vue<BoxPuzzle> {

	private BufferedImage[] images;

	public VuePuzzle(PlanchePuzzle planche) {
		super(planche, "Table puzzle");

		this.images = new BufferedImage[4];
		try {
		for (int i = 0; i < this.images.length; i++)
				this.images[i] = ImageIO.read(new File("Images/Puzzle" + i + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.controleur = new ControleurPuzzle(this);
		ajouteControleur(controleur);
	}

	@Override
	public void updateVue() {
		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				Box box = this.planche.getTableau()[i][j];
				if (box != null) {
					this.plateau[i][j].setImage(images[((LienDomino) box.getLien()).getNombre()]);
					System.out.print(box.getLien());
				} else {
					this.plateau[i][j].removeImage();
					System.out.print(".");
				}
			}
			System.out.println();
		}
		Joueur<BoxPuzzle> joueur = this.planche.getJoueur(this.planche.getCourant());
		maPioche.removeAll();
		maPioche.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NORTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		maPioche.add(new JLabel("Pioche"), c);
		c.gridwidth = 1;/*
		for (int i = 0; i < joueur.getMain().size(); i++) {
			LienDomino l1 = (LienDomino) ((BoxPuzzle) joueur.getMain().get(i)).getLien();
			LienDomino l2 = (LienDomino) (((BoxPuzzle) joueur.getMain().get(i)).getBox2()).getLien();
			this.maMain.add(new JPanel[] { new ImagePan(images[l1.getNombre()]),
					new ImagePan(images[l2.getNombre()]) });
			for (int j = 0; j < 2; j++) {
				c.gridx = j;
				c.gridy = i + 1;
				this.maPioche.add(this.maMain.get(i)[j], c);
			}
		}*/
	}
}
