package Gallhp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Tpdahp.DoubleArray;
import Tpdohp.DoubleObject;
import Tpfahp.FloatArray;
import Twfahp.WFloatArray;
import common.HeatedPlate;

import java.awt.FlowLayout;

public class GUIFrame extends JPanel implements ActionListener {
	
    private HeatedPlate plate;
    private RadioButtonPanel radioPanel;
    private TextInputsPanel tempsPanel;

	/**
	 * Create the frame.
	 */
	public GUIFrame() {
		super(new BorderLayout());
		
		JButton runButton = new JButton("Run");
	    runButton.setToolTipText("Run for selected items");
	    runButton.setActionCommand("run");
	    runButton.addActionListener(this);
		
		tempsPanel = new TextInputsPanel();
        add(tempsPanel, BorderLayout.NORTH);  
		
	    radioPanel = new RadioButtonPanel();
	    add(radioPanel, BorderLayout.WEST);
        
        JPanel heatPanel = new HeatMapPanel(5);
        add(heatPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel(new GridLayout(2,1));
        add(panel, BorderLayout.EAST);
        JPanel runButtonPanel = new JPanel();
	    runButtonPanel.add(runButton);
	    panel.add(runButtonPanel, BorderLayout.NORTH);
        
        JPanel imagePanel = new JPanel();
        imagePanel.add(new JLabel(new ImageIcon(GUIFrame.class.getResource("/Gallhp/assets/tempature_gradient.png"))));
        panel.add(imagePanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "run") {
			/*if(radioPanel.getSelection() == radioPanel.tpdahpString) {
				plate = new DoubleArray(
						tempsPanel.getDimension(), 
						(double)tempsPanel.getLeft(), 
						(double)tempsPanel.getRight(), 
						(double)tempsPanel.getTop(), 
						(double)tempsPanel.getBottom());
			}
			else if(radioPanel.getSelection() == radioPanel.tpfahpString) {
				plate = new FloatArray(
						tempsPanel.getDimension(),
						(double)tempsPanel.getLeft(),
						(double)tempsPanel.getRight(),
						(double)tempsPanel.getTop(),
						(double)tempsPanel.getBottom())
			}
			else if(radioPanel.getSelection() == radioPanel.twfahpString) {
				plate = new WFloatArray(
						tempsPanel.getDimension(),
						(double)tempsPanel.getLeft(),
						(double)tempsPanel.getRight(),
						(double)tempsPanel.getTop(),
						(double)tempsPanel.getBottom())
			}
			else if(radioPanel.getSelection() == radioPanel.tpdohpString) {
				plate = new DoubleObject(
						tempsPanel.getDimension(),
						(double)tempsPanel.getLeft(),
						(double)tempsPanel.getRight(),
						(double)tempsPanel.getTop(),
						(double)tempsPanel.getBottom())	
			}*/
		}
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
