package main.box;

import java.util.ArrayList;

import main.lien.Lien;
import main.lien.LienPuzzle;

public class BoxPuzzle extends Box {
	private Box[] box2;

	public BoxPuzzle(LienPuzzle[] liens) {
		super(0, new Lien());

		this.box2 = new Box[8];

		for (int i = 0; i < 4; i++) {
			this.box2[i] = new Box(1, liens[i]);
			this.box2[i + 4] = new Box(0, new Lien());
		}
	}

	@Override
	public boolean estPosable(Box[][] tableau, int x, int y, int sens) {
		boolean b = false;
		for (int[] cote : autourDeTout(x, y, sens))
			if (tableau[cote[0]][cote[1]] != null)
				b = true;
		if (!b)
			return false;
		for (int[] cote : autourDeTout(x, y, sens)) {
			int[] c = rotation(cote[0], cote[1], x, y, sens);
			if (!super.estPosable(tableau, c[0], c[1], sens))
				return false;
		}
		return true;
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

	@Override
	public void pose(Box[][] tableau, int x, int y, int sens) {

		super.pose(tableau, x, y, sens);

		ArrayList<int[]> ext = extremite(x, y, sens);
		for (int i = 0; i < 8; i++) {
			int[] cote = ext.get(i);
			int[] rot = rotation(cote[0], cote[1], x, y, sens);
			box2[i].pose(tableau, rot[0], rot[1], sens);
		}

		for (int i = 0; i < 4; i++) {
			box2[i].nbLiens -= 3;
			box2[i + 4].nbLiens -= 2;
		}
		this.nbLiens -= 4;
	}

	public ArrayList<int[]> autourDeTout(int x, int y, int sens) {
		ArrayList<int[]> autour = new ArrayList<>();

		for (int i = -1; i <= 1; i++) {
			autour.add(new int[] { x + i, y - 2 });
			autour.add(new int[] { x + i, y + 2 });
			autour.add(new int[] { x - 2, y + i });
			autour.add(new int[] { x + 2, y + i });
		}

		return autour;
	}

	public ArrayList<int[]> extremite(int x, int y, int sens) {
		ArrayList<int[]> autour = new ArrayList<>();

		autour.add(new int[] { x, y + 1 });
		autour.add(new int[] { x - 1, y });
		autour.add(new int[] { x + 1, y });
		autour.add(new int[] { x, y - 1 });

		autour.add(new int[] { x - 1, y + 1 });
		autour.add(new int[] { x + 1, y + 1 });
		autour.add(new int[] { x - 1, y - 1 });
		autour.add(new int[] { x + 1, y - 1 });

		return autour;
	}

	public Box[] getBox2() {
		return box2;
	}
}