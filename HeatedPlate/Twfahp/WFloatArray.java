package Twfahp;

import java.text.DecimalFormat;

import common.HeatedPlate;

public class WFloatArray extends HeatedPlate {
	Float[][] oldPlate, newPlate;

	public WFloatArray(String args[]) {
		super(args);
	}

	@Override
	public void simulate() {
		// Create arrays oldPlate and newPlate with linear dimension d
		// plus two extra rows and columns to hold edge temperatures
		// Initialize the temperatures of the edge values and the plate itself
		// plus two extra rows and columns to hold edge temperatures
		oldPlate = new Float[dimension + 2][dimension + 2];		
		newPlate = new Float[dimension + 2][dimension + 2];

		// Initialize the temperatures of the edge values and the plate itself
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				oldPlate[i][j]=new Float(0);
				if (i == 0){
					oldPlate[i][j] = new Float(top);
				}
				if (i == oldPlate.length - 1){
					oldPlate[i][j] = new Float(bottom);
				}
				if (j == 0){
					oldPlate[i][j] = new Float(left);
				}
				if (j == oldPlate[i].length - 1){
					oldPlate[i][j] = new Float(right);
				}
			}
		}
		//newPlate =  Arrays.copyOf(oldPlate,oldPlate.length);
		copyPlate(oldPlate,newPlate);
		

		// Loop until exit criteria are met, updating each newPlate cell from
		// the average temperatures of the corresponding neighbors in oldPlate
		boolean fluctuation=true;
		while (fluctuation && iterationsCompleted<this.maxIterations) {
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / new Float(4.0);
				}
			}
			
			fluctuation=false;
			outerloop:
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					float oldTemp=oldPlate[i][j];
					float newTemp=newPlate[i][j];
					if(newTemp-oldTemp > (float) fluctuationThreshold) {
						fluctuation=true;
						break outerloop;
					}
				}
			}
			// Swap the plates and continue
			Float[][] temp = copyPlate(newPlate,new Float[dimension + 2][dimension + 2]);
			newPlate = copyPlate(oldPlate,newPlate);
			oldPlate = copyPlate(temp,oldPlate);
			iterationsCompleted++;
		}
	}

	private Float[][]  copyPlate(Float[][] oldPlate,Float[][] newPlate) {
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				newPlate[i][j]=oldPlate[i][j];
			}
		}
		return newPlate;
	}

	@Override
	public void printResults() {
		System.out.println("\n------ Results -------");
		for (int i = 1; i < oldPlate.length-1; i++) {
			for (int j = 1; j < oldPlate[i].length-1; j++) {
				DecimalFormat numFormat=new DecimalFormat("#00.##");
			    String temp = numFormat.format(oldPlate[i][j]);
				System.out.print(temp+"\t");
			}
			System.out.print("\n\n");
		}		
		System.out.println("-----------------------");
		
		System.out.println("\nMaximum Iterations: "+maxIterations);
		System.out.println("Iterations Completed: "+iterationsCompleted);
		System.out.println("Fluctuation Threshold : "+fluctuationThreshold);
	}

}
