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
	
	private JFormattedTextField dimensionText;
	private JFormattedTextField leftText;
    private JFormattedTextField rightText;
    private JFormattedTextField topText;
    private JFormattedTextField bottomText;
    
	public TextInputsPanel() {
		
		dimensionLabel = new JLabel("Dimension: ");
        leftLabel = new JLabel("Left: ");
        rightLabel = new JLabel("Right: ");
        topLabel = new JLabel("Top: ");
        bottomLabel = new JLabel("Bottom: ");
        
        dimensionText = new JFormattedTextField(NumberFormat.getNumberInstance());
        dimensionText.setValue(0);
        dimensionText.setColumns(10);
        dimensionText.addPropertyChangeListener("value", this);
        
        leftText = new JFormattedTextField(NumberFormat.getNumberInstance());
        leftText.setValue(0);
        leftText.setColumns(10);
        leftText.addPropertyChangeListener("value", this);
        
        rightText = new JFormattedTextField(NumberFormat.getNumberInstance());
        rightText.setValue(0);
        rightText.setColumns(10);
        rightText.addPropertyChangeListener("value", this);
        
        topText = new JFormattedTextField(NumberFormat.getNumberInstance());
        topText.setValue(0);
        topText.setColumns(10);
        topText.addPropertyChangeListener("value", this);
        
        bottomText = new JFormattedTextField(NumberFormat.getNumberInstance());
        bottomText.setValue(0);
        bottomText.setColumns(10);
        bottomText.addPropertyChangeListener("value", this);
        
        this.add(dimensionLabel);
        this.add(dimensionText);
        this.add(leftLabel);
        this.add(leftText);
        this.add(rightLabel);
        this.add(rightText);
        this.add(topLabel);
        this.add(topText);
        this.add(bottomLabel);
        this.add(bottomText);
	}
    
    public void propertyChange(PropertyChangeEvent e) {
    }

}
