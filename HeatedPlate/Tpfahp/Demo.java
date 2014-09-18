package Tpfahp;

import common.HeatedPlate;

/**
 * The program simulates HeatedPlate algorithm with floating point computations on an array of Floats (Twfahp).
 */
public class Demo {
	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate with floating point computations on an array of Floats (Twfahp)");
			long start=System.currentTimeMillis();
			HeatedPlate demo=new FloatArray(args);
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
