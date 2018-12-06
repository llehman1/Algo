package labor3.aufgabe;

/**
 * <h1>The Class Hanoi</h1>
 * <p>
 * implements the functions of Hanoi shift on 3 stacks
 * </p>
 * 
 * @author Lars Lehmann and Alessio Torzi
 * @since 2018-11-26
 */
public class Hanoi {
	private Stack[] stack;

	/**
	 * the constructor initializes the variables Stack
	 * 
	 * @param stack:
	 *            it is a filled array of size 3 with 3 objects of class Stack
	 */
	public Hanoi(Stack[] stack) {
		super();
		this.stack = stack;
	}

	/**
	 * The Methode start the Hanoialgo
	 */
	public void startHanoi() {
		try {
			this.runHanoi(stack[0].getIndex(), 0, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method implements the function of hanoi.It calls itself recursively for
	 * n-1 until n == 2.
	 * 
	 * @param n:
	 *            Number of nodes to be moved
	 * @param from:
	 *            source Stack
	 * @param to:
	 *            destination Stack
	 * @throws Exception:
	 *             pop Excetion if the stack isEmpty==True
	 */
	public void runHanoi(int n, int from, int to) throws Exception {
		int one = 0;
		if ((from + 1) == to || (to + 1) == from) {
			if ((from + 1) == 3 || (to + 1) == 3) {
				one = 0;
			} else {
				one = 2;
			}
		} else if ((from + 2) == to || (to + 2) == from) {
			one = 1;
		}
		if (2 == n) {
			this.move(from, one);
			this.move(from, to);
			this.move(one, to);
		} else {
			this.runHanoi(n - 1, from, one);
			this.move(from, to);
			this.runHanoi(n - 1, one, to);
		}
	}

	/**
	 * The methode moves the top node from source Stack to destination Stack. The
	 * moved node in the destination Stack is then the top node
	 * 
	 * @param from:
	 *            source Stack
	 * @param to:
	 *            destination Stack
	 * @throws Exception:
	 *             pop Excetion if the stack isEmpty==True
	 */
	private void move(int from, int to) throws Exception {
		Node helpnode = (Node) stack[from].pop();
		this.stack[to].push(helpnode.getNumber(), helpnode.getColor());
	}

}
