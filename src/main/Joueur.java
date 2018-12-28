package main;

import java.util.ArrayList;

import main.box.Box;

public class Joueur {
	private final String nom;
	private ArrayList<Box> main;

	public Joueur(String nom) {
		this.nom = nom;
		this.main = new ArrayList<>();
	}

	public void pioche(Box domino) {
		main.add(domino);
	}
	
	public ArrayList<Box> getMain() {
		return this.main;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}