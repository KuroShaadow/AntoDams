package main.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.planche.PlancheDomino;

@SuppressWarnings("serial")
public class Menu extends JFrame {
	public Menu() {
		this.pack();
		this.setSize(new Dimension(1920, 1080));
		this.setVisible(true);
		this.setTitle("Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 4));

		JButton domino = new JButton("Domino");
		JButton puzzle = new JButton("Puzzle");
		JButton dominoGommettes = new JButton("Domino-gommettes");
		JButton saboteur = new JButton("Saboteur");

		JLabel imageDomino = new JLabel(new ImageLab("Images/domino.jpg"));
		this.add(imageDomino, BorderLayout.CENTER);

		JLabel imagePuzzle = new JLabel(new ImageLab("Images/puzzle.jpg"));
		this.add(imagePuzzle, BorderLayout.CENTER);

		JLabel imageDominoGommettes = new JLabel(new ImageLab("Images/dominoGommettes.jpg", 531, 400));
		this.add(imageDominoGommettes, BorderLayout.CENTER);

		JLabel imageSaboteur = new JLabel(new ImageLab("Images/Saboteur.jpg", 500, 375));
		this.add(imageSaboteur, BorderLayout.CENTER);

		domino.addActionListener(event -> {
			this.setVisible(false);

			PlancheDomino planche = new PlancheDomino();
			InfoPartie partie = new InfoPartie(planche);
		});
		this.add(domino);

		puzzle.addActionListener(event -> {

		});
		this.add(puzzle);

		dominoGommettes.addActionListener(event -> {

		});
		this.add(dominoGommettes);

		saboteur.addActionListener(event -> {

		});
		this.add(saboteur);
	}
}
