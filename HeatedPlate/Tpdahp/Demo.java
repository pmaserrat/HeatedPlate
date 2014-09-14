package Tpdahp;

import common.HeatedPlate;

/**
 * 
 * @author Uma Gaddameedi
 * This class is Demo of the simulation using double values as requested in first example in the assignment.
 *
 */

public class Demo extends HeatedPlate {
	double[][] oldPlate,newPlate;
	
	public Demo(String args[]) {
		super(args);
	}

	@Override
	public void simulate() {		
		// Create arrays oldPlate and newPlate with linear dimension d
	    //   plus two extra rows and columns to hold edge temperatures
	    // Initialize the temperatures of the edge values and the plate itself
	    initialize();

	      // Loop until exit criteria are met, updating each newPlate cell from the
	      //   average temperatures of the corresponding neighbors in oldPlate
	      int count=0;
	      while (count<200) {
	        for (int i = 1; i <= dimension; i++) {
	          for (int j = 1; j <= dimension; j++) {
	            newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j] +
	                              oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
	          }
	        }
	        // Swap the plates and continue
	        swap(oldPlate, newPlate);
	        count++;
	      }

		
	}
	
	private void initialize() {
		//   plus two extra rows and columns to hold edge temperatures
	     oldPlate = new double[dimension + 2][dimension + 2];
	     newPlate = new double[dimension + 2][dimension + 2];

	    // Initialize the temperatures of the edge values and the plate itself
	    for(int i=0;i<oldPlate.length;i++) {	    	
	    	for(int j=0;j<oldPlate[i].length;j++) {
	    		if(i==0) oldPlate[i][j]=top;
	    		if(i==oldPlate.length-1) oldPlate[i][j]=bottom;
	    		
	    		if(j==0) oldPlate[i][j]=left;
	    		if(j==oldPlate[i].length-1) oldPlate[i][j]=right;
	    	}
	    }
	    newPlate=oldPlate;
	}
	
	private void swap(double[][] oldPlate,double[][] newPlate) {
		double[][] temp=newPlate;
		newPlate=oldPlate;
		oldPlate=temp;
	}

	@Override
	public void printResults() {
		// TODO Print heated plate temperatures ixcluding edges.
	    for(int i=0;i<oldPlate.length;i++) {
	    	for(int j=0;j<oldPlate[i].length;j++) {
	    		System.out.print(Math.round(oldPlate[i][j])+" ");
	    	}
	    	System.out.print("\n");
	    }
	}

	public static void main(String[] args) {
		try {
			System.out.println("Running first Demo that simulates Heated Plate with temperatures in doubles");
			HeatedPlate first=new Demo(args);
			first.simulate();
			first.printResults();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
