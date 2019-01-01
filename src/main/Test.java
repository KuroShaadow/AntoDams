package main;

import main.box.BoxDomino;
import main.lien.LienDomino;
import main.planche.PlancheDomino;

class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.testDomino();
	}

	private void testDomino() {

		PlancheDomino plancheDomino = new PlancheDomino();

		BoxDomino dom1 = new BoxDomino(new LienDomino(0), new LienDomino(0));
		BoxDomino dom2 = new BoxDomino(new LienDomino(0), new LienDomino(1));
		BoxDomino dom3 = new BoxDomino(new LienDomino(1), new LienDomino(2));
		BoxDomino dom4 = new BoxDomino(new LienDomino(0), new LienDomino(0));

		poseDomino(plancheDomino, dom1, 10, 11, 1, "dom1");
		poseDomino(plancheDomino, dom2, 12, 11, 2, "dom2");
		poseDomino(plancheDomino, dom3, 13, 12, 1, "dom3");
		poseDomino(plancheDomino, dom4, 11, 10, 1, "dom4");
	}

	private void poseDomino(PlancheDomino planche, BoxDomino box, int x, int y, int sens, String nom) {

		if (box.estPosable(planche.getTableau(), x, y, sens)) {
			System.out.println(nom);
			box.pose(planche.getTableau(), x, y, sens);
		}
	}
}
