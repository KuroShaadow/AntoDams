package main.planche;

import java.util.ArrayList;

import main.Demande;
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

	@Override
	public void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//

		affiche();
		Joueur<BoxDomino> joueur = joueurs.get(nb);
		while (true) {
			Demande d = new Demande();
			BoxDomino box =  joueur.getBox(d.getNb());
			if (box.estPosable(tableau, d.getX(), d.getY(), d.getSens())) {
				joueur.joue(d.getNb()).pose(tableau, d.getX(), d.getY(), d.getSens());
				break;
			}
		}
	}
	
	public void premierTour() {
		ArrayList<BoxDomino> maxDominoParJoueur = new ArrayList<>();
		ArrayList<Integer> maxIndexParJoueur = new ArrayList<>();
		
		int index;
		for (Joueur<BoxDomino> joueur : joueurs) {
			maxIndexParJoueur.add(BoxDomino.max(joueur.getMain()));
			maxDominoParJoueur.add(joueur.getBox(BoxDomino.max(joueur.getMain())));
		}
		joueurCourant = BoxDomino.max(maxDominoParJoueur);
		
		joueurs.get(joueurCourant).joue(maxIndexParJoueur.get(joueurCourant)).pose(tableau, 15, 15, 1);
	}

	@Override
	public void partie() {
		// inscription des joueurs
		// pioche a tour de role 7 dominos
		// le plus gros double le joue (obligatoire)
		// chaque joueur joue a tour de role
		
		addJoueur(new Joueur<BoxDomino>("1"));
		addJoueur(new Joueur<BoxDomino>("2"));

		for (int i=0; i<7; i++)
			for (Joueur<BoxDomino> joueur : joueurs)
				joueur.pioche(pioche());

		premierTour();
		for (int i=0; true; i++) {
			tour(i%joueurs.size());
		}

	}
	
	public void affiche() {
		for (int i=0;i<tableau.length; i++) {
			for (int j=0;j<tableau.length; j++)
				System.out.print(tableau[j][i]==null?".":tableau[j][i].getLien());

			System.out.println();
		}
	}
}
