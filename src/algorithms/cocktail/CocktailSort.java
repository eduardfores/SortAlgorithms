package algorithms.cocktail;

import java.io.IOException;
import java.util.ArrayList;

import enums.AlgorithmNames;
import utils.FileDataReader;
import utils.FileTimeWritter;

public class CocktailSort
{
	public static void cocktailSort(int a[])
	{
		boolean swapped = true;
		int start = 0;
		int end = a.length;

		while (swapped == true)
		{
			swapped = false;
			for (int i = start; i < end - 1; ++i)
			{
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false)
				break;

			swapped = false;
			end = end - 1;

			for (int i = end - 1; i >= start; i--)
			{
				if (a[i] > a[i + 1])
				{
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}
			start = start + 1;
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
					
					cocktailSort(arr);
					
					endTime = System.nanoTime();
					timeElapsed.add(endTime - startTime);
					
					fileLenght *= 10;
				}
				FileTimeWritter.writeReults(timeElapsed, AlgorithmNames.COCKTAILSORT.getName(), "Run"+(j+1));
				
				fileLenght = 10;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}

