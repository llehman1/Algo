package labor3.vorbereitung;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testStack {
	private Stack stack;
	private Object[][] more;

	@BeforeEach
	void creatStack() {
		this.more = new Object[][] { { Color.blue, 47 }, { Color.red, 50 }, { Color.green, 13 }, { Color.black, 93 } };
		this.stack = new Stack((int) more[0][1], (Color) more[0][0]);
	}

	@Test
	void isEmptyTrue() {
		// teste ob is empty im leeren stack true zurück gibt
		assertTrue(new Stack().isEmpty());
	}

	@Test
	void isEmptyFalse() {
		// test ob im stack mit einem node false zurück gegeben wird
		assertFalse(this.stack.isEmpty());
	}

	@Test
	void isEmptyMore() {
		this.addNodes();
		for (int i = 0; i < this.more.length; i++) {
			try {
				this.stack.pop();
				// testet ob bei pop von 0 - (more.length-1) immer false ist
				if (i != (this.more.length - 1) && this.stack.isEmpty() == true) {
					// wenn nicht test falsch
					assertTrue(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// muss true sein wenn so viel mal pop aufgerufen worden ist wie more.length
		assertTrue(this.stack.isEmpty());
	}

	@Test
	void testOnePop() {
		INodeUser node;
		try {
			node = this.stack.pop();
			// teste pop an einem node
			assertTrue(node.getColor() == (Color) more[0][0] && node.getNumber() == (int) more[0][1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testException() {
		// prüft ob exception geworfen wird wenn Stack leer ist
		assertThrows(Exception.class, () -> {
			new Stack().pop();
		});
	}

	@Test
	void moreException() {
		// stack wird befüllt
		this.addNodes();
		// stack wird wieder geleert
		for (int i = 0; i < this.more.length; i++) {
			try {
				this.stack.pop();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Stack muss leer sein überprüfen ob beim pop exception geworfen wird
		this.testException();
	}

	@Test
	void testOnePush() {
		// fügt ein node hinzu
		this.stack.push((int) this.more[1][1], (Color) this.more[1][0]);
		try {
			INodeUser node = this.stack.pop();
			// überprüft ob das hinzugefügte objekt das oberste ist
			assertTrue(node.getColor() == (Color) this.more[1][0] && node.getNumber() == (int) this.more[1][1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void morePopandPush() {
		// füght viele nodes in Stack ein
		this.addNodes();
		// stack wird wieder pro schleifen durchgang um eine geleert
		for (int i = (this.more.length - 1); i > -1; i--) {
			try {
				INodeUser node = this.stack.pop();
				// überprüft ob push und pop richtig arbeiten indem die richtige reihenfolgen
				// eingehalten wird
				if (node.getColor() != this.more[i][0] || node.getNumber() != (int) this.more[i][1]) {
					assertTrue(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void addNodes() {
		// fügt die ganze array als einzelne nodes dem stack ein
		for (int i = 1; i < this.more.length; i++) {
			this.stack.push((int) this.more[i][1], (Color) this.more[i][0]);
		}
	}

}
