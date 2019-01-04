package main.vue;

import java.util.ArrayList;

import main.Joueur;
import main.box.Box;
import main.box.BoxDomino;
import main.controleur.ControleurDominoConsole;
import main.lien.LienDomino;
import main.planche.Planche;
import main.planche.PlancheDomino;

public class VueDominoConsole {
	protected Planche<BoxDomino> planche;
	protected ControleurDominoConsole controleur;

	public VueDominoConsole(Planche<BoxDomino> planche) {
		this.planche = planche;
		this.controleur = new ControleurDominoConsole(this);

	}

	public void updateVue() {
		Box[][] tableau = planche.getTableau();
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++)
				System.out.print(tableau[j][i] == null ? "." : tableau[j][i].getLien());

			System.out.println();
		}
		System.out.println();

		Joueur<BoxDomino> joueur = planche.getJoueur(planche.getJoueurCourant());
		ArrayList<BoxDomino> pioche = joueur.getMain();
		for (BoxDomino box : pioche) {
			System.out.print(box.getLien());
		}
		System.out.println();
		for (BoxDomino box : pioche) {
			System.out.print(box.getBox2().getLien());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		VueDominoConsole vue = new VueDominoConsole(new PlancheDomino());

		vue.getPlanche().addJoueur(new Joueur<BoxDomino>("joueur 1"));
		vue.getPlanche().addJoueur(new Joueur<BoxDomino>("joueur 2"));

		new Thread(new Runnable() {
			public void run() {
				vue.getControleur().partie();
			}
		}).start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		while (true)
			vue.getControleur().envoi();
	}

	public Planche<BoxDomino> getPlanche() {
		return planche;
	}

	public ControleurDominoConsole getControleur() {
		return controleur;
	}
}
