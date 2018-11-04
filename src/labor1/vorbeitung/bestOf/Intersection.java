package labor1.vorbeitung.bestOf;

public class Intersection implements IComparsionPeople {

	private ISort sort;

	public Intersection(ISort sort) {
		super();
		this.sort = sort;
	}

	@Override
	public void findSuspects() {
		String[] result = null;
		this.sort.sortStart();
		String[][] peopleArray = (String[][]) this.sort.getNames();
		try {
			result = getIntersection(peopleArray[0], peopleArray[1]);
			if (peopleArray.length > 2) {
				for (int index = 2; index < peopleArray.length; index++) {
					result = getIntersection(result, peopleArray[index]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.toStringName(result);
	}

	public String[] getIntersection(String[] first, String[] second) throws Exception {
		String[] result;
		if (first == null || second == null) {
			throw new Exception("in the two-dimensional-Array attribute peopleAray is a String Array NULL : "
					+ this.sort.toString());
		}
		if (first.length > second.length) {
			result = new String[second.length];
		} else {
			result = new String[first.length];
		}
		int indexResult = 0;
		for (String name : first) {
			for (String name2 : second) {
				if (name == name2) {
					result[indexResult] = name;
					indexResult++;
				}
			}
		}
		return result;
	}

	private void toStringName(String[] name) {
		String stringName = "Name der Verdächtigen: ";
		if (name[0] == null) {
			stringName += "keine Schnittmenge gefunden";
		} else {
			stringName += name[0];
			for (int index = 1; name.length > index; index++) {
				if (name[index] != null) {
					stringName += ", " + name[index];
				}
			}
		}
		System.out.println(stringName);
	}

}
