package main.lien;

public class LienPuzzle extends Lien {
	private int type;
	private boolean genre;

	public LienPuzzle(int type, boolean genre) {
		this.type = type;
		this.genre = genre;
	}

	public int getType() {
		return type;
	}

	public boolean isGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "" + type + genre;
	}
}
