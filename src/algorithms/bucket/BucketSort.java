package algorithms.bucket;

import java.io.IOException;
import java.util.ArrayList;

import enums.AlgorithmNames;
import utils.FileDataReader;
import utils.FileTimeWritter;

public class BucketSort {
	static int[] bucketSort(int[] array, int maxValue) {

		int[] Bucket = new int[maxValue + 1];

		int[] sorted_array = new int[array.length];
		for (int i = 0; i < array.length; i++)
			Bucket[array[i]]++;
		int outPos = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				sorted_array[outPos++] = i;
		
		return sorted_array;
	}

	static int maxValue(int[] array) {
		int maxValue = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] > maxValue)
				maxValue = array[i];
		return maxValue;
	}
	
    public static void main(String args[])
    {
		long startTime = 0;
		long endTime = 0;
		ArrayList<Long> timeElapsed = null;
		int fileLenght = 10;
		
		try {
			for( int j=0; j < 3; j++) {
				System.out.println("Run"+(j+1));
				timeElapsed = new ArrayList<Long>();
				
				for( int i=0; i < 5; i++) {
					System.out.println("test with lenght = "+ fileLenght);
					ArrayList<Integer> list = FileDataReader.readDataFile(fileLenght);
					

					int arr[] = list.stream().mapToInt( x -> x).toArray();
					
					startTime = System.nanoTime();
					
					bucketSort(arr, maxValue(arr));
					
					endTime = System.nanoTime();
					timeElapsed.add(endTime - startTime);
					
					fileLenght *= 10;
				}
				FileTimeWritter.writeReults(timeElapsed, AlgorithmNames.BUCKETSORT.getName(), "Run"+(j+1));
				
				fileLenght = 10;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
