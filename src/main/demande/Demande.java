package main.demande;

import java.util.Scanner;

public class Demande {
	protected Integer nb;
	protected Integer x;
	protected Integer y;

	private static Scanner sc = new Scanner(System.in);

	public Demande() {

		this.nb = null;
		this.x = null;
		this.y = null;
	}

	private int lire(String text) {
		System.out.print(text + " : ");
		int lu = sc.nextInt();
		sc.nextLine();
		return lu;
	}

	public int getNb() {
		return nb;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public boolean isComplet() {
		return nb != null && x != null && y != null;
	}

}