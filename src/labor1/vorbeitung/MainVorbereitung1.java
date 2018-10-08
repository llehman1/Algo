package labor1.vorbeitung;

public class MainVorbereitung1 {

	public static void main(String[] args) {
		String[][] A = new String[3][];
		String[] b = { "Martin Schmidt", "Jürgen Steiner", "Hans Zimmermann", "Robert Dau", "Stefan Simon",
				"Albert Hesse" };
		String[] c = { "Wolf Schöler", "Cem Kaya", "Jürgen Steiner", "Bernd Bechler", "Martin Schmidt", "Simon Otter",
				"Robert Dau" };
		String[] d = { "Stefan Simon", "Cem Kaya", "Ulf Richter", "Jürgen Steiner", "Niko Hauser", "Robert Dau" };
		A[0] = b;
		A[1] = c;
		A[2] = d;
		PeopleComparison comparison=new PeopleComparison(A);
		System.out.println(comparison.findSuspects());

	}

}
