package labor3.aufgabe;

import java.awt.Color;

/**
 * <h1>The Node class</h1>
 * <p>
 * the class is used to save a color with the associated integer number
 * </p>
 * 
 * @author Lars Lehmann
 * @since 2018-11-22
 */

public class Node implements INodeAdminUser {

	private INodeAdminUser next;
	private int number;
	private Color color;

	/**
	 * Constructor initializes the object with the values ​​of the parameters
	 * 
	 * @param next:
	 *            next node-object from the interface INodeAdminUser
	 * @param number:
	 *            int number value of this Object
	 * @param color:
	 *            color is a Object from java.awt.Color
	 */
	public Node(INodeAdminUser next, int number, Color color) {
		super();
		this.next = next;
		this.number = number;
		this.color = color;
	}

	@Override
	public INodeAdminUser getNext() {
		return next;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	/**
	 * Convert the Object in a String
	 * 
	 * @return a String with the Values(Color ,Number) of the Object
	 */
	@Override
	public String toString() {
		return "Number:" + this.number + " Color: " + this.color.toString() + "Next: " + next;
	}

	@Override
	public void setNext(INodeAdminUser node) {
		this.next = node;

	}

}
