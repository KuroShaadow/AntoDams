package main.controleur;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.demande.Demande;
import main.planche.Planche;
import main.vue.Vue;

public abstract class Controleur<T> implements MouseListener {

	protected Planche<T> modele;
	protected Vue<T> vue;

	protected Demande demande;

	public Controleur(Vue<T> vue) {
		this.vue = vue;
		this.modele = vue.getPlanche();
	}

	protected void attente() {

		while (!demande.isComplet()) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

	public abstract void partie();

	protected abstract void tour(int nb);

	@Override
	public void mouseReleased(MouseEvent e) {
		// cas du changement de domino
		Component component = e.getComponent();
		if (vue.getMain().contains(component))
			demande.setNb(vue.getMain().indexOf(component));
		else if (vue.contains(component)) {
			int[] coord = vue.getCoordonnees(component);
			if (demande.getX() == null || demande.getY() == null) {
				// cas de la selection de la case
				demande.setX(coord[0]);
				demande.setY(coord[1]);
			} else {
				// cas de la selection du sens
				int x = demande.getX();
				int y = demande.getY();

				if (coord[0] == x && coord[1] == y + 1)
					demande.setSens(0);
				else if (coord[0] == x + 1 && coord[1] == y)
					demande.setSens(1);
				else if (coord[0] == x && coord[1] == y - 1)
					demande.setSens(2);
				else if (coord[0] == x - 1 && coord[1] == y)
					demande.setSens(3);
				else
					demande = new Demande();
			}
		} else if (component == vue.getPiocher() && modele.estPiochable()) {
			modele.getJoueur(modele.getJoueurCourant()).pioche(modele.pioche());
			vue.updateVue();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setBackground(new Color(255, 255, 200));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setBackground(new Color(238, 238, 238));
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
