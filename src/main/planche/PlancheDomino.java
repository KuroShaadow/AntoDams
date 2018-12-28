package main.planche;

import main.Joueur;
import main.box.BoxDomino;
import main.lien.LienDomino;

public class PlancheDomino extends Planche {

	public PlancheDomino() {
		super(30, 30);

		for (int i = 0; i <= 6; i++)
			for (int j = 0; j <= i; j++)
				this.pioche.add(new BoxDomino(new LienDomino(i), new LienDomino(j)));
	}

	@Override
	public void addJoueur(Joueur joueur) {
		if (this.joueurs.size() <= 2)
			super.addJoueur(joueur);
	}

	@Override
	public void tour() {
		// si il ne peut pas jouer il pioche et passe
		//
	}

	@Override
	public void partie() {
		// inscription des joueurs
		// pioche a tour de role 7 dominos
		// le plus gros double le joue (obligatoire)
		// chaque joueur joue a tour de role
		/*
		 * addJoueur(new Joueur("1")); addJoueur(new Joueur("2"));
		 * 
		 * joueurs.get(0).pioche(pioche()); joueurs.get(0).pioche(pioche());
		 * joueurs.get(0).pioche(pioche());
		 */

	}
}
