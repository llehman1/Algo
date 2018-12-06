package labor2.vorbereitung;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * This class format we only needed for formatting. do not run for the program.
 * 
 * @author larslehmann
 *
 */
@SuppressWarnings("serial")
public class FormartPanel extends JPanel {
	private int width;
	private int height;
	private Color color;

	public FormartPanel(Color color, int width, int height) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.setBackground(color);
		this.setLayout(new GridLayout(8, 8));
		this.full();
	}

	private void full() {
		int midw = this.width / 8;
		int midh = this.height / 8;
		for (int index = 0; 64 > index; index++) {
			this.add(new SquareField(this.color, midh, midw));
		}

	}

}
