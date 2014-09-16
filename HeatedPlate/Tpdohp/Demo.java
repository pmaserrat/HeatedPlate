package Tpdohp;
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
			System.out.println("Running first Demo that simulates Heated Plate using an object that has attributes referring to each of its four neighboring lattice-point objects. Use doubles to hold temperature values (Tpdohp)");
			HeatedPlate demo=new DoubleObject(args);
			demo.simulate();
			demo.printResults();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
