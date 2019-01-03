package main.planche;

import main.Joueur;
import main.box.BoxDomino;
import main.lien.LienDomino;

public class PlancheDomino extends Planche<BoxDomino> {

	public PlancheDomino() {
		super(30, 30);

		for (int i = 0; i <= 6; i++)
			for (int j = 0; j <= i; j++)
				this.pioche.add(new BoxDomino(new LienDomino(i), new LienDomino(j)));
	}

	@Override
	public void addJoueur(Joueur<BoxDomino> joueur) {
		if (this.joueurs.size() <= 2)
			super.addJoueur(joueur);
	}
}
