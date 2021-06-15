package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileDataReader<E> {

	private static final String  DELIMITER = ";";
	
	public static ArrayList<Integer> readDataFile(int fileLenght) throws IOException{
		
		BufferedReader br = null;
		String line = null;
		StringTokenizer tokenizator = null;
		ArrayList<Integer> list = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("Data/test"+fileLenght+".txt")));
			list = new ArrayList<Integer>();
			
			line = br.readLine();
			tokenizator = new StringTokenizer(line, DELIMITER);
			
			while(tokenizator.hasMoreTokens()) {				
				list.add(Integer.parseInt(tokenizator.nextToken()));
			}
			
		} finally {
			if ( null != br) {
				br.close();
			}
		}
		
		return list;
	}
}
