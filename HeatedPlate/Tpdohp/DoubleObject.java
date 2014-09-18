package Tpdohp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import common.HeatedPlate;

public class DoubleObject extends HeatedPlate {
	Map<Integer, Node> plate;
	double fluctuationThreshold=0.005;
	int totalSteps=1;
	
	
	public DoubleObject(String args[]) {
		super(args);
	}
	
	@Override
	public void simulate() {
		plate = new HashMap<Integer, Node>();
		
		// Initialize the temperatures of the edge values and the plate itself
		int size=dimension+2;
		int index=0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Node node=new Node();		
				node.setLeft((j-1)>=0?index-1:-1);
				node.setTop((i-1)>=0?index-size:-1);
				node.setRight((j<size-1)?index+1:-1);
				node.setBottom((i<size-1)?index+size:-1);
				int temp=0;
				if(i==0) {
					temp=top;
					node.setTopEdge(true);
				}
				if(i==size-1) {
					temp=bottom;
					node.setBottomEdge(true);
				}
				if(j==0) { 
					temp=left;
					node.setLeftEdge(true);
				}
				if(j==size-1) {
					temp=right;
					node.setRightEdge(true);
				}
				node.setTemp(temp);				
				plate.put(index, node);
				index++;
			}			
		}
		
		// Loop until exit criteria are met, updating each newPlate cell from
		// the average temperatures of the corresponding neighbors in oldPlate
		boolean fluctuation=true;
		while (fluctuation && totalSteps<this.maxSteps) {
			for(int i=0;i<plate.size();i++) {
				Node node=plate.get(i);
				if(node.isEdge()) continue;
				double leftTemp=(node.getLeft()>=0?plate.get(node.getLeft()).getTemp():0);
				double rightTemp=(node.getRight()>=0?plate.get(node.getRight()).getTemp():0);
				double topTemp=(node.getTop()>=0?plate.get(node.getTop()).getTemp():0);
				double bottomTemp=(node.getBottom()>=0?plate.get(node.getBottom()).getTemp():0);
				double avgTemp=(leftTemp+rightTemp+topTemp+bottomTemp)/4.0;
				node.setOldTemp(node.getTemp());
				node.setTemp(avgTemp);
				plate.put(i, node);
			}
			totalSteps++;
			
			fluctuation=false;
			for(int i=0;i<plate.size();i++) {
				Node node=plate.get(i);
				if(node.isEdge()) continue;
				if(node.getTemp()-node.getOldTemp()>fluctuationThreshold) {
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

	public int getTotalSteps() {
		return totalSteps;
	}

	public void setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
	}

	@Override
	public void printResults() {
		System.out.print("\n------ Results -------");
		for(int i=0;i<plate.size();i++) {
			Node node=plate.get(i);		
			if(node.isRightEdge() && !node.isBottomEdge()) {
				System.out.print("\n");
			}
			else if(node.isEdge()) continue;
			else {
			      DecimalFormat numFormat=new DecimalFormat("#00.##");
			      String temp = numFormat.format(node.getTemp());

				System.out.print(temp+"\t");
			}
		}
		System.out.println("-----------------------");
		
		System.out.println("\nTotal Steps: "+totalSteps);
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
		
		public int getLeft() {
			return left;
		}
		public void setLeft(int left) {
			this.left = left;
		}
		public int getRight() {
			return right;
		}
		public void setRight(int right) {
			this.right = right;
		}
		public int getTop() {
			return top;
		}
		public void setTop(int top) {
			this.top = top;
		}
		public int getBottom() {
			return bottom;
		}
		public void setBottom(int bottom) {
			this.bottom = bottom;
		}
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public double getOldTemp() {
			 return oldTemp;
		}
		public void setOldTemp(double oldTemp) {
			this.oldTemp = oldTemp;
		}
		public boolean isLeftEdge() {
			return leftEdge;
		}
		public void setLeftEdge(boolean leftEdge) {
			this.leftEdge = leftEdge;
		}
		public boolean isRightEdge() {
			return rightEdge;
		}
		public void setRightEdge(boolean rightEdge) {
			this.rightEdge = rightEdge;
		}
		public boolean isTopEdge() {
			return topEdge;
		}
		public void setTopEdge(boolean topEdge) {
			this.topEdge = topEdge;
		}
		public boolean isBottomEdge() {
			return bottomEdge;
		}
		public void setBottomEdge(boolean bottomEdge) {
			this.bottomEdge = bottomEdge;
		}
		public boolean isEdge() {
			return leftEdge || rightEdge || topEdge || bottomEdge;
		}
	}
}
