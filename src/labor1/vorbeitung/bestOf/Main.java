package labor1.vorbeitung.bestOf;

public class Main {

	public static void main(String[] args) {
		String[][] names = new String[][] {
				{ "Martin Schmidt", "Jürgen Steiner", "Hans Zimmermann", "Robert Dau", "Stefan Simon", "Albert Hesse" },
				{"Lars Lehmann","Otto","Dieter"},
				{ "Wolf Schöler", "Cem Kaya", "Jürgen Steiner", "Bernd Bechler", "Martin Schmidt", "Simon Otter",
						"Robert Dau" },
				{ "Stefan Simon", "Cem Kaya", "Ulf Richter", "Jürgen Steiner", "Niko Hauser", "Robert Dau" },{ "Stefan Simon", "Cem Kaya", "Ulf Richter", "Jürgen Steiner", "Niko Hauser", "Robert Dau" } };
		IComparsionPeople inc= new Intersection(new MergSortDimTwo(names));
		inc.findSuspects();

	}

}
