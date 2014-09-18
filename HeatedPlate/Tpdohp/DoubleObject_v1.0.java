package Tpdohp;

public abstract class SimpleNode {
	protected int x, y;
	protected double temperature;
	
	public void SimpleNode(int x, int y) {
		this.x = x;
		this.y = y;
		temperature = 0;
	}
	
	public double updateTemp(HashMap lattice) {
		return (lattice.get(x.ToString + "," + (y + 1).ToString()).temperature +
				lattice.get(x.ToString + "," + (y - 1).ToString()).temperature +
				lattice.get((x - 1).ToString + "," + (y).ToString()).temperature +
				lattice.get((x + 1).ToString + "," + (y).ToString()).temperature) / 4
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
		double fluct, oldTemp;
		fluct = 1;
		SimpleNode swap = new SimpleNode();
		
		while(fluct > 0.005 && iteration < 200) {
			
			fluct = oldTemp = 0;
			
			for (int i = 1; i <= dimension; i++) {
				for (int j = 1; j <= dimension; j++) {
					swap = lattice.get(i.ToString() + "," + j.ToString());
					oldTemp = oldTemp + swap.temperature;
					swap.temperature = swap.updateTemp(lattice);
					fluct = fluct + swap.temperature;
				}
			}
			
			fluct = (fluct / dimension) - (oldTemp / dimension)
		}
	}
}