package main;

import java.awt.EventQueue;

import main.vue.Menu;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Menu menu = new Menu();
			}
		});
	}
}
