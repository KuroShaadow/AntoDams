package main.vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.controleur.Controleur;
import main.planche.Planche;

@SuppressWarnings("serial")
public abstract class Vue<T> extends JFrame {
	protected Planche<T> planche;
	protected Controleur<T> controleur;
	protected JPanel table;
	protected ImagePan[][] plateau;
	protected JPanel maPioche;
	protected ArrayList<JPanel[]> maMain;

	public Vue(Planche<T> planche, String titre) {
		this.planche = planche;

		this.setTitle(titre);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// on créé la table et le plateau
		initTable();

		// on initialise la pioche du joueur sous fomre graphique
		this.maPioche = new JPanel();
		updateVue();

		// separation de la table et de la pioche
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = this.getSize().height - 375;
		c.ipady = this.getSize().height - 375;
		this.add(table, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridy = 0;
		c.ipadx = 0;
		c.insets = new Insets(0, 10, this.getSize().height - 375, 0);
		this.add(maPioche, c);
	}

	protected void ajouteControleur(Controleur<T> controleur) {
		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				plateau[i][j].addMouseListener(controleur);
			}
		}
	}

	public void initTable() {
		this.table = new JPanel();
		this.table.setLayout(
				new GridLayout(this.planche.getTableau().length + 2, this.planche.getTableau()[0].length + 2));
		initPlateau();
		initMaMain();
	}

	public void initPlateau() {

		this.plateau = new ImagePan[this.planche.getTableau().length][this.planche.getTableau()[0].length];
		for (int i = -1; i < this.plateau.length + 1; i++) {
			for (int j = -1; j < this.plateau[0].length + 1; j++) {
				JPanel box;
				if (i == -1 || i == this.plateau.length || j == -1 || j == this.plateau[0].length) {
					box = new JPanel();
					box.setBackground(Color.DARK_GRAY);
				} else {
					box = new ImagePan();
					this.plateau[i][j] = (ImagePan) box;
				}
				this.table.add(box);
			}
		}
	}

	public void initMaMain() {
		this.maMain = new ArrayList<>();
	}

	public abstract void updateVue();

	public Planche<T> getPlanche() {
		return planche;
	}

	public Controleur<T> getControleur() {
		return controleur;
	}
}
