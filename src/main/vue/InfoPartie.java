package main.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Joueur;
import main.planche.*;

@SuppressWarnings("serial")
public class InfoPartie extends JFrame {
	protected JPanel infos;
	protected Planche planche;
	
	public InfoPartie(Planche planche) {
		this.pack();
		this.setSize(new Dimension(1920, 1080));
		this.setVisible(true);
		this.setTitle("Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.planche = planche;
		JLabel joueur1 = new JLabel("Saisissez le nom du joueur 1   ");
		JTextField nomJoueur1 = new JTextField(10);
		JLabel joueur2 = new JLabel("Saisissez le nom du joueur 2   ");
		JTextField nomJoueur2 = new JTextField(10);
		JButton button = new JButton("Valider");
		
		button.addActionListener(event -> {
			this.planche.addJoueur(new Joueur(nomJoueur1.getText()));
			this.planche.addJoueur(new Joueur(nomJoueur2.getText()));
			
			VueDomino vue = new VueDomino((PlancheDomino) this.planche);
			vue.updateVue();
			this.setVisible(false);
		});

		this.infos = new JPanel();
		this.infos.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.infos.add(joueur1, c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.infos.add(nomJoueur1, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.infos.add(joueur2, c);
		
		c.gridx = 1;
		c.gridy = 2;
		this.infos.add(nomJoueur2, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 2;
		this.infos.add(button, c);
		
		this.add(this.infos);
	}
}
