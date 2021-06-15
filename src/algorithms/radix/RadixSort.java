package algorithms.radix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import enums.AlgorithmNames;
import utils.FileDataReader;
import utils.FileTimeWritter;

class Radix {
	 
    public static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    public static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    public static void radixsort(int arr[], int n)
    {
        int m = getMax(arr, n);
 
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
 // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
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
					
					radixsort(arr, arr.length);
					
					endTime = System.nanoTime();
					timeElapsed.add(endTime - startTime);
					
					fileLenght *= 10;
				}
				FileTimeWritter.writeReults(timeElapsed, AlgorithmNames.RADIXSORT.getName(), "Run"+(j+1));
				
				fileLenght = 10;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
