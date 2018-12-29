package main.vue;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Joueur;
import main.box.BoxDomino;
import main.lien.LienDomino;
import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class VueDomino extends Vue {
	public VueDomino(PlancheDomino planche) {
		super(planche, "Table domino");
	}

	public void addDomino(int x, int y, BoxDomino box) {
		LienDomino nombreCase = (LienDomino) box.getLien();
		this.plateau[x][y] = new ImagePan("Images/Dice" + nombreCase.getNombre() + ".png");
	}

	public void partie() {
		this.planche.partie();
		for (int i = 0; i < this.planche.getTableau().length; i++) {
			for (int j = 0; j < this.planche.getTableau()[0].length; j++) {
				if (this.planche.getTableau()[i][j] != null)
					this.addDomino(i, j, (BoxDomino) this.planche.getTableau()[i][j]);
			}
		}
	}
	
	@Override
	public void updateVue() {
		for(int i = 0; i < this.plateau.length; i++) {
			for(int j = 0; j < this.plateau[0].length; j++) {
				if(this.planche.getTableau()[i][j] != null)
					this.plateau[i][j] = new ImagePan("Images/Dice" + (LienDomino) ((BoxDomino) this.planche.getTableau()[i][j]).getLien() + ".png");
			}
		}
		Joueur joueur = this.planche.getJoueurs().get(this.planche.getCourant());
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
			this.maMain.add(new JPanel[] { new ImagePan("Images/Dice" + l1.getNombre() + ".png"),
					new ImagePan("Images/Dice" + l2.getNombre() + ".png") });
			for (int j = 0; j < 2; j++) {
				c.gridx = j;
				c.gridy = i;
				this.maPioche.add(this.maMain.get(i)[j], c);
			}
		}
	}
}
