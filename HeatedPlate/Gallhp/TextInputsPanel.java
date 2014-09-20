package Gallhp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextInputsPanel extends JPanel implements ActionListener{
	
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
        dimensionText.addActionListener(this);
        
        leftText = new JFormattedTextField(NumberFormat.getNumberInstance());
        leftText.addActionListener(this);
        
        rightText = new JFormattedTextField(NumberFormat.getNumberInstance());
        rightText.addActionListener(this);
        
        topText = new JFormattedTextField(NumberFormat.getNumberInstance());
        topText.addActionListener(this);
        
        bottomText = new JFormattedTextField(NumberFormat.getNumberInstance());
        bottomText.addActionListener(this);
        
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
	
    public void actionPerformed(ActionEvent e) {
		
    }

}
