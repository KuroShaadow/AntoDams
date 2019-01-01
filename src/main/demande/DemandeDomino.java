package main.demande;

public class DemandeDomino extends Demande {

	protected Integer sens;

	public DemandeDomino() {

		this.sens = null;
	}

	@Override
	public boolean isComplet() {
		return super.isComplet() && sens != null;
	}

	public Integer getSens() {
		return sens;
	}

	public void setSens(Integer sens) {
		this.sens = sens;
	}

}
