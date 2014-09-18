package Tpdohp;

public abstract class SimpleNode {
	protected int x;
	protected int y;
	protected double temperature, top, bottom, left, right;
	
	public void SimpleNode(int x, int y) {
		this.x = x;
		this.y = y;
		temperature = 0;
	}
	
	public double top(HashMap lattice) {
		return lattice.get(x.ToString + "," + (y + 1).ToString()).temperature;
	}
	
	public double bottom(HashMap lattice) {
		return lattice.get(x.ToString + "," + (y - 1).ToString()).temperature;
	}
	
	public double left(HashMap lattice) {
		return lattice.get((x - 1).ToString + "," + (y).ToString()).temperature;
	}
	
	public double right(HashMap lattice) {
		return lattice.get((x + 1).ToString + "," + (y).ToString()).temperature;
	}
}

public class ContextNode extends SimpleNode {
	protected double 
	
	public ContextNode(int x, int y) {
		
	}
}

public class DoubleObject extends HeatedPlate{
	
	public DoubleObject(String args[]) {
		super(args[]);
	}

	@Override
	public void simulate() {
		HashMap lattice = new HashMap();
		SimpleNode myNode;
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				myNode = new SimpleNode(i,j);
			
				if (i == 0){
					myNode.temperature = bottom;
				}
				if (i == oldPlate.length - 1){
					myNode.temperature = top;
				}
				if (j == 0){
					myNode.temperature = left;
				}
				if (j == oldPlate[i].length - 1){
					myNode.temperature = right;
				}
				
				lattice.put(myNode.x.ToString() + "," + myNode.y.ToString(), myNode);
			}
		}
		
		int iteration = 0; //let's move iterations and fluctuation threshold to HeatedPlate class;
		double fluct;
		double oldTemp;
		ContextNode swap = new ContextNode();
		
		while(fluct > 1.0 && iteration < 200) {
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					swap = lattice.get(i.ToString() + "," + j.ToString());
					oldTemp = swap.temperature;
					
					swap.temperature = (swap.top(lattice) + 
										swap.bottom(lattice) + 
										swap.left(lattice) + 
										swap.right(lattice)) 
										/ 4.0;
										
					fluct = swap.temperature - oldTemp;
				}
			}
		}
	}
}