package labor3.aufgabe;

import java.awt.Color;
/**
 * @author Lars Lehmann
 * @since 2018-11-22
 */

public interface INodeUser {
	/**
	 * The method returns the color of the object
	 * 
	 * @return the color
	 */
	public Color getColor();

	/**
	 * The method returns the number of the object
	 * 
	 * @return the Number
	 */
	public int getNumber();

	/**
	 * Creates a string from the attribute value of the object
	 * 
	 * @return the attribute values ​​as string
	 */
	public String toString();

}
