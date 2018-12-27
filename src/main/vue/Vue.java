package main.vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.planche.Planche;

@SuppressWarnings("serial")
class Vue extends JFrame {
	protected Planche planche;
	protected JPanel table;
	protected JPanel[][] plateau;
	
	public Vue(Planche planche) {
		this.pack();
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.planche = planche;
		this.table = new JPanel();
		this.table.setLayout(new GridLayout(this.planche.getTableau().length + 2, this.planche.getTableau()[0].length + 2));
		this.plateau = new JPanel[this.planche.getTableau().length][this.planche.getTableau()[0].length];
		for(int i = 0; i < this.planche.getTableau().length; i++) {
			for(int j = 0; j < this.planche.getTableau()[0].length; j++) {
				JPanel box = new JPanel();
				this.plateau[i][j] = box;
				this.table.add(box);
			}
		}
		this.add(table);
	}
}
