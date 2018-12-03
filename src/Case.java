
public class Case {
	private Case[] casesLiees;
	private int nbLiensMax;
	private Lien lien;

	public Case(int nbLiensMax, Lien lien) {
		this.casesLiees = new Case[4];
		this.nbLiensMax = nbLiensMax;
		this.lien = lien;
	}

	public boolean estAjoutable(Case case0, int cote1) {

		if (case0.nbLiens() >= case0.nbLiensMax)
			return false;
		if (this.nbLiens() >= this.nbLiensMax)
			return false;

		if (this.casesLiees[cote1] != null)
			return false;
		if (case0.casesLiees[(cote1 + 2) % 4] != null)
			return false;

		if (!this.lien.equals(case0.lien))
			return false;

		return true;
	}

	public void ajout(Case case0, int cote1) {

		this.casesLiees[cote1] = case0;
		case0.casesLiees[(cote1 + 2) % 4] = this;
	}
	
	public int nbLiens() {
		int nb = 0;
		for (Case case0 : casesLiees)
			if (case0 != null)
				nb++;
		return nb;
	}


	public Case[] getCasesLiees() {
		return this.casesLiees;
	}

	public int getNbLiensMax() {
		return this.nbLiensMax;
	}
}
