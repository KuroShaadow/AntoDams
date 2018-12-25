package main.lien;

public class LienDomino {
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
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
	
	public Object getLien() {
		return this.getLien();
	}
}
