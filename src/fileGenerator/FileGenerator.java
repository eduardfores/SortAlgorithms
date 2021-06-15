package fileGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
	
	public static void fileGenerator(int randomsNum) throws IOException{		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(new File("Data/test"+randomsNum+".txt")));
			
			  for(int i=0; i<randomsNum; i++) {
				  bw.write(String.valueOf(generateNumber())+";");  
			  }
		} finally {
			if( null != bw)
				bw.close();
		}
	}
	
	public static int generateNumber() {
		Random r = new Random() ;
		return r.nextInt(100000);
	}
	
	public static void main(String args[]) {
		try {
			System.out.println("creating test10.txt");
			fileGenerator(10);
			System.out.println("creating test100.txt");
			fileGenerator(100);
			System.out.println("creating test1000.txt");
			fileGenerator(1000);
			System.out.println("creating test10000.txt");
			fileGenerator(10000);
			System.out.println("creating test100000.txt");
			fileGenerator(100000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
