package main.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Joueur;
import main.box.BoxDomino;
import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class InfoPartie extends JFrame {
	protected JPanel infos;
	protected PlancheDomino planche;

	public InfoPartie(PlancheDomino planche) {
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
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
			this.setVisible(false);

			this.planche.addJoueur(new Joueur<BoxDomino>(nomJoueur1.getText()));
			this.planche.addJoueur(new Joueur<BoxDomino>(nomJoueur2.getText()));

			VueDomino vue = new VueDomino(this.planche);

			new Thread(new Runnable() {
				public void run() {
					vue.getControleur().partie();
				}
			}).start();
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
