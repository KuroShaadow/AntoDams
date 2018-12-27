package main.vue;

import javax.swing.JPanel;

import main.box.BoxDomino;
import main.lien.LienDomino;
import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class VueDomino extends Vue {	
	public VueDomino(PlancheDomino planche) {
		super(planche);
		this.setTitle("Table Domino");
	}
	
	public void addDomino(int x, int y, BoxDomino box) {
		LienDomino test = (LienDomino) box.getLien();
		this.plateau[x][y] = new ImagePan("Images/Dice" + test.getNombre() + ".png");
	}
	
	public void partie() {
		this.planche.partie();
		for(int i = 0; i < this.planche.getTableau().length; i++) {
			for(int j = 0; j < this.planche.getTableau()[0].length; j++) {
				if( this.planche.getTableau()[i][j] != null)
					this.addDomino(i, j, (BoxDomino) this.planche.getTableau()[i][j]);
			}
		}
	}
}
