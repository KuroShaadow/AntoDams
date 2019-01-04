package main.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import main.Joueur;
import main.box.BoxPuzzle;
import main.controleur.ControleurPuzzle;
import main.lien.LienDomino;
import main.lien.LienPuzzle;
import main.planche.PlanchePuzzle;

@SuppressWarnings("serial")
public class VuePuzzle extends Vue<BoxPuzzle> {

	private BufferedImage[] images;

	public VuePuzzle(PlanchePuzzle planche) {
		super(planche, "Table puzzle");

		this.images = new BufferedImage[2];
		try {
			for (int i = 0; i < this.images.length; i++)
				this.images[i] = ImageIO.read(new File("Images/Puzzle" + i + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.planche.addJoueur(new Joueur<BoxPuzzle>("joueur"));
		this.controleur = new ControleurPuzzle(this);
		ajouteControleur(controleur);
	}

	@Override
	public void updateVue() {
		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				BoxPuzzle box = (BoxPuzzle) this.planche.getTableau()[i][j];
				if (box != null)
					((CasePuzzle) this.plateau[i][j]).setImages(box, images);
				else
					((CasePuzzle) this.plateau[i][j]).removeImages();
			}
			System.out.println();
		}
		Joueur<BoxPuzzle> joueur = this.planche.getJoueur(0);
		maPioche.removeAll();
		maPioche.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		maPioche.add(new JLabel("Pioche"), c);
		for (int i = 0; i < joueur.getMain().size(); i++) {
			
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
