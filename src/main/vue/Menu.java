package main.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Joueur;
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
		
		JPanel imageDomino = new ImagePan("Images/domino.jpg");
		this.add(imageDomino, BorderLayout.CENTER);
		
		JPanel imagePuzzle = new ImagePan("Images/puzzle.jpg");
		this.add(imagePuzzle, BorderLayout.CENTER);
		
		JPanel imageDominoGommettes = new ImagePan("Images/dominoGommettes.jpg");
		this.add(imageDominoGommettes, BorderLayout.CENTER);
		
		JPanel imageSaboteur = new ImagePan("Images/Saboteur.jpg");
		this.add(imageSaboteur, BorderLayout.CENTER);
		
		domino.addActionListener(event -> {
			PlancheDomino planche = new PlancheDomino();
			InfoPartie partie = new InfoPartie(planche);
			this.setVisible(false);
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
