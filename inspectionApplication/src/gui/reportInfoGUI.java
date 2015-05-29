package gui;


import javax.swing.JFrame;


public class reportInfoGUI{
	JFrame reportFrame;

	/**
	 * Create the frame.
	 */
	public reportInfoGUI() {
		reportFrame = new JFrame();
		reportFrame.setResizable(false);
		reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reportFrame.setBounds(100, 100, 450, 300);
		reportFrame.getContentPane().setLayout(null);
	}

}
