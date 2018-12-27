package main.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.planche.Planche;

@SuppressWarnings("serial")
class Vue extends JFrame {
	protected Planche planche;
	protected JPanel table;
	protected JPanel[][] plateau;
	protected JPanel maPioche;
	
	public Vue(Planche planche) {
		this.pack();
		this.setSize(new Dimension(1920, 1080));
		this.setPreferredSize(new Dimension(1920, 1080));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.planche = planche;
		this.table = new JPanel();
		this.table.setLayout(new GridLayout(this.planche.getTableau().length + 2, this.planche.getTableau()[0].length + 2));
		this.plateau = new JPanel[this.planche.getTableau().length][this.planche.getTableau()[0].length];
		for(int i = -1; i < this.planche.getTableau().length + 1; i++) {
			for(int j = -1; j < this.planche.getTableau()[0].length + 1; j++) {
				JPanel box = new JPanel();
				if(i == -1 || i == this.planche.getTableau().length || j == -1 || j == this.planche.getTableau()[0].length) {
					box.setBackground(Color.DARK_GRAY);
				} else {
					this.plateau[i][j] = box;
				}
				this.table.add(box);
			}
		}
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.weightx = 1;
		c.weighty = 100;
		this.add(table, c);
		this.maPioche = new JPanel();
		JLabel label = new JLabel("Ma pioche");
		maPioche.add(label);
		c.gridx = 2;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		this.add(maPioche, c);
	}
}
