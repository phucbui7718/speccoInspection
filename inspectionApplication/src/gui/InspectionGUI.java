package gui;


import javax.swing.JFrame;

import javax.swing.JTabbedPane;

public class InspectionGUI{
	JFrame inspectionJFrame;



	/**
	 * Create the frame.
	 */
	public InspectionGUI() {
		inspectionJFrame = new JFrame();
		inspectionJFrame.setTitle("Inspection Form");
		inspectionJFrame.setResizable(false);
		inspectionJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inspectionJFrame.setBounds(100, 100, 600, 600);
		inspectionJFrame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 584, 16);
		inspectionJFrame.getContentPane().add(tabbedPane);
	
	    
	}
}
