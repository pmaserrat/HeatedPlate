package Tpdohp;
import common.HeatedPlate;

/**
 * The algorithm without using arrays. Instead, each lattice point should be represented using an object 
 * that has attributes referring to each of its four neighboring lattice-point objects. 
 * Use doubles to hold temperature values
 *
 */
public class Demo extends HeatedPlate {
	//TODO
	
	public Demo(String args[]) {
		super(args);
	}

	@Override
	public void simulate() {		
		//TODO 
	}
	
	private void initialize() {
		//TODO
	}
	
	//TODO change the datatype for swap method parameters
	private void swap(double[][] oldPlate,double[][] newPlate) {
		//TODO
	}

	@Override
	public void printResults() {
		// TODO Print heated plate temperatures.
	}

	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate with temperatures using objects");
			HeatedPlate first=new Demo(args);
			first.simulate();
			first.printResults();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
