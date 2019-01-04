package main.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.Joueur;
import main.box.Box;
import main.box.BoxPuzzle;
import main.controleur.ControleurPuzzle;
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
		
		ajouteControleur(new ControleurPuzzle(this));
	}

	@Override
	public void updateVue() {
		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				Box box = this.planche.getTableau()[i][j];
				if (box != null && box.getLien() instanceof LienPuzzle)
					((ImagePan) this.plateau[i][j]).setImage(images[((LienPuzzle) box.getLien()).getType()]);
				else
					((ImagePan) this.plateau[i][j]).removeImage();
			}
		}
		Joueur<BoxPuzzle> joueur = this.planche.getJoueur(this.planche.getJoueurCourant());
		maPioche.removeAll();
		initMaMain();
		maPioche.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		maPioche.add(new JLabel("Pioche de " + joueur.toString()), c);
		for (int i = 0; i < joueur.getMain().size(); i++) {
			JPanel ligne = new CasePuzzle(joueur.getMain().get(i), images);
			c.gridx = 0;
			c.gridy = i + 1;
			c.insets = new Insets(10, 0, 0, 0);
			this.maMain.add(ligne);
			this.maPioche.add(ligne, c);
			c.gridx = 0;
			c.gridy = joueur.getMain().size() + 1;
			this.maPioche.add(piocher, c);
		}
		c.gridx = 0;
		c.gridy = joueur.getMain().size() + 1;
		this.maPioche.add(piocher, c);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
