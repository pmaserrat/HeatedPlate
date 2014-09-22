package Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

public class HeatMapPanel extends JPanel{
	
	private int panelSize = 760;
	private int blockSize;
	private Map<Integer,double[][]> plates;
	private int plateDimension;
	private int iteration;
	private double[][] currPlate;
	private int iterationDisplayTime;
	private long timeSinceLastRepaint;
	private int maxIterationDisplayTime = 2000;
	private int totalMaxTimeToDisplayAllIterations = 30000;
	
	public HeatMapPanel() {
       this.setPreferredSize(new Dimension(panelSize, panelSize));
       plates = null;
       iteration = 0;
    }
	
	
	protected void paintComponent (Graphics g) {
		if(plates != null) {
			for(int i=0;i < plateDimension;i++) {
				for(int j=0;j < plateDimension;j++) {
					g.setColor(getColor((float)currPlate[i][j]));
					g.fillRect(blockSize * j, blockSize * i, blockSize, blockSize);
				}
			}
		}
		else {
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, panelSize, panelSize);
		}
	}
	
	private Color getColor(float temp) {
		if (temp <= 25) {
			return new Color(0, 0, temp/100);
		}
		else if (temp > 25 && temp < 75) {
			return new Color(temp/100, 0, (100-temp)/100);
		}
		else {
			return new Color(temp/100, temp/100, temp/100);
		}
	}
	
	public void SimulateAndDisplayHeatMap(Map<Integer,double[][]> simPlate, int dimension) {
		if(panelSize >= dimension) {
    	   blockSize = panelSize / dimension;
        }
        else {
    	   blockSize = 1;
        }
	    plateDimension = dimension;
		plates = simPlate;
		currPlate = plates.get(plates.size() - 1);
		//System.out.println("plate iteration " + iteration);
		if((plates.size() * maxIterationDisplayTime) < totalMaxTimeToDisplayAllIterations) {
			iterationDisplayTime = maxIterationDisplayTime;
		}
		else {
			iterationDisplayTime = totalMaxTimeToDisplayAllIterations / plates.size();
		}
		UpdatePlateForIterations();
	}
	
	private void UpdatePlateForIterations() {
//		timeSinceLastRepaint = 0;
//		while(iteration < plates.size() - 1) {
//			if((System.currentTimeMillis() - timeSinceLastRepaint) > iterationDisplayTime) {
//				iteration++;
//				System.out.println("plate iteration:" + iteration + " CurrTime - last repaint:" + (System.currentTimeMillis() - timeSinceLastRepaint) 
//						+ " IDT:" + iterationDisplayTime);
//				currPlate = plates.get(iteration);
//				repaint();
//				timeSinceLastRepaint = System.currentTimeMillis();
//			}
//		}
		currPlate = plates.get(plates.size() - 1);
		repaint();
	}

}
