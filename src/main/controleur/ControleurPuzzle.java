package main.controleur;

import main.Joueur;
import main.box.BoxPuzzle;
import main.demande.Demande;
import main.vue.Vue;

public class ControleurPuzzle extends Controleur<BoxPuzzle> {

	public ControleurPuzzle(Vue<BoxPuzzle> vue) {
		super(vue);
	}

	protected void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//

		Joueur<BoxPuzzle> joueur = modele.getJoueur(nb);
		while (true) {
			this.demande = new Demande();
			attente();
			BoxPuzzle box = joueur.getBox(demande.getNb());
			if (box.estPosable(modele.getTableau(), demande.getX(), demande.getY(),
					demande.getSens())) {
				joueur.joue(demande.getNb()).pose(modele.getTableau(), demande.getX(), demande.getY(),
						demande.getSens());
				break;
			}
		}
		vue.updateVue();
	}

	public void partie() {
		// pioche tout les puzzles

		while (!modele.getPioche().isEmpty())
			modele.getJoueurs().get(0).pioche(modele.pioche());

		// chaque joueur joue a tour de role
		while (true) {
			tour(0);
		}

	}
}
