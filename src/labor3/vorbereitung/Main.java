package labor3.vorbereitung;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		// Stack stack =new Stack(47,Color.blue);
		try {
			// System.out.println(stack.pop().toString());
			stack.push(10, Color.black);
			stack.push(10, Color.red);
			System.out.println(stack.isEmpty());
			stack.push(23, Color.green);
			System.out.println(stack.pop().toString());
			System.out.println(stack.pop().toString());
			System.out.println(stack.pop().toString());
			System.out.println(stack.pop().toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void addLeererStack() {
		//erstellt leerer Stack 
		Stack stack = new Stack();
		// muss true zurückgeben stack ist leer
		System.out.println(stack.isEmpty());
		//push im leeren stack
		stack.push(10, Color.black);
		//muss false sein Stack hat ein node
		System.out.println(stack.isEmpty());
		try {
			//muss das oben erstellte Object ausgeben 
			System.out.println(stack.pop().toString());
			// muss true zurückgeben stack ist leer
			System.out.println(stack.isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testfunktionStack() {
		//erstelle Stack mit dem inhalt des parameters 
		Stack stack =new Stack(47,Color.blue);
		//muss eines zurück geben 
		System.out.println(stack.isEmpty());
	}

}
