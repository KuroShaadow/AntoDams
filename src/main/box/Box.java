package main.box;

import main.lien.Lien;

public class Box {
	private int nbLiensMax;
	protected int nbLiens;
	private int sens;
	protected Lien lien;

	public Box(int nbLiensMax, Lien lien) {
		this.nbLiensMax = nbLiensMax;
		this.nbLiens = 0;
		this.lien = lien;
	}

	public boolean estAjoutable(Box box) {

		if (box.nbLiens >= box.nbLiensMax)
			return false;
		if (this.nbLiens >= this.nbLiensMax)
			return false;

		if (!this.lien.equals(box.lien))
			return false;

		return true;
	}

	public boolean estPosable(Box[][] tableau, int x, int y, int sens) {
		if (tableau[x][y] != null)
			return false;
		for (int i = 0; i < 4; i++) {
			int[] c = sensToCoordonnees(i);
			if (tableau[x + c[0]][y + c[1]] != null && !estAjoutable(tableau[x + c[0]][y + c[1]]))
				return false;
		}
		return true;
	}

	public void pose(Box[][] tableau, int x, int y, int sens) {
		for (int i = 0; i < 4; i++) {
			int[] c = sensToCoordonnees(i);
			if (tableau[x + c[0]][y + c[1]] != null) {
				tableau[x + c[0]][y + c[1]].ajout();
				ajout();
			}
		}
		setSens(sens);
		tableau[x][y] = this;

	}

	public int[] sensToCoordonnees(int sens) {
		if (sens == 0)
			return new int[] { 0, 1 };
		if (sens == 1)
			return new int[] { 1, 0 };
		if (sens == 2)
			return new int[] { 0, -1 };
		if (sens == 3)
			return new int[] { -1, 0 };
		throw new RuntimeException();
	}

	public void ajout() {
		nbLiens++;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public int getSens() {
		return sens;
	}

	public int getNbLiensMax() {
		return this.nbLiensMax;
	}

	public int getNbLiens() {
		return this.nbLiens;
	}

	public Lien getLien() {
		return this.lien;
	}
}
