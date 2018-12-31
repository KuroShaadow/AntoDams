package main.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Joueur;
import main.box.Box;
import main.planche.Planche;

@SuppressWarnings("serial")
abstract class Vue<T> extends JFrame {
	protected Planche<T> planche;
	protected JPanel table;
	protected JPanel[][] plateau;
	protected JPanel maPioche;
	protected ArrayList<JPanel[]> maMain;

	public Vue(Planche<T> planche, String titre) {
		this.pack();
		this.setTitle(titre);
		this.setSize(new Dimension(1920, 1080));
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// chaque joueur a sa propre vue
		this.planche = planche;

		// on créé la table et le plateau
		initTable();

		// on initialise la pioche du joueur sous fomre graphique
		this.maPioche = new JPanel();
		updateVue();

		// separation de la table et de la pioche
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.weightx = 1;
		c.weighty = 100;
		this.add(table, c);
		c.gridx = 2;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		this.add(maPioche, c);
	}

	public void initTable() {
		this.table = new JPanel();
		this.table.setLayout(
				new GridLayout(this.planche.getTableau().length + 2, this.planche.getTableau()[0].length + 2));
		initPlateau();
	}

	public void initPlateau() {
		this.plateau = new JPanel[this.planche.getTableau().length][this.planche.getTableau()[0].length];
		for (int i = -1; i < this.plateau.length + 1; i++) {
			for (int j = -1; j < this.plateau[0].length + 1; j++) {
				JPanel box = new JPanel();
				if (i == -1 || i == this.plateau.length || j == -1
						|| j == this.plateau[0].length) {
					box.setBackground(Color.DARK_GRAY);
				} else {
					this.plateau[i][j] = box;
				}
				this.table.add(box);
			}
		}
	}

	abstract void updateVue();
}
