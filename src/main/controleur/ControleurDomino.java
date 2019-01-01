package main.controleur;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.Joueur;
import main.box.BoxDomino;
import main.demande.DemandeDomino;
import main.vue.Vue;

public class ControleurDomino extends Controleur<BoxDomino> {

	public ControleurDomino(Vue<BoxDomino> vue) {
		super(vue);
	}

	protected void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//

		Joueur<BoxDomino> joueur = modele.getJoueur(nb);
		while (true) {
			this.demande = new DemandeDomino();
			attente();
			BoxDomino box = joueur.getBox(demande.getNb());
			if (box.estPosable(modele.getTableau(), demande.getX(), demande.getY(),
					((DemandeDomino) demande).getSens())) {
				joueur.joue(demande.getNb()).pose(modele.getTableau(), demande.getX(), demande.getY(),
						((DemandeDomino) demande).getSens());
				break;
			}
		}
		vue.updateVue();
	}

	private void premierTour() {
		ArrayList<BoxDomino> maxDominoParJoueur = new ArrayList<>();
		ArrayList<Integer> maxIndexParJoueur = new ArrayList<>();

		for (Joueur<BoxDomino> joueur : modele.getJoueurs()) {
			maxIndexParJoueur.add(BoxDomino.max(joueur.getMain()));
			maxDominoParJoueur.add(joueur.getBox(BoxDomino.max(joueur.getMain())));
		}
		modele.setJoueurCourant(BoxDomino.max(maxDominoParJoueur));

		modele.getJoueur(modele.getJoueurCourant()).joue(maxIndexParJoueur.get(modele.getJoueurCourant()))
				.pose(modele.getTableau(), 15, 15, 1);

		vue.updateVue();
	}

	public void partie() {
		// pioche a tour de role 7 dominos

		for (int i = 0; i < 7; i++)
			for (Joueur<BoxDomino> joueur : modele.getJoueurs())
				joueur.pioche(modele.pioche());

		// le plus gros double le joue (obligatoire)
		premierTour();

		// chaque joueur joue a tour de role
		while (true) {
			modele.setJoueurCourant((modele.getJoueurCourant() + 1) % modele.getJoueurs().size());
			tour(modele.getJoueurCourant());
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		demande.setNb(1);
		demande.setX(1);
		demande.setY(1);
		((DemandeDomino) demande).setSens(1);

		// cas du changement de domino

		// cas de la selection de la case

		// cas de la selection du sens

	}

}
