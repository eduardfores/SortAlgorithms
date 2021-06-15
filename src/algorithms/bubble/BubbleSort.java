package algorithms.bubble;

import java.io.IOException;
import java.util.ArrayList;

import enums.AlgorithmNames;
import utils.FileDataReader;
import utils.FileTimeWritter;

public class BubbleSort{
	
	public static void bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
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
					
					bubbleSort(arr);
					
					endTime = System.nanoTime();
					timeElapsed.add(endTime - startTime);
					
					fileLenght *= 10;
				}
				FileTimeWritter.writeReults(timeElapsed, AlgorithmNames.BUBBLESORT.getName(), "Run"+(j+1));
				
				fileLenght = 10;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}

