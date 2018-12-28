package main.planche;

import java.util.ArrayList;

import main.Joueur;
import main.box.Box;

public abstract class Planche {
	protected Box[][] tableau;
	protected ArrayList<Joueur> joueurs;
	protected ArrayList<Box> pioche;
	protected int joueurCourant;

	public Planche(int hauteur, int largeur) {
		this.tableau = new Box[hauteur][largeur];
		this.joueurs = new ArrayList<Joueur>();
		this.pioche = new ArrayList<Box>();
	}

	public void addJoueur(Joueur joueur) {
		joueurs.add(joueur);
	}

	public Box pioche() {
		int nb = (int) (Math.random() * pioche.size());
		pioche.remove(nb);
		return pioche.get(nb);
	}

	abstract public void tour();

	abstract public void partie();

	public Box[][] getTableau() {
		return tableau;
	}
	
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}
	
	public int getCourant() {
		return this.joueurCourant;
	}
	
	public void setCourant(int i) {
		this.joueurCourant = i;
	}
}
