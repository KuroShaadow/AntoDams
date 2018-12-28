package main;

import main.box.BoxDomino;
import main.lien.LienDomino;

class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.testDomino();
	}
	
	private void testDomino() {
		
		BoxDomino dom1 = new BoxDomino(new LienDomino(0), new LienDomino(0));
		BoxDomino dom2 = new BoxDomino(new LienDomino(0), new LienDomino(1));
		BoxDomino dom3 = new BoxDomino(new LienDomino(1), new LienDomino(2));
		BoxDomino dom4 = new BoxDomino(new LienDomino(0), new LienDomino(0));

		System.out.println(dom2.estAjoutable(dom1, 2, 1));
		if (dom2.estAjoutable(dom1, 2, 1))
			dom2.ajout(dom1, 2, 1);
		System.out.println(dom3.estAjoutable(dom2.getBox2(), 1, 2));
		if (dom3.estAjoutable(dom2.getBox2(), 1, 2))
			dom3.ajout(dom2.getBox2(), 1, 2);
		System.out.println(dom4.estAjoutable(dom1, 0, 0));
		if (dom4.estAjoutable(dom1, 0, 0))
			dom4.ajout(dom1, 0, 0);
	}

}
