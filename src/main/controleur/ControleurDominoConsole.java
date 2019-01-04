package main.controleur;

import java.util.ArrayList;
import java.util.Scanner;

import main.Joueur;
import main.box.BoxDomino;
import main.demande.Demande;
import main.planche.Planche;
import main.vue.VueDominoConsole;

public class ControleurDominoConsole {

	protected Planche<BoxDomino> modele;
	protected VueDominoConsole vue;

	protected Demande demande;
	private static Scanner sc = new Scanner(System.in);

	public ControleurDominoConsole(VueDominoConsole vue) {
		this.vue = vue;
		this.modele = vue.getPlanche();
	}

	protected void attente() {

		while (!demande.isComplet()) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

	protected void tour(int nb) {
		// si il ne peut pas jouer il pioche et passe
		//
		vue.updateVue();

		Joueur<BoxDomino> joueur = modele.getJoueur(nb);
		while (true) {
			this.demande = new Demande();
			attente();
			if (demande.getPioche()) {
				modele.getJoueur(modele.getJoueurCourant()).pioche(modele.pioche());
				vue.updateVue();
			} else {
				BoxDomino box = joueur.getBox(demande.getNb());
				if (box.estPosable(modele.getTableau(), demande.getX(), demande.getY(), demande.getSens())) {
					joueur.joue(demande.getNb()).pose(modele.getTableau(), demande.getX(), demande.getY(),
							demande.getSens());
					break;
				}
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

		modele.getJoueur(modele.getJoueurCourant()).joue(maxIndexParJoueur.get(modele.getJoueurCourant()))
				.pose(modele.getTableau(), 15, 15, 1);

		vue.updateVue();
	}

	private int lire(String text) {
		System.out.print(text + " : ");
		int lu = sc.nextInt();
		sc.nextLine();
		return lu;
	}

	public void envoi() {

		int nb = -1;
		while (nb < 0 || nb >= modele.getJoueur(modele.getJoueurCourant()).getMain().size())
			nb = lire("nb");
		demande.setNb(nb);

		int x = -1;
		while (x < 0 || x >= modele.getTableau().length)
			x = lire("x");
		demande.setX(x);

		int y = -1;
		while (y < 0 || y >= modele.getTableau()[0].length)
			y = lire("y");
		demande.setY(y);

		int sens = -1;
		while (sens < 0 || sens > 1)
			sens = lire("sens");
		demande.setSens(sens);

		int pioche = -1;
		while (pioche < 0 || pioche > 1)
			pioche = lire("pioche");
		demande.setPioche(pioche == 1);
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
}
