package labor1.vorbeitung.korrection;

/**
 * 
 * @author larslehmann
 * @since 2018-10-08
 */
public class PeopleComparison {
	/** two-dimensional array of people who were at the crime scenes */
	private String[][] peopleArray;

	/**
	 * This Constructor Initializes the attribute peopleArray and execute
	 * 
	 * @param peopleArray
	 *            two-dimensional String Array with people names
	 */
	public PeopleComparison(String[][] peopleArray) {
		super();
		this.peopleArray = peopleArray;
	}

	/**
	 * The method generates the intersection of the attribut peopleArray. The first
	 * step is to execute getIntersection
	 * {@link #getIntersection(String[], String[])} with the value peopleArray[0]
	 * and peopleArray[0].The result of the method call is stored in the local
	 * variable result.Next, the top step is repeated with the parameter result and
	 * the next string array-object of peopleArray.This is repeated until the method
	 * is at the end of peopleArray
	 * 
	 * @return returns a string with the intersection
	 */
	public String findSuspects() {
		String[] result = null;
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
		return toStringName(result);
	}

	/**
	 * The Methode generates the intersection of the parameters first and second.
	 * All strings from array second and first are compared. The result is the
	 * intersection of the arrays
	 * 
	 * @param first
	 *            String Array with Names
	 * @param second
	 *            String Array with Names
	 * @return returns the intersection of the two parameters in a string array
	 * @throws Exception
	 *             If an instance is null in the two-dimitional-array attribute
	 *             peopleArray. The exception returns the content of the
	 *             two-dimitional-array attribute peopleArray.
	 */
	private String[] getIntersection(String[] first, String[] second) throws Exception {
		String[] result;
		if (first == null || second == null) {
			throw new Exception(
					"in the two-dimensional-Array attribute peopleAray is a String Array NULL : " + toString());
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

	/**
	 * The methode converts a normel String Array into a string
	 * 
	 * @param name
	 *            String array with names
	 * @return return a String with name the intersection
	 */
	private String toStringName(String[] name) {
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
		return stringName;
	}

	/**
	 * Convert the attribute peopleArray (Two-Dimensional-Array) into a String
	 * 
	 * @return return a String with all name of Two-Dimensional-Array attribute
	 *         peopleArray
	 */
	public String toString() {
		String result = "PeopleArray=[";
		for (int index = 0; index < peopleArray.length; index++) {
			if (index != 0) {
				result += ", ";
			}
			result += "[";
			if (peopleArray[index] == null) {
				result += "NULL";
			} else {
				for (int index2 = 0; index2 < peopleArray[index].length; index2++) {
					if (index2 != 0) {
						result += ", ";
					}
					result += '"' + peopleArray[index][index2] + '"';
				}
			}
		}
		return result + "]]";
	}
}
