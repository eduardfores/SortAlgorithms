package algorithms.counting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import enums.AlgorithmNames;
import utils.FileDataReader;
import utils.FileTimeWritter;

class CountingSort {
	
	public static void countingSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
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
					
					countingSort(arr);
					
					endTime = System.nanoTime();
					timeElapsed.add(endTime - startTime);
					
					fileLenght *= 10;
				}
				FileTimeWritter.writeReults(timeElapsed, AlgorithmNames.COUNTINGSORT.getName(), "Run"+(j+1));
				
				fileLenght = 10;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}

