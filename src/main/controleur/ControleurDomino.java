package main.controleur;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;

import main.Joueur;
import main.box.BoxDomino;
import main.planche.Planche;
import main.planche.PlancheDomino;
import main.vue.Vue;
import main.vue.VueDomino;

public class ControleurDomino extends Controleur<BoxDomino> {

	private Integer sens;
	
	public ControleurDomino(Vue<BoxDomino> vue) {
		super(vue);
	}
	
	@Override
	protected void attente() {
		sens = null;
		while (sens==null)
			super.attente();
	}

	protected void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//

		Joueur<BoxDomino> joueur = modele.getJoueur(nb);
		while (true) {
			attente();
			
			BoxDomino box =  joueur.getBox(numero);
			if (box.estPosable(modele.getTableau(), x, y, sens)) {
				joueur.joue(numero).pose(modele.getTableau(), x, y, sens);
				break;
			}
		}
	}
	
	private void premierTour() {
		ArrayList<BoxDomino> maxDominoParJoueur = new ArrayList<>();
		ArrayList<Integer> maxIndexParJoueur = new ArrayList<>();
		
		for (Joueur<BoxDomino> joueur : modele.getJoueurs()) {
			maxIndexParJoueur.add(BoxDomino.max(joueur.getMain()));
			maxDominoParJoueur.add(joueur.getBox(BoxDomino.max(joueur.getMain())));
		}
		modele.setJoueurCourant(BoxDomino.max(maxDominoParJoueur));
		
		modele.getJoueur(modele.getJoueurCourant()).joue(maxIndexParJoueur.get(modele.getJoueurCourant())).pose(modele.getTableau(), 15, 15, 1);
		
		vue.updateVue();
	}

	public void partie() {
		// pioche a tour de role 7 dominos
		// le plus gros double le joue (obligatoire)
		// chaque joueur joue a tour de role

		for (int i=0; i<7; i++)
			for (Joueur<BoxDomino> joueur : modele.getJoueurs())
				joueur.pioche(modele.pioche());

		premierTour();/*
		while (true) {
			modele.setJoueurCourant((modele.getJoueurCourant()+1)%modele.getJoueurs().size());
			tour(modele.getJoueurCourant());
		}*/

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
		// cas du changement de domino
		
		// cas de la selection de la case
		
		// cas de la selection du sens
		
	}

}
