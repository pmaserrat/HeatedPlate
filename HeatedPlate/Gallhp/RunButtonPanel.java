package Gallhp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RunButtonPanel extends JPanel implements ActionListener{
	
	public RunButtonPanel () {
	    JButton runButton = new JButton("Run");
	    runButton.setToolTipText("Run for selected items");
	    runButton.setActionCommand("run");
	    runButton.setSize(new Dimension(50, 30));
	    
	    runButton.addActionListener(this);
	    
		this.add(runButton);
	}
	
    public void actionPerformed(ActionEvent e) {
		
    }
}
