package main.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Joueur;
import main.box.Box;
import main.box.BoxDomino;
import main.controleur.ControleurDomino;
import main.lien.LienDomino;
import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class VueDomino extends Vue<BoxDomino> {

	private BufferedImage[] images;

	public VueDomino(PlancheDomino planche) {
		super(planche, "Table domino");

		this.images = new BufferedImage[7];
		try {
		for (int i = 0; i < this.images.length; i++)
				this.images[i] = ImageIO.read(new File("Images/Dice" + i + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.controleur = new ControleurDomino(this);
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
		Joueur<BoxDomino> joueur = this.planche.getJoueur(this.planche.getCourant());
		maPioche.removeAll();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.weightx = 2;
		c.weighty = 1;
		maPioche.add(new JLabel("Pioche de " + joueur.toString()), c);
		for (int i = 0; i < joueur.getMain().size(); i++) {
			LienDomino l1 = (LienDomino) ((BoxDomino) joueur.getMain().get(i)).getLien();
			LienDomino l2 = (LienDomino) (((BoxDomino) joueur.getMain().get(i)).getBox2()).getLien();
			this.maMain.add(new JPanel[] { new ImagePan(images[l1.getNombre()]),
					new ImagePan(images[l2.getNombre()]) });
			for (int j = 0; j < 2; j++) {
				c.gridx = j;
				c.gridy = i;
				this.maPioche.add(this.maMain.get(i)[j], c);
			}
		}
	}
}
