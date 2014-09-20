package Gallhp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class GUIFrame extends JPanel implements ActionListener {
	
	static String tpdahpString = "Tpdahp";
    static String tpfahpString = "Tpfahp";
    static String twfahpString = "Twfahp";
    static String tpdohpString = "Tpdohp";

	/**
	 * Create the frame.
	 */
	public GUIFrame() {
		super(new BorderLayout());
		
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
		
	    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	    radioPanel.setSize(60, 120);
        radioPanel.add(tpdahpRB);
        radioPanel.add(tpfahpRB);
        radioPanel.add(twfahpRB);
        radioPanel.add(tpdohpRB);
        
        add(radioPanel, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(20,40,20,20));
        
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
