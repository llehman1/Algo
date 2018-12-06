package labor3.aufgabe;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * <h1>The Class for the overview of the stacks</h1>
 * <p>
 * The class creates an overview of all 3 stacks for the graphical window.The
 * initial stack is always the left and the target stack the right one.
 * </p>
 * 
 * @author Lars Lehmann and Alessio Torzi
 * @since 2018-11-26
 */

@SuppressWarnings("serial")
public class StackPanal extends JPanel {

	/**
	 * view: Current status of all nodes in the three stacks. stack 0 is the source
	 * stack and stack 2 is the target stack
	 */
	private Object[][] view;

	/**
	 * the constructor for the initialization of the Main. This object is subpanel
	 * attribute in the main
	 * 
	 * @param main:
	 *            is the Object with the main method
	 */
	public StackPanal(MainFrame main) {
		this.view = new Object[3][];
		main.creatJPanel(this);
		this.repaint();
	}

	/**
	 * The method is always executed when something has changed on a stack to graph
	 * the change
	 * 
	 * @param newView:
	 *            is a is a two-dimensional Array from the class Object. the new
	 *            overview of all 3 stacks
	 */
	public void notifyPaint(Object[][] newView) {
		this.view = newView;
		this.repaint();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Draw the overview of all three stacks
	 */
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		int heigth = getHeight() - 30;
		int widthField = (getWidth() - 20) / 3;
		graphic.setColor(Color.red);
		for (int i = 0; i < 3; i++) {
			int startx = 5 + (widthField * i);
			graphic.setColor(Color.red);
			graphic.fillRect(startx, heigth, widthField - 10, 20);
			graphic.fillRect(((i * widthField) + (widthField - 15) / 2), 10, 20, heigth - 10);
			if (this.view[i] == null) {
			} else {
				// System.out.println(this.view[i].getClass());
				for (int index2 = 0; index2 < view[i].length; index2++) {
					double divX = (Math
							.round((double) (widthField - 10) / (((INodeUser) view[i][index2]).getNumber())));
					int rowW = (int) Math.round(divX / 2.0);
					int sizeW = (widthField - 10) - (int) Math.round(divX);
					if (sizeW <= 22) {
						sizeW = 22;
						rowW = (((widthField - 10) / 2) - sizeW + 12);
					}
					graphic.setColor(((INodeUser) view[i][index2]).getColor());
					graphic.fillRect(startx + rowW, heigth - ((view[i].length - index2) * 20), sizeW, 20);
				}
			}
		}
	}
}
