package main.lien;

public class LienDomino extends Lien {
	private int nombre;

	public LienDomino(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return this.nombre;
	}
	
	@Override
	public String toString() {
		return ""+nombre;
	}
}
