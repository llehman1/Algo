package labor1.vorbeitung.bestOf;

public class MergSortDimTwo extends Sort{

	public MergSortDimTwo(String[][] sortA) {
		super(sortA);
	}

	@Override
	public String[][] sortStart() {
		this.sort(0, this.peopleNames.length-1);
		return peopleNames;
	}

	private void sort(int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {
			this.sort(start, mid);
			this.sort((mid + 1), end);
			this.sortMerg(start, mid, end);
		}
	}

	private void sortMerg(int start, int mid, int end) {
		int startI1 = start;
		int startI2 = mid + 1;
		int endI1 = mid;
		int endI2 = end;
		String[][] result = new String[(end - start)+1][];
		for (int i = 0; i < result.length; i++) {
			if ((startI2>endI2 || this.peopleNames[startI1].length <= this.peopleNames[startI2].length) && startI1 <= endI1) {
				result[i] = this.peopleNames[startI1];
				startI1++;
			} else if ((startI1>endI1 ||this.peopleNames[startI2].length < this.peopleNames[startI1].length )&& startI2 <= endI2) {
				result[i] = this.peopleNames[startI2];
				startI2++;
			}
		}
		int indexResult = 0;
		for (int i2 = start; i2 <= end; i2++) {
			this.peopleNames[i2] = result[indexResult];
			indexResult++;
		}
	}



}
