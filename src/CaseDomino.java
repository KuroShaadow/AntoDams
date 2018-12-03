
public class CaseDomino extends Case {
	private Case case2;

	public CaseDomino(Lien lien1, Lien lien2) {
		super(2, lien1);
		this.case2 = new Case(2, lien2);
	}

	public void ajout(Case case0, int cote1, int cote2) {
		if (super.estAjoutable(case0, (cote1 + 2) % 4)) {
			super.ajout(case0, (cote1 + 2) % 4);
			super.ajout(case2, cote2);
		} else {
			case2.ajout(case0, (cote1 + 2) % 4);
			case2.ajout((Case) this, cote2);
		}
	}

	public boolean estAjoutable(Case case0, int cote1, int cote2) {
		if (!super.estAjoutable(case0, (cote1 + 2) % 4) && !case2.estAjoutable(case0, (cote1 + 2) % 4))
			return false;
		return true;
	}

	public Case getCase2() {
		return case2;
	}
}