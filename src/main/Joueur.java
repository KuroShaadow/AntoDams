package main;

import java.util.ArrayList;

public class Joueur<T> {
	private final String nom;
	private ArrayList<T> main;

	public Joueur(String nom) {
		this.nom = nom;
		this.main = new ArrayList<>();
	}

	public void pioche(T domino) {
		main.add(domino);
	}

	public T joue(int nb) {
		T box = main.get(nb);
		main.remove(nb);
		return box;
	}
	
	public ArrayList<T> getMain() {
		return this.main;
	}
	
	public T getBox(int nb) {
		return this.main.get(nb);
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
	
}