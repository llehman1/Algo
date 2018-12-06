package labor3.aufgabe;

import java.awt.Color;

/**
 * <h1>The class allows you to store objects of the class node in a stack.</h1>
 * 
 * @author Lars Lehmann and Alessio Torzi
 * @version 1.1 orginal from Lars Lehmann
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
	private int id;

	private Controller controller;

	/**
	 * Default constructor create a empty Stack
	 */
	public Stack(Controller controller, int id) {
		super();
		this.node = null;
		this.index = 0;
		this.controller = controller;
		this.id = id;
	}

	/**
	 * Constructor initializes the source stack with the nodes in the Object Array
	 * 
	 * @param element:
	 *            two demitional arrays of class Object
	 * @param controller
	 *            object from the class Controller
	 */
	public Stack(Object[][] element, Controller controller) {
		this.id = 0;
		this.controller = controller;
		for (int i = element.length - 1; -1 < i; i--) {
			this.push((int) element[i][0], (Color) element[i][1]);
		}
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
		this.controller.update(this.id);
	}

	/**
	 * Mirrors the contents of the graphical view stack into an object array
	 * 
	 * @return Object[]: a Object Array with all nodes from this Stack
	 */
	public INodeUser[] viewStack() {
		if (this.isEmpty() == false) {
			INodeUser[] nodes = new Node[this.index];
			INodeAdminUser helpNode = this.node;
			nodes[0] = helpNode;
			if (index > 1) {
				for (int i = 1; i < this.index; i++) {
					// System.out.println("Der Stack mit der id:" + id + " und dem index: " + index
					// + "und i ist:" + i);
					helpNode = helpNode.getNext();
					nodes[i] = helpNode;
				}
			}
			return nodes;
		}
		return null;
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
		this.controller.update(this.id);
		return nowNode;
	}

	public int getId() {
		return this.id;
	}

	public int getIndex() {
		return this.index;
	}
}
