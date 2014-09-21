package Tpdahp;

import java.util.Map;

import common.HeatedPlate;

/**
 * 
 * This class is Demo of the simulation using double values as requested in first example in the assignment.
 * 
 */

public class Demo {
	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate with temperatures in doubles");
			long start=System.currentTimeMillis();
			HeatedPlate demo=new DoubleArray(args);
			Map<Integer,double[][]> result=demo.simulate();
			long end=System.currentTimeMillis();
			demo.printResults(result);
			demo.printPerformanceReport(end-start);
		}
		catch(java.lang.OutOfMemoryError e) {
			System.out.println("System ran out of memory. Your plate is probably too big.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
