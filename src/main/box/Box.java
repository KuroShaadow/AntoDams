package main.box;

public class Box {
	private Box[] boxLiees;
	private int nbLiensMax;
	protected Object lien;

	public Box(int nbLiensMax, Object lien) {
		this.boxLiees = new Box[4];
		this.nbLiensMax = nbLiensMax;
		this.lien = lien;
	}

	public boolean estAjoutable(Box box, int cote1) {

		if (box.nbLiens() >= box.nbLiensMax)
			return false;
		if (this.nbLiens() >= this.nbLiensMax)
			return false;

		if (this.boxLiees[cote1] != null)
			return false;
		if (box.boxLiees[(cote1 + 2) % 4] != null)
			return false;

		if (!this.lien.equals(box.lien))
			return false;

		return true;
	}

	public void ajout(Box box, int cote1) {

		this.boxLiees[cote1] = box;
		box.boxLiees[(cote1 + 2) % 4] = this;
	}
	
	public int nbLiens() {
		int nb = 0;
		for (Box case0 : boxLiees)
			if (case0 != null)
				nb++;
		return nb;
	}


	public Box[] getCasesLiees() {
		return this.boxLiees;
	}

	public int getNbLiensMax() {
		return this.nbLiensMax;
	}
	
	public Object getLien() {
		return this.lien;
	}
}
