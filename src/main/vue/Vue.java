package main.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
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
	protected ArrayList<JPanel> maMain;
	protected JButton piocher;

	public Vue(Planche<T> planche, String titre) {
		this.planche = planche;

		this.setTitle(titre);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// on créé la table et le plateau
		initTable();

		this.piocher = new JButton("Piocher");
		piocher.addMouseListener(controleur);

		// on initialise la pioche du joueur sous fomre graphique
		this.maPioche = new JPanel();

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
		this.controleur = controleur;

		for (int i = 0; i < this.plateau.length; i++) {
			for (int j = 0; j < this.plateau[0].length; j++) {
				plateau[i][j].addMouseListener(controleur);
			}
		}
		piocher.addMouseListener(controleur);

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

	public int[] getCoordonnees(Component component) {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if (plateau[i][j] == component)
					return new int[] { i, j };
			}
		}
		return null;
	}

	public boolean contains(Component component) {
		for (int i = 0; i < plateau.length; i++)
			for (int j = 0; j < plateau[0].length; j++)
				if (plateau[i][j] == component)
					return true;
		return false;
	}

	public Planche<T> getPlanche() {
		return planche;
	}

	public Controleur<T> getControleur() {
		return controleur;
	}

	public ArrayList<JPanel> getMain() {
		return this.maMain;
	}

	public ImagePan[][] getPlateau() {
		return this.plateau;
	}

	public JButton getPiocher() {
		return this.piocher;
	}
}
