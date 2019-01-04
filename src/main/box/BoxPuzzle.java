package main.box;

import main.lien.Lien;

public class BoxPuzzle extends Box {
	private Box[] box2;

	public BoxPuzzle(Lien[] liens) {
		super(0, new Lien());

		this.box2 = new Box[4];

		for (int i = 0; i < 4; i++) {
			this.box2[i] = new Box(1, liens[i]);
		}
	}

	@Override
	public boolean estPosable(Box[][] tableau, int x, int y, int sens) {
		if (!super.estPosable(tableau, x, y, sens))
			return false;

		for (int i = 0; i < 4; i++) {
			int[] cote = sensToCoordonnees(i);
			int[] c = rotation(cote[0], cote[1], x, y, sens);
			if (!box2[i].estPosable(tableau, c[0], c[1], sens))
				return false;
		}
		return true;
	}

	@Override
	public void pose(Box[][] tableau, int x, int y, int sens) {
		super.pose(tableau, x, y, sens);

		for (int i = 0; i < 4; i++) {
			int[] cote = sensToCoordonnees(i);
			int[] rot = rotation(x+cote[0], y+cote[1], x, y, sens);
			box2[i].pose(tableau, rot[0], rot[1], sens);
		}

		for (int i = 0; i < 4; i++)
			box2[i].nbLiens--;
		this.nbLiens -= 4;
	}

	public int[] rotation(int x, int y, int centreX, int centreY, int sens) {
		int diffX = x - centreX;
		int diffY = y - centreY;

		if (sens == 0)
			return new int[] { x, y };
		if (sens == 1)
			return new int[] { centreX + diffY, centreY - diffX };
		if (sens == 2)
			return new int[] { centreX - diffX, centreY - diffY };
		if (sens == 3)
			return new int[] { centreX - diffY, centreY + diffX };
		throw new RuntimeException();
	}

	public Box[] getBox2() {
		return box2;
	}
}