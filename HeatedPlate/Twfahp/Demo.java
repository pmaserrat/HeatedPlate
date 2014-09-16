package Twfahp;
import common.HeatedPlate;

/**
 * This program simulated HeatedPlate algorithm using floating point computations on an array of Floats
 *
 */
public class Demo {
	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate using floating point computations on an array of Floats");
			HeatedPlate demo=new WFloatArray(args);
			demo.simulate();
			demo.printResults();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
