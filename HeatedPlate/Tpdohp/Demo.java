package Tpdohp;
import java.util.Map;

import common.HeatedPlate;

/**
 * The algorithm without using arrays. Instead, each lattice point should be represented using an object 
 * that has attributes referring to each of its four neighboring lattice-point objects. 
 * Use doubles to hold temperature values
 *
 */
public class Demo {
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
			System.out.println("Demo of DoubleObject Heated Plate Simulation. (Tpdohp)");
			HeatedPlate demo=new DoubleObject(args);
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
