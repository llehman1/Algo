package labor3.vorbereitung;

import java.awt.Color;

/**
 * 
 * <h1>The class allows you to store objects of the class node in a stack.</h1>
 * 
 * @author larslehmann
 * @since 2018-11-22
 */

public class Stack {
	/**
	 * node is always the current top node. if no node exists, node = null
	 */
	private INodeAdminUser node;
	/**
	 * The index returns the current size of the stack.
	 */
	private int index;

	/**
	 * Constructor create a Stack with one node.the node has the values of the
	 * params.
	 * 
	 * @param number
	 *            : number Value of the Object
	 * @param color
	 *            : color Value of the Object
	 */
	public Stack(int number, Color color) {
		super();
		this.node = new Node(null, number, color);
		this.index = 1;
	}

	/**
	 * Default constructor create a empty Stack
	 */
	public Stack() {
		super();
		this.node = null;
		this.index = 0;
	}

	/**
	 * the method returns whether the stack is empty or not
	 * 
	 * @return true if the stack empty
	 */
	public boolean isEmpty() {
		if (index == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Create a new Node Object with the values of the params and add to the stack
	 * as the top node
	 * 
	 * @param number
	 *            : number Value of the Object
	 * @param color
	 *            : color Value of the Object
	 */
	public void push(int number, Color color) {
		if (this.isEmpty()) {
			this.node = new Node(null, number, color);
		} else {
			this.node = new Node(this.node, number, color);
		}
		this.index++;
	}

	/**
	 * The method takes the top node from the stack and returns that object.the
	 * returned node is deleted in the stack and the object in the second position
	 * is now in the first position. if there is no other object, the stack is empty
	 * and the attribute node = null
	 * 
	 * @return a object from the interface INodeUser
	 * @throws Exception
	 *             if the method runs on an empty stack
	 */
	public INodeUser pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack ist leer");
		}
		INodeUser nowNode = this.node;
		this.index--;
		this.node = this.node.getNext();
		return nowNode;
	}
}
