package main.planche;

import main.Joueur;
import main.box.BoxPuzzle;
import main.lien.Lien;
import main.lien.LienPuzzle;

public class PlanchePuzzle extends Planche<BoxPuzzle> {

	public PlanchePuzzle() {
		super(3*3, 3*3);

		this.pioche.add(new BoxPuzzle(new Lien[] {new Lien(), new LienPuzzle(0, true), new LienPuzzle(0, false), new Lien()}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new Lien(), new LienPuzzle(0, false), new LienPuzzle(1, true), new LienPuzzle(0, false)}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new Lien(), new Lien(), new LienPuzzle(0, true), new LienPuzzle(0, true)}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(0, true), new LienPuzzle(0, true), new LienPuzzle(1, true), new Lien()}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(1, false), new LienPuzzle(0, false), new LienPuzzle(1, true), new LienPuzzle(0, false)}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(0, false), new Lien(), new LienPuzzle(0, true), new LienPuzzle(0, true)}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(1, false), new LienPuzzle(0, true), new Lien(), new Lien()}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(1, false), new LienPuzzle(1, false), new Lien(), new LienPuzzle(0, false)}));
		this.pioche.add(new BoxPuzzle(new Lien[] {new LienPuzzle(0, false), new Lien(), new Lien(), new LienPuzzle(1, true)}));
	}

	@Override
	public void addJoueur(Joueur<BoxPuzzle> joueur) {
		if (this.joueurs.size() <= 1)
			super.addJoueur(joueur);
	}
}
