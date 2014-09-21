package Tpdahp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import common.HeatedPlate;

/**
 * This class simulates heated plate using double values as requested in first
 * example in the assignment.
 * 
 */
public class DoubleArray extends HeatedPlate {
	double[][] oldPlate, newPlate;

	public DoubleArray(String args[]) {
		super(args);
	}

	public DoubleArray(int dimension, double left, double right, double top,
			double bottom) {
		super();
		this.dimension=dimension;
		this.left=left;
		this.right=right;
		this.top=top;
		this.bottom=bottom;
	}

	@Override
	public Map<Integer,double[][]> simulate() {
		// Create arrays oldPlate and newPlate with linear dimension d
		// plus two extra rows and columns to hold edge temperatures
		// Initialize the temperatures of the edge values and the plate itself
		// plus two extra rows and columns to hold edge temperatures
		oldPlate = new double[dimension + 2][dimension + 2];		
		newPlate = new double[dimension + 2][dimension + 2];
		result=new HashMap<Integer, double[][]>();

		// Initialize the temperatures of the edge values and the plate itself
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				if (i == 0){
					oldPlate[i][j] = top;
				}
				if (i == oldPlate.length - 1){
					oldPlate[i][j] = bottom;
				}
				if (j == 0){
					oldPlate[i][j] = left;
				}
				if (j == oldPlate[i].length - 1){
					oldPlate[i][j] = right;
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
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
				}
			}
			
			fluctuation=false;
			outerloop:
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					double oldTemp=oldPlate[i][j];
					double newTemp=newPlate[i][j];
					if(newTemp-oldTemp > fluctuationThreshold) {
						fluctuation=true;
						break outerloop;
					}
				}
			}
			// Swap the plates and continue
			double[][] temp = copyPlate(newPlate,new double[dimension + 2][dimension + 2]);
			newPlate = copyPlate(oldPlate,newPlate);
			oldPlate = copyPlate(temp,oldPlate);
			result.put(iterationsCompleted-1, newPlate);
			iterationsCompleted++;
		}
		return result;
	}

	private double[][]  copyPlate(double[][] oldPlate,double[][] newPlate) {
		for (int i = 0; i < oldPlate.length; i++) {
			for (int j = 0; j < oldPlate[i].length; j++) {
				newPlate[i][j]=oldPlate[i][j];
			}
		}
		return newPlate;
	}

	@Override
	public void printResults(Map<Integer,double[][]> result) {
		System.out.println("\n------ Results -------\n");
		for(int k=0;k<result.size();k++) {
			System.out.println("------ Iteration "+k+"----\n");
			double[][] plate=result.get(k);
			for (int i = 1; i < plate.length-1; i++) {
				for (int j = 1; j < plate[i].length-1; j++) {
					DecimalFormat numFormat=new DecimalFormat("#00.##");
				    String temp = numFormat.format(plate[i][j]);
					System.out.print(temp+"\t");
				}
				System.out.print("\n\n");
			}	
			System.out.println("-----------------------");
		}
		System.out.println("-----------------------");
		
		System.out.println("\nMaximum Iterations: "+maxIterations);
		System.out.println("Iterations Completed: "+iterationsCompleted);
		System.out.println("Fluctuation Threshold : "+fluctuationThreshold);
	}
	

	public void printResults1() {
		System.out.println("\n------ Results -------\n");
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
