package gamePlay;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.setTitle("Brick Blaster");
		Game1 g = new Game1();
		frm.setContentPane(g);
		frm.setSize(500, 700);
		frm.setResizable(false);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}