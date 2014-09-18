package Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import common.HeatedPlate;

public class DoubleObjectV2 extends HeatedPlate {
	Map<Integer, Node> plate;
	
	public DoubleObjectV2(String args[]) {
		super(args);
	}
	
	@Override
	public void simulate() {
		plate = new HashMap<Integer, Node>();
		int index=0;
		for (int i = 0; i < (dimension+2); i++) {
			for (int j = 0; j < (dimension+2); j++) {
				Node node=new Node();				
				if (i == 0){
					node.temp = top;					
				}
				else if (i == dimension + 1){
					node.temp = bottom;
				}
				else if (j == 0){
					node.temp = left;
				}
				else if (j == dimension + 1){
					node.temp = right;
				}
				else {
					node.temp=0.0;
					node.left=(index-1);
					node.right=(index+1);
					node.top=(index-(dimension+2));
					node.bottom=(index+(dimension+2));
				}
				plate.put(i*((dimension+2))+j, node);
				index++;
			}			
		}		
		boolean fluctuation=true;	
		double oldTemp=0;
		while (fluctuation && iterationsCompleted<this.maxIterations) {			
			fluctuation=false;
			index=0;
			for (int i = 0; i < (dimension+2); i++) {
				for (int j = 0; j < (dimension+2); j++) {
					if(i>0 && i<(dimension+1) && j>0 && j<(dimension+1)) {	
						Node node=plate.get(index);
						oldTemp=node.temp;
						node.temp=(plate.get(node.left).temp + plate.get(node.right).temp + plate.get(node.top).temp + plate.get(node.bottom).temp)/4.0;
						if(node.temp-oldTemp>fluctuationThreshold) {
							fluctuation=true;
						}
					}
					index++;
				}				
			}
			iterationsCompleted++;
		}
	}

	@Override
	public void printResults() {
		System.out.print("\n------ Results -------\n");
		int index=0;
		for (int i = 0; i < (dimension+2); i++) {
			for (int j = 0; j < (dimension+2); j++) {
				if(i>0 && i<(dimension+1) && j>0 && j<(dimension+1)) {					
					Node node=plate.get(index);
					DecimalFormat numFormat=new DecimalFormat("#00.##");
				    String temp = numFormat.format(node.temp);
				    System.out.print(temp+"\t");
				}		
				index++;
			}
			System.out.print("\n\n");
		}		
		System.out.println("-----------------------");		
		System.out.println("\nMaximum Iterations: "+maxIterations);
		System.out.println("Iterations Completed: "+iterationsCompleted);
		System.out.println("Fluctuation Threshold : "+fluctuationThreshold);	
	}
	class Node {
		int left;
		int right;
		int top;
		int bottom;
		double temp;
		public String toString() {
			return "left: "+left+" top: "+top+" right: "+right+" bottom: "+ bottom+" temp: "+temp;
		}
	}
}
