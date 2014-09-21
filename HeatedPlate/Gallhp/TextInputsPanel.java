package Gallhp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextInputsPanel extends JPanel implements PropertyChangeListener{
	
	private JLabel dimensionLabel;
	private JLabel leftLabel;
	private JLabel rightLabel;
	private JLabel topLabel;
	private JLabel bottomLabel;
	
	private JFormattedTextField dimensionField;
	private JFormattedTextField leftField;
    private JFormattedTextField rightField;
    private JFormattedTextField topField;
    private JFormattedTextField bottomField;
    
    private int dimension;
    private int left;
    private int right;
    private int top;
    private int bottom;
    
	public TextInputsPanel() {
		
		dimensionLabel = new JLabel("Dimension: ");
        leftLabel = new JLabel("Left: ");
        rightLabel = new JLabel("Right: ");
        topLabel = new JLabel("Top: ");
        bottomLabel = new JLabel("Bottom: ");
        
        dimensionField = new JFormattedTextField(NumberFormat.getNumberInstance());
        dimensionField.setValue(0);
        dimensionField.setColumns(10);
        dimensionField.addPropertyChangeListener("value", this);
        dimensionField.setDocument(new JTextFieldLimit(10));
        
        leftField = new JFormattedTextField(NumberFormat.getNumberInstance());
        leftField.setValue(0);
        leftField.setColumns(10);
        leftField.addPropertyChangeListener("value", this);
        leftField.setDocument(new JTextFieldLimit(3));
        
        rightField = new JFormattedTextField(NumberFormat.getNumberInstance());
        rightField.setValue(0);
        rightField.setColumns(10);
        rightField.addPropertyChangeListener("value", this);
        rightField.setDocument(new JTextFieldLimit(3));
        
        topField = new JFormattedTextField(NumberFormat.getNumberInstance());
        topField.setValue(0);
        topField.setColumns(10);
        topField.addPropertyChangeListener("value", this);
        topField.setDocument(new JTextFieldLimit(3));
        
        bottomField = new JFormattedTextField(NumberFormat.getNumberInstance());
        bottomField.setValue(0);
        bottomField.setColumns(10);
        bottomField.addPropertyChangeListener("value", this);
        bottomField.setDocument(new JTextFieldLimit(3));
        
        this.add(dimensionLabel);
        this.add(dimensionField);
        this.add(leftLabel);
        this.add(leftField);
        this.add(rightLabel);
        this.add(rightField);
        this.add(topLabel);
        this.add(topField);
        this.add(bottomLabel);
        this.add(bottomField);
	}
    
    public void propertyChange(PropertyChangeEvent e) {
    	Object source = e.getSource();
    	if (source == dimensionField) {
    		dimension = ((Number) dimensionField.getValue()).intValue();
    	}
    }
    
    int getDimension() {
    	return dimension;
    }
    
    int getLeft() {
    	return left;
    }
    
    int getRight() {
    	return right;
    }
    
    int getTop() {
    	return top;
    }
    
    int getBottom() {
    	return bottom;
    }
}