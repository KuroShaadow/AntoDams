package main.demande;

public class Demande {

	protected Integer nb;
	protected Integer x;
	protected Integer y;
	protected Integer sens;
	protected boolean pioche;

	public Demande() {

		System.out.println("nouvelle demande");
		this.nb = null;
		this.x = null;
		this.y = null;
		this.sens = null;
		this.pioche = false;
	}

	public boolean isComplet() {
		return nb != null && x != null && y != null && sens != null || pioche;
	}

	public Integer getNb() {
		return nb;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Integer getSens() {
		return sens;
	}

	public boolean getPioche() {
		return pioche;
	}

	public void setNb(Integer nb) {
		System.out.println("nb = " + nb);
		this.nb = nb;
	}

	public void setX(Integer x) {
		System.out.println("x = " + x);
		this.x = x;
	}

	public void setY(Integer y) {
		System.out.println("y = " + y);
		this.y = y;
	}

	public void setSens(Integer sens) {
		System.out.println("sens = " + sens);
		this.sens = sens;
	}

	public void setPioche(boolean pioche) {
		System.out.println("pioche = " + pioche);
		this.pioche = pioche;
	}

}
