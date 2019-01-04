package main.planche;

import java.util.ArrayList;

import main.Joueur;
import main.box.Box;

public abstract class Planche<T> {
	protected Box[][] tableau;
	protected ArrayList<Joueur<T>> joueurs;
	protected ArrayList<T> pioche;
	protected int joueurCourant;

	public Planche(int hauteur, int largeur) {
		this.tableau = new Box[hauteur][largeur];
		this.joueurs = new ArrayList<Joueur<T>>();
		this.pioche = new ArrayList<T>();
	}

	public void addJoueur(Joueur<T> joueur) {
		joueurs.add(joueur);
	}

	public boolean estPiochable() {
		return pioche != null && pioche.size() != 0;
	}

	public T pioche() {
		int nb = (int) (Math.random() * pioche.size());
		T box = pioche.get(nb);
		pioche.remove(nb);
		return box;
	}

	public Joueur<T> getJoueur(int nb) {
		return joueurs.get(nb);
	}

	public ArrayList<T> getPioche() {
		return pioche;
	}

	public void setPioche(ArrayList<T> pioche) {
		this.pioche = pioche;
	}

	public int getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(int joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

	public void setTableau(Box[][] tableau) {
		this.tableau = tableau;
	}

	public void setJoueurs(ArrayList<Joueur<T>> joueurs) {
		this.joueurs = joueurs;
	}

	public ArrayList<Joueur<T>> getJoueurs() {
		return joueurs;
	}

	public Box[][] getTableau() {
		return tableau;
	}
}
