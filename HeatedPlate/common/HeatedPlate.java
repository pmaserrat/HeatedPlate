package common;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class HeatedPlate {
	protected int dimension; //dimension
	protected double left; //temperature at for left edge
	protected double right; //temperature at for right edge
	protected double top; //temperature at for top edge
	protected double bottom; //temperature at for bottom edge
	
	protected int maxIterations=200;
	protected double fluctuationThreshold=0.005;
	protected int iterationsCompleted=1;
	
	protected Map<Integer, double[][]> result;
	
	public HeatedPlate() {
		super();
	}
	
	//Used when running simulation from GUI (5th program) to instantiate heated plate from 
	//parameters entered by user on the GUI. 
	public HeatedPlate(int dimension,double left,double right,double top,double bottom ) {
		super();
		this.dimension=dimension;
		this.left=left;
		this.right=right;
		this.top=top;
		this.bottom=bottom;
	}
	
	//Used when running simulation from command line.
	public HeatedPlate(String[] args) {
		boolean d = false,l = false,r=false,t=false,b=false;
		String message="Invalid Arguments entered. Please enter the correct arguments and run it again.\n\nCommand syntax: java <packageName>.Demo -d # -l # -r # -t # -b #\n\t-d must be an integer\n\tall other arguments must be integers or real numbers in the range 0.0..100.0 inclusive";
		//at least 10 arguments are required to process simulation.
		try {
			if(args.length<10 || !validateArgs(args)) throw new RuntimeException(message);
			for(int i=0;i<args.length;i++) {
				if(args[i].equals("-d")) {
					d=true;
					dimension=Integer.parseInt(args[i+1]);
				} 
				else if(args[i].equals("-l")) {
					l=true;
					left=Double.parseDouble(args[i+1]);
				}
				else if(args[i].equals("-r")) {
					r=true;
					right=Double.parseDouble(args[i+1]);
				}
				else if(args[i].equals("-t")) {
					t=true;
					top=Double.parseDouble(args[i+1]);
				}
				else if(args[i].equals("-b")) {
					b=true;
					bottom=Double.parseDouble(args[i+1]);
				}
			}
			if(!d || !l || !r || !t || !b) {
				throw new RuntimeException(message);
			}
			if(dimension == 0) {
				System.out.println("It appears that your plate doesn't have any dimensions. Did it fall into a black hole? \r\n\r\n When you get a new one, you can try again.");
			}
			if(dimension == 1) {
				double avgTemp;
				avgTemp = (top + bottom + left + right) / 4.0;
				DecimalFormat numFormat=new DecimalFormat("#00.##");
				System.out.println("Oh! That's an easy one: " + numFormat.format(avgTemp));
			}
			System.out.println("Arguments: dimension - "+dimension+", left - "+left+", right - "+right+", top - "+top+", bottom - "+bottom);
		}
		catch(Exception e) {
			throw new RuntimeException(message);
		}
	}

	public abstract Map<Integer,double[][]> simulate();

	private boolean validateArgs(String[] args){
		Pattern pattern = Pattern.compile("[^\\.\\d]");
		Matcher matcher = pattern.matcher("");
		for(int i = 1; i <= args.length; i += 2){
			matcher = pattern.matcher(args[i]);
			if (matcher.find()) {			
				return false;
			}
		}
		return true;
	}

	public abstract void printResults();
	
	public void printPerformanceReport(long processingTime) {
		System.out.println("\n--------- Performance Report ----------");
		System.out.println("Processing Time : "+processingTime+" milliseconds");
	    double currentMemory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
	    System.out.println("Memory Used : "+currentMemory+" megabytes");
	    System.out.println("Free Memory : "+((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024))+" megabytes");
	    System.out.println("Total Memory : "+( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))+" megabytes");
	    System.out.println("-----------------------------------------");
	}
}

