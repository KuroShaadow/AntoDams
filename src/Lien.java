
public class Lien {
	private int nombre;

	public Lien(int nombre) {
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
}
