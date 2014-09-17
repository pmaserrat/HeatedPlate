package Twfahp;

import common.HeatedPlate;

public class WFloatArray extends HeatedPlate {
	Float[][] oldPlate, newPlate;
	
	public WFloatArray(String args[]) {
		super(args);
	}
	
	@Override
	public void simulate() {
		//Changing the int values into usable Floats
		Float topFloat = new Float(top);
		Float bottomFloat = new Float(bottom);
		Float leftFloat = new Float(left);
		Float rightFloat = new Float(right);
		// Create arrays oldPlate and newPlate with linear dimension d
		// plus two extra rows and columns to hold edge temperatures
		// Initialize the temperatures of the edge values and the plate itself
		// plus two extra rows and columns to hold edge temperatures
		oldPlate = new Float[dimension + 2][dimension + 2];
		newPlate = new Float[dimension + 2][dimension + 2];

		// Initialize the temperatures of the edge values and the plate itself
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				if (i == 0){
					oldPlate[i][j] = topFloat;
				}
				if (i == oldPlate.length - 1){
					oldPlate[i][j] = bottomFloat;
				}
				if (j == 0){
					oldPlate[i][j] = leftFloat;
				}
				if (j == oldPlate[i].length - 1){
					oldPlate[i][j] = rightFloat;
				}
			}
		}
		newPlate = oldPlate;

		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		int count = 0;
		while (count < 200) {
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					newPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4;
				}
			}
			// Swap the plates and continue
			Float[][] temp = newPlate;
			newPlate = oldPlate;
			oldPlate = temp;
			count++;
		}

	}

	@Override
	public void printResults() {
		// Print heated plate temperatures excluding edges.
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				System.out.print(Math.round(oldPlate[i][j]) + " ");
			}
			System.out.print("\n");
		}
	}
}
