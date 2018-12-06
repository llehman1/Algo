package labor2.aufgabe;

import javax.swing.JFrame;

/**
 * 
 * @author larslehmann and Alessio Torzi
 * @since 2018-11-01
 */
public class Main {
	public static void main(String[] args) {
		// Create Window
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// defines standard size of window
		window.setSize(520, 520);
		// creates and inserts Field into the windows. Object Field creates the pattern
		// of the graphic
		window.add(new Field());
		// Make the window visible
		window.setVisible(true);
		double a =108/60;
		System.out.println(0.8 * 130.974 / 32.9845 - 0.1 * (108/60));
		System.out.println(0.8 * 130.974 / 32.9845 - 0.1 * 108/60);
		System.out.println(32.9845 - 0.1 * (108/60d));
		System.out.println(32.9845 - 0.1 * 108/60);
		double h=(108d/60d);
		System.out.println(a);
		
		
	}

}
