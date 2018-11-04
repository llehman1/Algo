package labor2.vorbereitung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		Color color = Color.white;

		JFrame window = new JFrame();
		window.setTitle("Mein Schachbrettfenster");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBackground(color);
		//creates transparent JPanel for formatting
		FormartPanel top = new FormartPanel(color, 200, 200);
		
		JPanel background = new JPanel();
		background.setLayout(new BorderLayout());
		//JPanel box is a BoxLayout
		JPanel box = new JPanel();
		box.setBackground(color);
		box.setLayout(new BoxLayout(box, 1));
		//put in the box the ChessField
		box.add(new ChessField());
		//Add the transparent JPanel to the top field of BorderLayout(background)
		background.add(top, BorderLayout.PAGE_START);
		//Add the box containing the ChessField to the Center of BorderLayout(background)
		background.add(box, BorderLayout.CENTER);
		background.setBackground(color);
		//add the BorderLayout(background) to the Jfame
		window.add(background);
		//defines minimum size of JFrame
		window.setMinimumSize(new Dimension(400, 600));
		//standard size of JFrame
		window.setSize(700, 700);
		window.setVisible(true);

	}

}
