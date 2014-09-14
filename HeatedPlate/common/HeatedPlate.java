package common;

public abstract class HeatedPlate {
	protected int dimension; //dimension
	protected int left; //temperature at for left edge
	protected int right; //temperature at for right edge
	protected int top; //temperature at for top edge
	protected int bottom; //temperature at for bottom edge
	
	public HeatedPlate() {
		super();
	}
	
	public HeatedPlate(String[] args) {
		boolean d = false,l = false,r=false,t=false,b=false;
		String message="Invalid Arguments entered. Please enter the correct arguments and run it again.\n Syntax java <packageName>.Demo -d # -l # -r # -t # -b #";
		//at least 10 arguments are required to process simulation.
		try {
			if(args.length<10) throw new RuntimeException(message);
			for(int i=0;i<args.length;i++) {
				if(args[i].equals("-d")) {
					d=true;
					dimension=Integer.parseInt(args[i+1]);
				}
				else if(args[i].equals("-l")) {
					l=true;
					left=Integer.parseInt(args[i+1]);
				}
				else if(args[i].equals("-r")) {
					r=true;
					right=Integer.parseInt(args[i+1]);
				}
				else if(args[i].equals("-t")) {
					t=true;
					top=Integer.parseInt(args[i+1]);
				}
				else if(args[i].equals("-b")) {
					b=true;
					bottom=Integer.parseInt(args[i+1]);
				}
			}
			if(!d || !l || !r || !t || !b) {
				throw new RuntimeException(message);
			}
			System.out.println("Arguments: dimension - "+dimension+", left - "+left+", right - "+right+", top - "+top+", bottom - "+bottom);
		}
		catch(Exception e) {
			throw new RuntimeException(message);
			
		}
	}
	public abstract void simulate();
	
	public abstract void printResults();
}
