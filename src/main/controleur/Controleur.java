package main.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.box.BoxDomino;
import main.planche.Planche;
import main.planche.PlancheDomino;
import main.vue.Vue;
import main.vue.VueDomino;

public abstract class Controleur<T> implements MouseListener {

	protected Planche<T> modele;
	protected Vue<T> vue;

	protected Integer numero;
	protected Integer x;
	protected Integer y;

	public Controleur(Vue<T> vue) {
		this.vue = vue;
		this.modele = vue.getPlanche();
	}
	
	protected void attente() {
		numero = null;
		x = null;
		y = null;
		while (numero==null || x==null || y==null) {
			try {
				Thread.sleep(2000);
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
