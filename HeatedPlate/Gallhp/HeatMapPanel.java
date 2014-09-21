package Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

public class HeatMapPanel extends JPanel{
	
	private int panelSize = 760;
	private int blockSize;
	private int blockRow = 0;
	private int blockColumn = 0;
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
					blockRow = i + 1;
					blockColumn = j + 1;
					g.setColor(getColor((float)currPlate[i][j]));
					g.fillRect(blockSize * blockRow, blockSize * blockColumn, blockSize, blockSize);
				}
			}
		}
		else {
			for(int i=0;i < plateDimension;i++) {
				for(int j=0;j < plateDimension;j++) {
					blockRow = i + 1;
					blockColumn = j + 1;
					g.setColor(Color.BLACK);
					g.fillRect(blockSize * blockRow, blockSize * blockColumn, blockSize, blockSize);
				}
			}
		}
	}
	
	private Color getColor(float temp) {
		if (temp <= 25) {
			//System.out.println("value of float " + temp);
			return new Color(0, 0, temp/100);
		}
		else if (temp > 25 && temp < 75) {
			System.out.println("value of float " + temp);
			System.out.println("RGB:" + (temp/100) + "," + "0" + "," + ((100-temp)/100));
			return new Color(temp/100, 0, (100-temp)/100);
		}
		else {
			//System.out.println("value of float " + temp);
			System.out.println("RGB:" + (temp/100) + "," + (temp/100) + "," + (temp/100));
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
