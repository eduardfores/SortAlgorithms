package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTimeWritter {

	public static void writeReults(ArrayList<Long> timeElapsed, String ... args) throws IOException {
		
		BufferedWriter bw = null;
		int fileLength=10;
		String nameAlgorithm = args[0];
		String sufix = args[1];
		
		try {
			if( null == sufix ) {
				bw = new BufferedWriter(new FileWriter(new File("Results/"+nameAlgorithm+".txt")));
			} else {
				bw = new BufferedWriter(new FileWriter(new File("Results/"+nameAlgorithm+"-"+sufix+".txt")));
			}
			
			for( Long l : timeElapsed) {
				bw.write("Execution time in nanoseconds of "+nameAlgorithm+" "+fileLength+" : " +l+"\n");
				bw.write("Execution time in milliseconds of "+nameAlgorithm+" "+fileLength+" : " +l/1000000+"\n");
				fileLength *= 10;
			}
			
		} finally {
			if(null != bw) {
				bw.close();
			}
			fileLength = 10;
		}
		
	}
}
