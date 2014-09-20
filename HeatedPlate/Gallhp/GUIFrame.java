package Gallhp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class GUIFrame extends JPanel implements ActionListener {
	
    private String plate;

	/**
	 * Create the frame.
	 */
	public GUIFrame() {
		super(new BorderLayout());
		
		JPanel tempsPanel = new TextInputsPanel();
        add(tempsPanel, BorderLayout.NORTH);  
		
	    JPanel radioPanel = new RadioButtonPanel();
	    add(radioPanel, BorderLayout.WEST);
	    
	    JPanel runButtonPanel = new RunButtonPanel();
	    add(runButtonPanel, BorderLayout.EAST);
        
        JPanel heatPanel = new HeatMapPanel(5);
        add(heatPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		
    }
	
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Gallhp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 900);
 
        //Create and set up the content pane.
        JComponent newContentPane = new GUIFrame();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
