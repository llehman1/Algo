package labor2.vorbereitung;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * <h1>This Class create on black or white Field</h1>
 * 
 * @author larslehmann
 * @since 2018-11-01
 */
@SuppressWarnings("serial")
public class SquareField extends JPanel {

	/** Color of the field */
	private Color color;
	/** height of the field */
	private int height;
	/** width of the field */
	private int width;

	/**
	 * The constructor initializes the three private variables color, height and
	 * width
	 * 
	 * @param color
	 *            initializes the color
	 * @param height
	 *            initializes the height
	 * @param width
	 *            initializes the width
	 */
	public SquareField(Color color, int height, int width) {
		super();
		this.color = color;
		this.height = height;
		this.width = width;
		this.setBackground(color);
	}

	/**
	 * The methode creates the rectangles in the specified size and color. This
	 * method is called by default after the constructor. Because SquareField
	 * extends from JPanel
	 */
	@Override
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		graphic.setColor(this.color);
		graphic.fillRect(0, 0, this.width, this.height);
	}
}
