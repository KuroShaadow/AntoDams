package main.box;

import main.lien.LienDomino;

public class BoxDomino extends Box {
	private Box box2;

	public BoxDomino(LienDomino lien1, LienDomino lien2) {
		super(2, lien1);
		this.box2 = new Box(2, lien2);
	}

	public void ajout(Box box, int cote1, int cote2) {
		if (super.estAjoutable(box, (cote1 + 2) % 4)) {
			super.ajout(box, (cote1 + 2) % 4);
			super.ajout(box2, cote2);
		} else {
			box2.ajout(box, (cote1 + 2) % 4);
			box2.ajout((Box) this, cote2);
		}
	}

	public boolean estAjoutable(Box box, int cote1, int cote2) {
		if (!super.estAjoutable(box, (cote1 + 2) % 4) && !box2.estAjoutable(box, (cote1 + 2) % 4))
			return false;
		return true;
	}

	public Box getBox2() {
		return box2;
	}
}