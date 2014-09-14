package Tpfahp;

import common.HeatedPlate;

/**
 * The program simulates HeatedPlate algorithm using floating point computations on an array of floats.
 */
public class Demo extends HeatedPlate{

	float oldlate;
	float newPlate;
	
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
	private void swap(float[][] oldPlate,float[][] newPlate) {
		//TODO
	}

	@Override
	public void printResults() {
		// TODO Print heated plate temperatures.
	}

	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate with temperatures using floats");
			HeatedPlate first=new Demo(args);
			first.simulate();
			first.printResults();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
