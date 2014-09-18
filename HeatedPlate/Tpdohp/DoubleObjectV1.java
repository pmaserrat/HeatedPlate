package Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import common.HeatedPlate;

public class DoubleObjectV1 extends HeatedPlate {
	Map<Integer, Node> plate;
	
	public DoubleObjectV1(String args[]) {
		super(args);
	}
	
	@Override
	public void simulate() {
		plate = new HashMap<Integer, Node>();
		int size=dimension+2;
		int index=0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Node node=new Node();		
				node.left=((j-1)>=0?index-1:-1);
				node.top=((i-1)>=0?index-size:-1);
				node.right=((j<size-1)?index+1:-1);
				node.bottom=((i<size-1)?index+size:-1);
				double temp=0;
				if(i==0) {
					temp=top;
					node.topEdge=(true);
				}
				if(i==size-1) {
					temp=bottom;
					node.bottomEdge=(true);
				}
				if(j==0) { 
					temp=left;
					node.leftEdge=(true);
				}
				if(j==size-1) {
					temp=right;
					node.rightEdge=(true);
				}
				node.temp=(temp);				
				plate.put(index, node);
				index++;
			}			
		}
		
		boolean fluctuation=true;
		while (fluctuation && iterationsCompleted<this.maxIterations) {
			for(int i=0;i<plate.size();i++) {
				Node node=plate.get(i);
				if(node.isEdge()) continue;
				double leftTemp=(node.left>=0?plate.get(node.left).temp:0);
				double rightTemp=(node.right>=0?plate.get(node.right).temp:0);
				double topTemp=(node.top>=0?plate.get(node.top).temp:0);
				double bottomTemp=(node.bottom>=0?plate.get(node.bottom).temp:0);
				double avgTemp=(leftTemp+rightTemp+topTemp+bottomTemp)/4.0;
				node.oldTemp=(node.temp);
				node.temp=(avgTemp);
				plate.put(i, node);
			}
			iterationsCompleted++;
			
			fluctuation=false;
			for(int i=0;i<plate.size();i++) {
				Node node=plate.get(i);
				if(node.isEdge()) continue;
				if(node.temp-node.oldTemp>fluctuationThreshold) {
					fluctuation=true;
					break;
				}
			}
		}
	}

	public double getFluctuationThreshold() {
		return fluctuationThreshold;
	}

	public void setFluctuationThreshold(double fluctuationThreshold) {
		this.fluctuationThreshold = fluctuationThreshold;
	}

	@Override
	public void printResults() {
		System.out.print("\n------ Results -------\n");
		for(int i=0;i<plate.size();i++) {
			Node node=plate.get(i);		
			if(node.rightEdge && !node.bottomEdge) {
				System.out.print("\n\n");
			}
			else if(node.isEdge()) continue;
			else {	
				DecimalFormat numFormat=new DecimalFormat("#00.##");
			    String temp = numFormat.format(node.temp);
				System.out.print(temp+"\t");
			}
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
		double oldTemp;
		boolean leftEdge;
		boolean rightEdge;
		boolean topEdge;
		boolean bottomEdge;
		public boolean isEdge() {
			return leftEdge || rightEdge || topEdge || bottomEdge;
		}
	}
}
