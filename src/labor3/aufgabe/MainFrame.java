package labor3.aufgabe;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <h1>The Main class</h1>
 * <p>
 * It creates the graphical window
 * </p>
 * 
 * @author Lars Lehmann and Alessio Torzi
 * @since 2018-11-26
 */
public class MainFrame {

	private JFrame window;
	private JPanel subPanel;
	private Controller controller;

	public MainFrame() throws Exception {
		super();
		// create the new Controller the Controller create three Stacks the first(id=0)
		// gets the values ​​of the first parameter
		this.controller = new Controller(new Object[][] { { 1, Color.blue }, { 2, Color.green }, { 3, Color.yellow },
				{ 4, Color.cyan }, { 5, Color.orange }, { 6, Color.pink }, { 7, Color.black } }, this);
		// create the window and set the window Titel
		this.window = new JFrame("Türme von Hanoi");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the default size of the window
		this.window.setSize(700, 700);
		// add the Panel for the view
		this.window.add(subPanel);
		this.window.setVisible(true);
		// Program Sleep to recognize the initial values
		Thread.sleep(5000);
		// create the new object for the Hanoi algo
		Hanoi hanoi = new Hanoi(this.controller.getStack());
		// start the hano algo
		hanoi.startHanoi();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		MainFrame frame = new MainFrame();

	}

	/**
	 * The methode initializes the attribute subpanel
	 * 
	 * @param panel:
	 *            object of the class JPanel
	 */
	public void creatJPanel(JPanel panel) {
		this.subPanel = panel;
	}

}
