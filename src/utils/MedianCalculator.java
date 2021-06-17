package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import enums.AlgorithmNames;

public class MedianCalculator {

	private static final int NUM_ALGORITHM=7;
	private static final int NUM_TEST=5;
	private static final int NUM_RUNS=3;
	private static final String  DELIMITER = " ";
	
	public static void calculate() throws IOException {
		BufferedReader brJava = null;
		BufferedReader brPython = null;
		BufferedWriter bw = null;
		String line = null;
		String[] splitedLine = null;
		
		double mediaJava = 0.0;
		double mediaPython = 0.0;
		int length = 10;
		
		AlgorithmNames[] algorithmNames = AlgorithmNames.values();
		Map<Integer, ArrayList<Double>> javaInfo = new HashMap<Integer, ArrayList<Double>>();
		Map<Integer, ArrayList<Double>> pythonInfo = new HashMap<Integer, ArrayList<Double>>();
		ArrayList<Double> javaMedianList = new ArrayList<Double>();
		ArrayList<Double> pythonMedianList = new ArrayList<Double>();
		
		for(int i=0; i<NUM_TEST; i++) {
			javaInfo.put(length, new ArrayList<Double>());
			pythonInfo.put(length, new ArrayList<Double>());
			length *= 10;
		}
		
		length = 10;
		
		try {
			
			for( int i=0; i<NUM_ALGORITHM; i++) {
				for( int j=0; j<NUM_RUNS; j++) {
					brJava = new BufferedReader(new FileReader(new File("Results/"+algorithmNames[i].getName()+"-Run"+(j+1)+".txt")));
					brPython = new BufferedReader(new FileReader(new File("ResultPython/"+algorithmNames[i].getName()+"-Run"+(j+1)+".txt")));
					
					while(null != (line = brJava.readLine())){
						splitedLine=line.split(DELIMITER);
						if(splitedLine[3].equals("nanoseconds")) {
							javaInfo.get(Integer.parseInt(splitedLine[6])).add(Double.parseDouble(splitedLine[8]));
						}
					}
					
					while(null != (line = brPython.readLine())){
						splitedLine=line.split(DELIMITER);
						if(splitedLine[3].equals("nanoseconds")) {
							pythonInfo.get(Integer.parseInt(splitedLine[6])).add(Double.parseDouble(splitedLine[8]));
						}
					}
					brJava.close();
					brPython.close();
				}
				
				for(int j=0; j<NUM_TEST; j++) {
					ArrayList<Double> javaAux = javaInfo.get(length);
					ArrayList<Double> pythonAux = pythonInfo.get(length);
					
					for (int k=0; k < javaAux.size(); k++) {
						 mediaJava = mediaJava + javaAux.get(k);
						 mediaPython = mediaPython + pythonAux.get(k); 
					}
					
					mediaJava = mediaJava / javaAux.size();
					mediaPython = mediaPython / pythonAux.size();
					
					//Nanoseconds to microseconds
					javaMedianList.add(mediaJava/1000);
					pythonMedianList.add(mediaPython/1000);
					
					mediaJava = 0.0;
					mediaPython = 0.0;
					length *= 10;
				}
				
				length = 10;
				
				bw = new BufferedWriter(new FileWriter(new File("Results/"+algorithmNames[i].getName()+"-MedianResult.txt")));
				
				for(int j=0; j<NUM_TEST; j++) {
					System.out.println("Median result for test "+length+": Java_"+javaMedianList.get(j)+" Python_"+pythonMedianList.get(j));
					bw.write("Median result for test "+length+": Java_"+javaMedianList.get(j)+" Python_"+pythonMedianList.get(j)+"\n");
					length *= 10;
				}
				
				bw.close();
				
				length = 10;
			}
			
		}finally {
			if( null != brJava) {
				brJava.close();
			}
			if( null != brPython) {
				brPython.close();
			}
			if( null != bw) {
				bw.close();
			}
		}
	}
	
	public static void main(String args[]) {
		try {
			calculate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
