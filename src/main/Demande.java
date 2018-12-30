package main;

import java.util.Scanner;

public class Demande {
	private int nb;
	private int x;
	private int y;
	private int sens;
	private static Scanner sc = new Scanner(System.in);

	public Demande() {

		this.nb = lire("nb");
		this.x = lire("x");
		this.y = lire("y");
		this.sens = lire("sens");
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

	public int getSens() {
		return sens;
	}

}
