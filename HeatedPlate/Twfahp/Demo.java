package Twfahp;
import java.util.Map;

import common.HeatedPlate;

/**
 * This program simulated HeatedPlate algorithm using floating point computations on an array of Floats
 *
 */
public class Demo {
	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate using floating point computations on an array of Floats");
			long start=System.currentTimeMillis();
			HeatedPlate demo=new WFloatArray(args);
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
