package main.box;

import main.lien.LienDomino;

public class BoxDomino extends Box {
	private Box box2;

	public BoxDomino(LienDomino lien1, LienDomino lien2) {
		super(2, lien1);
		this.box2 = new Box(2, lien2);
		this.ajout();
		box2.ajout();
	}

	@Override
	public boolean estPosable(Box[][] tableau, int x, int y, int sens) {
		int[] c = sensToCoordonnees(sens);
		return super.estPosable(tableau, x, y, sens) && box2.estPosable(tableau, x + c[0], y + c[1], sens) || super.estPosable(tableau, x + c[0],y + c[1], sens) && box2.estPosable(tableau, x, y, sens);
	}

	@Override
	public void pose(Box[][] tableau, int x, int y, int sens) {
		int[] c = sensToCoordonnees(sens);
		if (super.estPosable(tableau, x, y, sens) && box2.estPosable(tableau, x + c[0], y + c[1], sens)) {
			super.pose(tableau, x, y, sens);
			box2.pose(tableau, x + c[0], y + c[1], sens);
		}
		else {
			super.pose(tableau, x + c[0],y + c[1], sens);
			box2.pose(tableau, x, y, sens);
		}

		this.nbLiens--;
		box2.nbLiens--;
	}
	
	public Box getBox2() {
		return box2;
	}
}