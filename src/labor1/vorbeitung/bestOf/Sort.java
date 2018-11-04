package labor1.vorbeitung.bestOf;

public class Sort implements ISort<String[][]>{
	protected String[][] peopleNames;
	
	

	public Sort(String[][] peopleNames) {
		super();
		this.peopleNames = peopleNames.clone();
	}

	@Override
	public String[][] getNames() {
		return this.peopleNames;
	}

	@Override
	public String[][] sortStart() {
		return null;
	}
	public String toString() {
		String result = "PeopleArray=[";
		for (int index = 0; index < this.peopleNames.length; index++) {
			if (index != 0) {
				result += ", ";
			}
			result += "[";
			if (this.peopleNames[index] == null) {
				result += "NULL";
			} else {
				for (int index2 = 0; index2 < this.peopleNames[index].length; index2++) {
					if (index2 != 0) {
						result += ", ";
					}
					result += '"' + this.peopleNames[index][index2] + '"';
				}
			}
		}
		return result + "]]";
	}
	

}
