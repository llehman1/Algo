package labor2.aufgabe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * <h1>This Class create on black or white Field</h1>
 * 
 * @author larslehmann and Alessio Torzi
 * @since 2018-11-01
 */
@SuppressWarnings("serial")
public class Field extends JPanel {

	/** Color for the different levels */
	private Color[] color = { Color.red, Color.YELLOW, Color.green, Color.orange, Color.BLUE, Color.pink,
			Color.MAGENTA };
	/** height of the field */
	private int height;
	/** width of the field */
	private int width;
	/** colorIndex is an index for the color assignment of the individual levels */
	private int colorIndex;
	/**
	 * manyRec specifies how many rectangles are created in a row and column at the
	 * lowest level. the number must be a two-potency. manyRec=2^n, Number of levels
	 * = (n+1),
	 */
	private int manyRec;
	/**
	 * fieldSize when creating the level, the size of the individual fields is saved
	 * here. Replaces a parameter paintRectangles
	 */
	private float fieldSize;

	/**
	 * The constructor initializes the three private variables manyRec and
	 * colorIndex
	 */
	public Field() {
		super();
		this.colorIndex = 0;
		this.manyRec = 16;
		repaint();
	}

	/**
	 * The methode creates the rectangles in the specified size and color. This
	 * method is called by default after the constructor. Because SquareField
	 * extends from JPanel
	 */
	@Override
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		this.height = this.getHeight();
		this.width = this.getWidth();
		this.colorIndex = 0;
		this.manyRec = 16;
		this.paintRectangles(graphic, 0, 0, 0);
	}

	/**
	 * always creates exactly one rectangle. however, the method calls itself until
	 * all levels have been created with all rectangles. first call:
	 * this.paintRectangles(graphic, 0, 0, 0) and manyRec=2^n and colorIndex==0
	 * X-axis is the width of the window, Y-axis is the height of the window
	 * 
	 * @param graphic
	 *            a object from class Graphics.
	 * @param x
	 *            Coordinate for the position
	 * @param y
	 *            Coordinate for the position
	 * @param index
	 *            The index indicates how many rectangles are currently being
	 *            created. When a level is completed, the index for the next level
	 *            is reset to zero. Is the Index indx modulo manyRec == 0 a new line
	 *            is created. manyRec*manyRec == Index Created a new level
	 */
	private void paintRectangles(Graphics graphic, float x, float y, int index) {
		if (this.manyRec < 1) {
			return;
		} else {
			if (index == 0) {
				if (this.width <= this.height) {
					this.fieldSize = (float) (this.width) / (this.manyRec * 2f);
				} else {
					this.fieldSize = (float) (this.height) / (this.manyRec * 2f);
				}
				// System.out.println("null");
				// System.out.println(fieldsize);
				x = this.fieldSize / 2f;
				y = this.fieldSize / 2f;
			} else if ((this.manyRec * this.manyRec) == index) {
				// System.out.println("many*many");
				this.manyRec = (int) (this.manyRec / 2f);
				index = -1;
			} else if (index % (this.manyRec) == 0) {
				// System.out.println("mod");
				x = this.fieldSize / 2f;
				y = y + (2f * this.fieldSize);
			} else {
				// System.out.println("else");
				x = x + (2f * this.fieldSize);
			}
			graphic.setColor(color[colorIndex]);
			graphic.fillRect(Math.round(x), Math.round(y), Math.round(this.fieldSize), Math.round(this.fieldSize));
			if (index == -1) {
				this.colorIndex++;
			}
			index = index + 1;
			// System.out.println(
			// "x: " + x + " y: " + y + " index: " + index + "size: " + fieldSize + "Farbe:
			// " + color[colorIndex]);
			this.paintRectangles(graphic, x, y, index);
		}
	}
}
