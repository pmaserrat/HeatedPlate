package Twfahp;
import common.HeatedPlate;

/**
 * This program simulated HeatedPlate algorithm using floating point computations on an array of Floats
 *
 */
public class Demo extends HeatedPlate{

		Float oldlate;
		Float newPlate;
		
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
		private void swap(Float[][] oldPlate,Float[][] newPlate) {
			//TODO
		}

		@Override
		public void printResults() {
			// TODO Print heated plate temperatures.
		}

		public static void main(String[] args) {
			try {
				System.out.println("Running first Demo that simulates Heated Plate with temperatures using Floats");
				HeatedPlate first=new Demo(args);
				first.simulate();
				first.printResults();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
