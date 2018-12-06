package labor3.aufgabe;

/**
 * <h1>The Class Controller</h1>
 * <p>
 * Class is responsible for the update function as soon as something changes in
 * a stack
 * </p>
 * 
 * @author Lars Lehmann and Alessio Torzi
 * @since 2018-11-26
 */

public class Controller {

	private Stack[] stack;
	/**
	 * obj: an overview of all nodes in the respective stack. For example, obj [0]
	 * reflects the contents of Stack [0].
	 */
	private Object[][] obj;
	private StackPanal stackPanal;

	/**
	 * The method runs when something changes on the stack.this then re-initializes
	 * the corresponding array
	 * 
	 * @param id:
	 *            intger number which authenticates the stack
	 */
	public void update(int id) {
		if (stack[id] != null) {
			this.obj[id] = stack[id].viewStack();
			this.stackPanal.notifyPaint(this.obj);
		}
	}

	/**
	 * Add the params to the stack array
	 * 
	 * @param stack:
	 *            Object from the class Stack
	 */
	public void addController(Stack stack) {
		this.stack[stack.getId()] = stack;
	}

	/**
	 * Constructor initializes the object
	 * 
	 * @param object:
	 *            two-dimensional array of the class object
	 * @param main:
	 *            is the Object with the main method
	 */
	public Controller(Object[][] object, MainFrame main) {
		this.stackPanal = new StackPanal(main);
		this.stack = new Stack[3];
		this.obj = new Object[3][];
		this.stack[0] = new Stack(object, this);
		this.stack[1] = new Stack(this, 1);
		this.stack[2] = new Stack(this, 2);
		this.update(0);

	}

	/**
	 * Method return the attribut stack.
	 * 
	 * @return a Stack Array
	 */
	public Stack[] getStack() {
		return this.stack;
	}

}
