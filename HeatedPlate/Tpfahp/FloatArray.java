package Tpfahp;

import java.text.DecimalFormat;

import common.HeatedPlate;

/**
 * This class simulates heated plate using double values as requested in first
 * example in the assignment.
 * 
 */
public class FloatArray extends HeatedPlate {
	float[][] oldPlate, newPlate;
	int totalSteps=1;

	public FloatArray(String args[]) {
		super(args);
	}

	@Override
	public void simulate() {
		// Create arrays oldPlate and newPlate with linear dimension d
		// plus two extra rows and columns to hold edge temperatures
		// Initialize the temperatures of the edge values and the plate itself
		// plus two extra rows and columns to hold edge temperatures
		oldPlate = new float[dimension + 2][dimension + 2];		
		newPlate = new float[dimension + 2][dimension + 2];

		// Initialize the temperatures of the edge values and the plate itself
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				if (i == 0){
					oldPlate[i][j] = (float) top;
				}
				if (i == oldPlate.length - 1){
					oldPlate[i][j] = (float) bottom;
				}
				if (j == 0){
					oldPlate[i][j] = (float) left;
				}
				if (j == oldPlate[i].length - 1){
					oldPlate[i][j] = (float) right;
				}
			}
		}
		//newPlate =  Arrays.copyOf(oldPlate,oldPlate.length);
		copyPlate(oldPlate,newPlate);
		

		// Loop until exit criteria are met, updating each newPlate cell from
		// the average temperatures of the corresponding neighbors in oldPlate
		boolean fluctuation=true;
		while (fluctuation && totalSteps<this.maxSteps) {
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0f;
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
			float[][] temp = copyPlate(newPlate,new float[dimension + 2][dimension + 2]);
			newPlate = copyPlate(oldPlate,newPlate);
			oldPlate = copyPlate(temp,oldPlate);
			totalSteps++;
		}
	}

	private float[][]  copyPlate(float[][] oldPlate,float[][] newPlate) {
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
		
		System.out.println("\nTotal Steps: "+totalSteps);
		System.out.println("Fluctuation Threshold : "+fluctuationThreshold);
	}

}
