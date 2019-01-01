package main.vue;

import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Joueur;
import main.box.Box;
import main.box.BoxDomino;
import main.controleur.ControleurDomino;
import main.lien.LienDomino;
import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class VueDomino extends Vue<BoxDomino> {

	private Icon[] images;

	public VueDomino(PlancheDomino planche) {
		super(planche, "Table domino");

		this.images = new ImageIcon[7];
		for (int i = 0; i < this.images.length; i++)
			this.images[i] = new ImageLab("Images/Dice" + i + ".png", 30, 30);

		this.controleur = new ControleurDomino(this);
		ajouteControleur(controleur);
	}

	@Override
	public void updateVue() {
		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				Box box = this.planche.getTableau()[i][j];
				if (box != null) {
					this.plateau[i][j].setIcon(images[((LienDomino) box.getLien()).getNombre()]);
					System.out.print(box.getLien());
				} else {
					this.plateau[i][j].setIcon(null);
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
			this.maMain.add(new JLabel[] { new JLabel(new ImageLab("Images/Dice" + l1.getNombre() + ".png", 50)),
					new JLabel(new ImageLab("Images/Dice" + l2.getNombre() + ".png", 50)) });
			for (int j = 0; j < 2; j++) {
				c.gridx = j;
				c.gridy = i;
				this.maPioche.add(this.maMain.get(i)[j], c);
			}
		}
	}
}
