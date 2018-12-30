package main.controleur;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.Joueur;
import main.box.BoxDomino;
import main.planche.PlancheDomino;
import main.vue.VueDomino;

public class ControleurDomino implements ChangeListener {

	private PlancheDomino modele;
	private VueDomino vue;

	private Integer nbDomino;
	private Integer x;
	private Integer y;
	private Integer sens;

	public ControleurDomino(PlancheDomino modele, VueDomino vue){
		 this.modele = modele;
		 this.vue = vue;
	 }
	
	private void attente() {
		nbDomino = null;
		x = null;
		y = null;
		sens = null;
		while (nbDomino==null || x==null || y==null || sens==null);
	}

	public void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//

		modele.affiche();
		Joueur<BoxDomino> joueur = modele.getJoueur(nb);
		while (true) {
			attente();
			
			BoxDomino box =  joueur.getBox(nbDomino);
			if (box.estPosable(modele.getTableau(), x, y, sens)) {
				joueur.joue(nbDomino).pose(modele.getTableau(), x, y, sens);
				break;
			}
		}
	}
	
	public void premierTour() {
		ArrayList<BoxDomino> maxDominoParJoueur = new ArrayList<>();
		ArrayList<Integer> maxIndexParJoueur = new ArrayList<>();
		
		for (Joueur<BoxDomino> joueur : modele.getJoueurs()) {
			maxIndexParJoueur.add(BoxDomino.max(joueur.getMain()));
			maxDominoParJoueur.add(joueur.getBox(BoxDomino.max(joueur.getMain())));
		}
		modele.setJoueurCourant(BoxDomino.max(maxDominoParJoueur));
		
		modele.getJoueur(modele.getJoueurCourant()).joue(maxIndexParJoueur.get(modele.getJoueurCourant())).pose(modele.getTableau(), 15, 15, 1);
	}

	public void partie() {
		// inscription des joueurs
		// pioche a tour de role 7 dominos
		// le plus gros double le joue (obligatoire)
		// chaque joueur joue a tour de role
		
		modele.addJoueur(new Joueur<BoxDomino>("1"));
		modele.addJoueur(new Joueur<BoxDomino>("2"));

		for (int i=0; i<7; i++)
			for (Joueur<BoxDomino> joueur : modele.getJoueurs())
				joueur.pioche(modele.pioche());

		premierTour();
		while (true) {
			modele.setJoueurCourant((modele.getJoueurCourant()+1)%modele.getJoueurs().size());
			tour(modele.getJoueurCourant());
		}

	}

	@Override
	public void stateChanged(ChangeEvent event) {

		
		// cas du changement de domino
		
		// cas de la selection de la case
		
		// cas de la selection du sens
		
	}

}
