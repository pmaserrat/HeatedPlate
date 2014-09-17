package Tpfahp;

import common.HeatedPlate;

public class FloatArray extends HeatedPlate {
	float[][] oldPlate, newPlate;
	
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
				if (i == 0)
					oldPlate[i][j] = top;
				if (i == oldPlate.length - 1)
					oldPlate[i][j] = bottom;

				if (j == 0)
					oldPlate[i][j] = left;
				if (j == oldPlate[i].length - 1)
					oldPlate[i][j] = right;
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
			float[][] temp = newPlate;
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
