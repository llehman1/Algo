package labor2.vorbereitung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * <h1>ChessField</h1> The ChessField extends from JPanel. It create a
 * ChessField with 64 white and black fields.For each field, a separate object
 * of class SquareField is generated
 * 
 * @author larslehmann
 * @since 2018-11-01
 */
@SuppressWarnings("serial")
public class ChessField extends JPanel {

	/**
	 * The Constructor set the LayoutManger , MaximumSize of the ChessField, Border
	 * and excute the method creatSField. MaximumSize is 380 x 380. The border is
	 * brown and has a thickness of 10 px. LayoutManger is GridLayout with 8 columns
	 * and 8 rows.Finally, The method {@link #creatSField() creatSField()} is
	 * executed.
	 * 
	 */
	public ChessField() {
		this.setLayout(new GridLayout(8, 8));
		this.setMaximumSize(new Dimension(380, 380));
		// this.setMinimumSize(new Dimension(400, 400));
		this.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 10));
		this.creatSField();
	}

	/**
	 * This method creates black and white sequence in the columns. The method
	 * iterates through the loop once for each column. Each cycle is executed the
	 * creatColumn method. The black and white sequence is created by varying the
	 * start color black and white in each cycle. more details about the method
	 * {@link #creatColumn(Color, Color) creatColumn} read the description.
	 */
	private void creatSField() {
		for (int index = 0; index < 8; index++) {
			if (index % 2 == 1) {
				this.creatColumn(Color.black, Color.white);
			} else {
				this.creatColumn(Color.white, Color.black);
			}
		}

	}

	/**
	 * The method creates exactly one column of 8 fields, alternating the two
	 * specified colors for each field. In each loop pass a field is created and
	 * passed as parameter the appropriate color. each field is an object of class
	 * {@link SquareField} SquareField
	 * 
	 * @param firstColor:
	 *            Color for first field in the column and for every field if the
	 *            index is an even number
	 * @param secondColor
	 *            Color for secound field in the column and for each field, if the
	 *            index is an odd number
	 */
	private void creatColumn(Color firstColor, Color secondColor) {
		for (int index = 0; index < 8; index++) {
			if (index % 2 == 1) {
				this.add(new SquareField(secondColor, 50, 50));
			} else {
				this.add(new SquareField(firstColor, 50, 50));
			}
		}
	}

}
