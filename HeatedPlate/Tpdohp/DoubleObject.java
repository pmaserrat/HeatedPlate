package Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import common.HeatedPlate;

public class DoubleObject extends HeatedPlate{
	Map<String, SimpleNode> lattice;	
	public DoubleObject(String args[]) {
		super(args);
	}

	@Override
	public Map<Integer,double[][]> simulate() {
		lattice = new HashMap<String, SimpleNode>();
		result=new HashMap<Integer, double[][]>();
		SimpleNode myNode;		
		for (int i = 0; i < dimension+2; i++) {
			for (int j = 0; j < dimension+2; j++) {
				myNode = new SimpleNode(i,j);
			
				if (i == 0){
					myNode.temperature = top;
				}
				if (i == dimension + 1){
					myNode.temperature = bottom;
				}
				if (j == 0){
					myNode.temperature = left;
				}
				if (j == dimension + 1){
					myNode.temperature = right;
				}				
				lattice.put(myNode.x + "," + myNode.y, myNode);
			}
		}		
		double oldTemp;
		SimpleNode swap = null;
		boolean fluctExceeds=true;
		while(fluctExceeds && iterationsCompleted < maxIterations) {	
			fluctExceeds=false;
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					swap = lattice.get(i + "," + j);
					oldTemp = swap.temperature;
					swap.temperature = swap.updateTemp(lattice);					
					if(swap.temperature-oldTemp>fluctuationThreshold) fluctExceeds=true;
				}
			}	
			result.put(iterationsCompleted-1, convert());
			iterationsCompleted++;
		}
		return result;
	}
	
	
	class SimpleNode {
		protected int x, y;
		protected double temperature;		
		
		public SimpleNode(int x, int y) {
			this.x = x;
			this.y = y;
			temperature = 0;
		}
		
		public double updateTemp(Map<String, SimpleNode> lattice) {
			return (lattice.get(x + "," + (y + 1)).temperature +
					lattice.get(x + "," + (y - 1)).temperature +
					lattice.get((x - 1) + "," + (y)).temperature +
					lattice.get((x + 1) + "," + (y)).temperature) / 4.0;
		}
	}

	@Override
	public void printResults() {
		System.out.print("\n------ Results -------\n\n");
		for (int i = 1; i <= dimension; i++) {
			for (int j = 1; j <= dimension; j++) {
				SimpleNode node = lattice.get(i + "," + j);
				DecimalFormat numFormat=new DecimalFormat("#00.##");
				System.out.print(numFormat.format(node.temperature)+"\t");
				if(j==dimension) System.out.println("\n");
			}
		}
		System.out.println("-----------------------");		
		System.out.println("\nMaximum Iterations: "+maxIterations);
		System.out.println("Iterations Completed: "+iterationsCompleted);
		System.out.println("Fluctuation Threshold : "+fluctuationThreshold);
	}
	
	public double[][] convert() {
		double[][] result=new double[dimension][dimension];
		for (int i = 1; i <= dimension; i++) {
			for (int j = 1; j <= dimension; j++) {
				SimpleNode node = lattice.get(i + "," + j);
				result[i-1][j-1]=node.temperature;
			}
		}
		return result;
	}
}