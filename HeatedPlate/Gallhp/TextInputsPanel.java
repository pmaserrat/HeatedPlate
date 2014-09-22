package Gallhp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;

public class TextInputsPanel extends JPanel{
	
	private JLabel dimensionLabel;
	private JLabel leftLabel;
	private JLabel rightLabel;
	private JLabel topLabel;
	private JLabel bottomLabel;
	
	private JTextField dimensionField;
	private JTextField leftField;
    private JTextField rightField;
    private JTextField topField;
    private JTextField bottomField;
    
    private String dimension;
    private String left;
    private String right;
    private String top;
    private String bottom;
    
	public TextInputsPanel() {
		
		dimensionLabel = new JLabel("Dimension: ");
        leftLabel = new JLabel("Left: ");
        rightLabel = new JLabel("Right: ");
        topLabel = new JLabel("Top: ");
        bottomLabel = new JLabel("Bottom: ");
        
        dimensionField = new JTextField();
        dimensionField.setColumns(3);
        dimensionField.setDocument(new JTextFieldLimit(3));
        
        leftField = new JTextField();
        leftField.setColumns(3);
        leftField.setDocument(new JTextFieldLimit(3));
        
        rightField = new JTextField();
        rightField.setColumns(3);
        rightField.setDocument(new JTextFieldLimit(3));
        
        topField = new JTextField();
        topField.setColumns(3);
        topField.setDocument(new JTextFieldLimit(3));
        
        bottomField = new JTextField();
        bottomField.setColumns(3);
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
    
    int getDimension() {
    	return Integer.parseInt(dimensionField.getText());
    }
    
    int getLeft() {
    	return Integer.parseInt(leftField.getText());
    }
    
    int getRight() {
    	return Integer.parseInt(rightField.getText());
    }
    
    int getTop() {
    	return Integer.parseInt(topField.getText());
    }
    
    int getBottom() {
    	return Integer.parseInt(bottomField.getText());

    }
}