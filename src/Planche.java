import java.util.ArrayList;

public abstract class Planche {
	protected Case[][] tableau;
	protected ArrayList<Joueur> joueurs;
	protected ArrayList<Case> pioche;

	public Planche(int hauteur, int largeur) {
		this.tableau = new Case[hauteur][largeur];
		this.joueurs = new ArrayList<Joueur>();
		this.pioche = new ArrayList<Case>();
	}

	public void addJoueur(Joueur joueur) {
		joueurs.add(joueur);
	}

	public Case pioche() {
		int nb = (int) (Math.random() * pioche.size());
		pioche.remove(nb);
		return pioche.get(nb);
	}

	abstract public void tour();

	abstract public void partie();

	public Case[][] getTableau() {
		return tableau;
	}
}
