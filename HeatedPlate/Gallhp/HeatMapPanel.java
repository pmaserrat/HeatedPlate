package Gallhp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HeatMapPanel extends JPanel{
	
	private int panelSize = 760;
	private int blockSize;
	private int blockRow = 0;
	private int blockColumn = 0;
	private double[][] doubleArrayPlate;
	private float[] floatArrayPlate;
	private Float[] FloatArrayPlate;
	
	public HeatMapPanel(int mapDimension) {
        setPreferredSize(new Dimension(panelSize, panelSize));
        if(panelSize >= (mapDimension+2)) {
        	blockSize = panelSize / (mapDimension + 2);
        }
        else {
        	blockSize = 1;
        }
        
    }
	
	public void GetPlate(double[][] plate) {
		doubleArrayPlate = plate;
	}
	
	public void paint (Graphics g) {
		if(doubleArrayPlate != null) {
			for(int i=0;i<doubleArrayPlate.length;i++) {
				for(int j=0;j<doubleArrayPlate[i].length;j++) {
					blockRow = i + 1;
					blockColumn = j + 1;
					g.setColor(getColor((float) doubleArrayPlate[i][j]));
					g.drawRect(blockSize * blockRow, blockSize * blockColumn, blockSize, blockSize);
				}
			}
		}
	}
	
	
	private Color getColor(float temp) {
		if (temp <= 25) {
			return new Color(0, 0, 1/temp);
		}
		else if (temp > 25 && temp < 75) {
			return new Color(1/temp, 0, 1/(100-temp));
		}
		else {
			return new Color(1/temp, 1/temp, 1/temp);
		}
	}

}
