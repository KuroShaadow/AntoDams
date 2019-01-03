package main.demande;

import java.util.Scanner;

public class Demande {
	
	protected Integer nb;
	protected Integer x;
	protected Integer y;
	protected Integer sens;

	private static Scanner sc = new Scanner(System.in);

	public Demande() {

		this.nb = null;
		this.x = null;
		this.y = null;
		this.sens = null;
	}

	public boolean isComplet() {
		return nb != null && x != null && y != null && sens != null;
	}

	private int lire(String text) {
		System.out.print(text + " : ");
		int lu = sc.nextInt();
		sc.nextLine();
		return lu;
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

	public void setNb(Integer nb) {
		this.nb = nb;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void setSens(Integer sens) {
		this.sens = sens;
	}

}
