package Gallhp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends JPanel implements ActionListener{
	
	static String tpdahpString = "Tpdahp";
    static String tpfahpString = "Tpfahp";
    static String twfahpString = "Twfahp";
    static String tpdohpString = "Tpdohp";
	
    public RadioButtonPanel() {
		JRadioButton tpdahpRB = new JRadioButton(tpdahpString);
		tpdahpRB.setMnemonic(KeyEvent.VK_P);
	    tpdahpRB.setActionCommand(tpdahpString);
	    tpdahpRB.setSelected(true);
	    
	    JRadioButton tpfahpRB = new JRadioButton(tpfahpString);
	    tpfahpRB.setMnemonic(KeyEvent.VK_F);
	    tpfahpRB.setActionCommand(tpfahpString);
	    
	    JRadioButton twfahpRB = new JRadioButton(twfahpString);
	    twfahpRB.setMnemonic(KeyEvent.VK_W);
	    twfahpRB.setActionCommand(twfahpString);
	    
	    JRadioButton tpdohpRB = new JRadioButton(tpdohpString);
	    tpdohpRB.setMnemonic(KeyEvent.VK_O);
	    tpdohpRB.setActionCommand(tpdohpString);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(tpdahpRB);
	    group.add(tpfahpRB);
	    group.add(twfahpRB);
	    group.add(tpdohpRB);
	    
	    tpdahpRB.addActionListener(this);
	    tpfahpRB.addActionListener(this);
	    twfahpRB.addActionListener(this);
	    tpdohpRB.addActionListener(this);
	    
	    this.add(tpdahpRB);
        this.add(tpfahpRB);
        this.add(twfahpRB);
        this.add(tpdohpRB);
    }
    
    public void actionPerformed(ActionEvent e) {
		
    }

}
