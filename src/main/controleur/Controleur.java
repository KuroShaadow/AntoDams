package main.controleur;

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
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
