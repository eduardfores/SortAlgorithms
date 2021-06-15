package enums;

public enum AlgorithmNames {
	BUBBLESORT("bubbleSort"),
	COCKTAILSORT("cocktailSort"),
	INSERTATIONSORT("insertationSort"),
	BUCKETSORT("bucketSort"),
	COUNTINGSORT("countingSort"),
	MERGESORT("mergeSort"),
	RADIXSORT("radixSort");
	
	private String name;
	
	private AlgorithmNames(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
