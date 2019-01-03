package main.box;

import java.util.ArrayList;

import main.lien.LienDomino;

public class BoxDomino extends Box {
	private Box box2;

	public BoxDomino(LienDomino lien1, LienDomino lien2) {
		super(1, lien1);
		this.box2 = new Box(1, lien2);
	}

	@Override
	public boolean estPosable(Box[][] tableau, int x, int y, int sens) {
		boolean b = false;
		for (int[] cote : autourDesDeux(x, y, sens))
			if (tableau[cote[0]][cote[1]] != null)
				b = true;
		if (!b)
			return false;
		int[] c = sensToCoordonnees(sens);
		return super.estPosable(tableau, x, y, sens) && box2.estPosable(tableau, x + c[0], y + c[1], sens)
				|| super.estPosable(tableau, x + c[0], y + c[1], sens) && box2.estPosable(tableau, x, y, sens);
	}

	@Override
	public void pose(Box[][] tableau, int x, int y, int sens) {
		int[] c = sensToCoordonnees(sens);
		if (super.estPosable(tableau, x, y, sens) && box2.estPosable(tableau, x + c[0], y + c[1], sens)) {
			super.pose(tableau, x, y, sens);
			box2.pose(tableau, x + c[0], y + c[1], sens);
		} else {
			super.pose(tableau, x + c[0], y + c[1], sens);
			box2.pose(tableau, x, y, sens);
		}

		this.nbLiens--;
		box2.nbLiens--;
	}

	public ArrayList<int[]> autour(int x, int y, int sens) {
		ArrayList<int[]> autour = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			if (i == sens)
				continue;
			int[] c = sensToCoordonnees(i);
			autour.add(new int[] { x + c[0], y + c[1] });
		}

		return autour;
	}

	public ArrayList<int[]> autourDesDeux(int x, int y, int sens) {
		ArrayList<int[]> autour = autour(x, y, sens);
		int[] c = sensToCoordonnees(sens);

		autour.addAll(autour(x + c[0], y + c[1], (sens + 2) % 4));
		return autour;
	}

	public Box getBox2() {
		return box2;
	}

	public boolean supperieur(BoxDomino boxDomino) {
		int max1 = Math.max(((LienDomino) this.lien).getNombre(), ((LienDomino) this.box2.lien).getNombre());
		int max2 = Math.max(((LienDomino) boxDomino.lien).getNombre(), ((LienDomino) boxDomino.box2.lien).getNombre());

		if (max1 > max2)
			return true;
		if (max1 < max2)
			return false;

		int min1 = Math.min(((LienDomino) this.lien).getNombre(), ((LienDomino) this.box2.lien).getNombre());
		int min2 = Math.min(((LienDomino) boxDomino.lien).getNombre(), ((LienDomino) boxDomino.box2.lien).getNombre());

		return min1 > min2;

	}

	public static int max(ArrayList<BoxDomino> boxDominos) {
		
		if (boxDominos == null || boxDominos.size()==0)
			throw new RuntimeException();

		int max = 0;
		for (int i = 0; i < boxDominos.size(); i++)
			if (boxDominos.get(i).supperieur(boxDominos.get(max)))
				max = i;
		return max;
	}
}