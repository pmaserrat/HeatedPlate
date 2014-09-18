package Tpdahp;

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
			demo.simulate();
			long end=System.currentTimeMillis();
			demo.printResults();
			demo.printPerformanceReport(end-start);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
