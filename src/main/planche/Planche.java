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

	public T pioche() {
		int nb = (int) (Math.random() * pioche.size());
		T box = pioche.get(nb);
		pioche.remove(nb);
		return box;
	}

	abstract public void tour(int nb);

	abstract public void partie();

	public Box[][] getTableau() {
		return tableau;
	}
}
