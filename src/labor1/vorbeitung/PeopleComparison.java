package labor1.vorbeitung;

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
	 * {@link #sortSize()}
	 * 
	 * @param peopleArray
	 *            two-dimensional String Array with people names
	 */
	public PeopleComparison(String[][] peopleArray) {
		super();
		this.peopleArray = peopleArray;
		this.sortSize();
	}

	/**
	 * The method generates the intersection of the attribut peopleArray
	 * 
	 * @return returns a string array with the intersection
	 */
	public String[] findSuspects() {
		String[] result = this.getIntersection(this.peopleArray[0], this.peopleArray[1]);
		if (this.peopleArray.length > 2) {
			for (int index = 2; index < this.peopleArray.length; index++) {
				result = this.getIntersection(result, this.peopleArray[index]);
			}
		}
		return result;
	}

	/**
	 * The methode sorts the attribute by length of the string arrays. In ascending
	 * order.Index = 0 for the least length String array
	 */
	private void sortSize() {
		int historyindex = 0;
		int size = 0;
		String[][] newArray = new String[this.peopleArray.length][];
		int indexNewArray = 0;
		for (int index = 0; index < this.peopleArray.length; index++) {
			if ((peopleArray[index] != null) && ((peopleArray[index].length < size) || (size == 0))) {
				size = this.peopleArray[index].length;
				historyindex = index;

			}
			if (index == (this.peopleArray.length - 1)) {
				newArray[indexNewArray] = this.peopleArray[historyindex];
				this.peopleArray[historyindex] = null;
				indexNewArray++;
				size = 0;
				index = 0;
				if (indexNewArray == (newArray.length)) {
					break;
				}
			}
		}
		this.peopleArray = newArray;
	}

	/**
	 * The Methode generates the intersection of the parameters first and second
	 * 
	 * @param first
	 *            String Array
	 * @param second
	 *            String Arry
	 * @return returns the intersection of the two parameters in a string array
	 */
	private String[] getIntersection(String[] first, String[] second) {
		String[] result;
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

	public String[][] getPeopleArray() {
		return peopleArray;
	}
}
