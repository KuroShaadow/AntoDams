import java.util.ArrayList;

public class Joueur {
	private final String nom;
	private ArrayList<Case> main;

	public Joueur(String nom) {
		this.nom = nom;
		this.main = new ArrayList<>();
	}

	public void pioche(Case domino) {
		main.add(domino);
	}
}