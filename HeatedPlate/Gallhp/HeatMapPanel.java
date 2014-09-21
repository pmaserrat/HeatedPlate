package Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

public class HeatMapPanel extends JPanel{
	
	private int panelSize = 760;
	private int blockSize;
	private Map<Integer,double[][]> plate;
	private int plateDimension;
	private int iteration;
	private double[][] currPlate;
	
	public HeatMapPanel(int dimension) {
       this.setPreferredSize(new Dimension(panelSize, panelSize));
       if(panelSize >= dimension) {
    	   blockSize = panelSize / dimension;
       }
       else {
    	   blockSize = 1;
       }
       plateDimension = dimension;
       plate = null;
    }
	
	
	protected void paintComponent (Graphics g) {
		if(plate != null) {
			for(int i=0;i < plateDimension;i++) {
				for(int j=0;j < plateDimension;j++) {
					g.setColor(getColor((float)currPlate[i][j]));
					g.fillRect(blockSize * j, blockSize * i, blockSize, blockSize);
				}
			}
		}
		else {
			for(int i=0;i < plateDimension;i++) {
				for(int j=0;j < plateDimension;j++) {
					g.setColor(Color.BLACK);
					g.fillRect(blockSize * j, blockSize * i, blockSize, blockSize);
				}
			}
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
	
	public void SimulateAndDisplayHeatMap(Map<Integer,double[][]> simPlate) {
		plate = simPlate;
		currPlate = plate.get(plate.size() - 1);
		iteration = plate.size() -1;
		System.out.println("plate iteration " + iteration);
		repaint();
	}

}
