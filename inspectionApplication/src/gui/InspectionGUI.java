package gui;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class InspectionGUI{
	JFrame inspectionJFrame;
	private JRadioButton line1yes, line2yes,line3yes,line4yes, line5yes, line6yes, line7yes, line8yes,line9yes,line10yes, line11yes;
	private JRadioButton line1no, line2no, line3no, line4no, line5no, line6no, line7no, line8no, line9no, line10no,line11no;
	private JRadioButton line1na, line2na,line3na, line4na, line5na, line6na,line7na, line8na, line9na, line10na, line11na;
	private ButtonGroup line1btnGroup, line2btnGroup,line3btnGroup, line4btnGroup, line5btnGroup, line6btnGroup, line7btnGroup, line8btnGroup, line9btnGroup;
	private ButtonGroup line10btnGroup, line11btnGroup;
	private JTextArea line1Text, line2Text, line3Text, line4Text, line6Text, line7Text, line8Text, line9Text, line10Text, line11Text;
	private JTextArea textArea;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JTextArea line5Text;


	
	
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
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBounds(0, 0, 594, 571);
		inspectionJFrame.getContentPane().add(tabbedPane);
		
		line1btnGroup = new ButtonGroup();
		
		JPanel swpppPanel = new JPanel();
		tabbedPane.addTab("SWPPP Information", null, swpppPanel, null);
		swpppPanel.setLayout(null);
		
		JPanel bmpPanel = new JPanel();
		tabbedPane.addTab("BMP/Housekeeping Information", null, bmpPanel, null);
		
		JPanel commentPanel = new JPanel();
		tabbedPane.addTab("Comments", null, commentPanel, null);
		
		JPanel imagePanel = new JPanel();
		tabbedPane.addTab("Location Images", null, imagePanel, null);
	
		
	    line1Text = new JTextArea();
		line1Text.setText("1. For a nonlinear project, is a sign or other notice: \n"
				+ "a) Posted Conspicuously near the main entrance of the \n" 
				+ "construction site or if not feasible, \n" 
				+ "b) Posted in a local public building such as the town hall or \n"
				+ "public library \n"
				+ "For linear projects, is a sign or other notice posted at a publicly accessible"
				+ " location near the active construction project?");
		line1Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line1Text.setEditable(false);
		line1Text.setBounds(10, 11, 318, 102);
		line1Text.setLineWrap(true);
		swpppPanel.add(line1Text);
		
		line1yes = new JRadioButton("Yes");
		line1yes.setBounds(334, 11, 50, 23);
		swpppPanel.add(line1yes);
		
		line1no = new JRadioButton("No");
		line1no.setBounds(386, 11, 44, 23);
		swpppPanel.add(line1no);
		
		line1na = new JRadioButton("N/A");
		line1na.setBounds(434, 11, 50, 23);
		swpppPanel.add(line1na);
		
		line1btnGroup.add(line1yes);
		line1btnGroup.add(line1no);
		line1btnGroup.add(line1na);
		
		//line 2
		line2Text = new JTextArea();
		line2Text.setText("Is a copy of the permit attached?");
		line2Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line2Text.setEditable(false);
		line2Text.setBounds(10, 119, 318, 18);
		swpppPanel.add(line2Text);
		
		line2yes = new JRadioButton("Yes");
		line2yes.setBounds(334, 119, 50, 23);
		swpppPanel.add(line2yes);
		
		line2no = new JRadioButton("No");
		line2no.setBounds(386, 119, 44, 23);
		swpppPanel.add(line2no);
		
		line2na = new JRadioButton("N/A");
		line2na.setBounds(434, 119, 50, 23);
		swpppPanel.add(line2na);
		line2btnGroup = new ButtonGroup();
		line2btnGroup.add(line2yes);
		line2btnGroup.add(line2no);
		line2btnGroup.add(line2na);
		
		
		//line 3
		line3Text = new JTextArea();
		line3Text.setText("Is the current location of the SWPPP and names and telephone\n"
				+ " numbers of a contact person for scheduling viewing times shown?");
		line3Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line3Text.setEditable(false);
		line3Text.setBounds(10, 142, 318, 32);
		swpppPanel.add(line3Text);
		
		line3yes = new JRadioButton("Yes");
		line3yes.setBounds(334, 151, 50, 23);
		swpppPanel.add(line3yes);
		
		line3no = new JRadioButton("No");
		line3no.setBounds(386, 151, 44, 23);
		swpppPanel.add(line3no);
		
		line3na = new JRadioButton("N/A");
		line3na.setBounds(434, 151, 50, 23);
		swpppPanel.add(line3na);
		
		line3btnGroup = new ButtonGroup();
		line3btnGroup.add(line3yes);
		line3btnGroup.add(line3no);
		line3btnGroup.add(line3na);
		
		
		//line 4
		line4Text = new JTextArea();
		line4Text.setText("2. Does a copy of the SWPPP and accompanying sediment and \r\nerosion control drawings exist on the construction site?");
		line4Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line4Text.setEditable(false);
		line4Text.setBounds(10, 178, 318, 32);
		swpppPanel.add(line4Text);
		
		line4yes = new JRadioButton("Yes");
		line4yes.setBounds(334, 187, 50, 23);
		swpppPanel.add(line4yes);
		
		line4no = new JRadioButton("No");
		line4no.setBounds(386, 187, 44, 23);
		swpppPanel.add(line4no);
		
		line4na = new JRadioButton("N/A");
		line4na.setBounds(434, 187, 50, 23);
		swpppPanel.add(line4na);
		
		line4btnGroup = new ButtonGroup();
		line4btnGroup.add(line4yes);
		line4btnGroup.add(line4no);
		line4btnGroup.add(line4na);
		
		//line 5
		line5Text = new JTextArea();
		line5Text.setText("Is the discharge permit on the construction site?");
		line5Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line5Text.setEditable(false);
		line5Text.setBounds(10, 214, 318, 23);
		swpppPanel.add(line5Text);
		
		line5yes = new JRadioButton("Yes");
		line5yes.setBounds(334, 214, 50, 23);
		swpppPanel.add(line5yes);
		
		line5no = new JRadioButton("No");
		line5no.setBounds(386, 214, 44, 23);
		swpppPanel.add(line5no);
		
		line5na = new JRadioButton("N/A");
		line5na.setBounds(434, 214, 50, 23);
		swpppPanel.add(line5na);
		
		line5btnGroup = new ButtonGroup();
		line5btnGroup.add(line5yes);
		line5btnGroup.add(line5no);
		line5btnGroup.add(line5na);
		
		//line6
		line6Text = new JTextArea();
		line6Text.setText("Is the discharge permit acknowledgement letter on the \n"
				+ "construction site?");
		line6Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line6Text.setEditable(false);
		line6Text.setBounds(10, 243, 318, 32);
		swpppPanel.add(line6Text);
		
		 line6yes = new JRadioButton("Yes");
		line6yes.setBounds(332, 251, 50, 23);
		swpppPanel.add(line6yes);
		
		 line6no = new JRadioButton("No");
		line6no.setBounds(384, 251, 44, 23);
		swpppPanel.add(line6no);
		
		line6na = new JRadioButton("N/A");
		line6na.setBounds(432, 251, 50, 23);
		swpppPanel.add(line6na);
		
		line6btnGroup = new ButtonGroup();
		line6btnGroup.add(line6yes);
		line6btnGroup.add(line6no);
		line6btnGroup.add(line6na);
		
		//line 7
		
		line7Text = new JTextArea();
		line7Text.setText("Are the SWPPP and/or accompanying sediment and erosion \n"
				+ "control drawings updated and documented?");
		line7Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line7Text.setEditable(false);
		line7Text.setBounds(9, 282, 318, 32);
		swpppPanel.add(line7Text);
		
		line7yes = new JRadioButton("Yes");
		line7yes.setBounds(333, 291, 50, 23);
		swpppPanel.add(line7yes);
		
		line7no = new JRadioButton("No");
		line7no.setBounds(385, 291, 44, 23);
		swpppPanel.add(line7no);
		
		line7na = new JRadioButton("N/A");
		line7na.setBounds(433, 291, 50, 23);
		swpppPanel.add(line7na);
			
		line7btnGroup = new ButtonGroup();
		line7btnGroup.add(line7yes);
		line7btnGroup.add(line7no);
		line7btnGroup.add(line7na);
		
		//line 8
		line8Text = new JTextArea();
		line8Text.setText("3. Do inspection records exist on the construction sites?");
		line8Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line8Text.setEditable(false);
		line8Text.setBounds(9, 317, 318, 18);
		swpppPanel.add(line8Text);
		
		line8yes = new JRadioButton("Yes");
		line8yes.setBounds(333, 316, 50, 23);
		swpppPanel.add(line8yes);
		
		line8no = new JRadioButton("No");
		line8no.setBounds(385, 316, 44, 23);
		swpppPanel.add(line8no);
		
		line8na = new JRadioButton("N/A");
		line8na.setBounds(433, 316, 50, 23);
		swpppPanel.add(line8na);
		
		line8btnGroup = new ButtonGroup();
		line8btnGroup.add(line8yes);
		line8btnGroup.add(line8no);
		line8btnGroup.add(line8na);
		
		//line 9
		
		line9Text = new JTextArea();
		line9Text.setText("Has the frequency of inspections occured as specified in the \n"
				+ "SWPPP?");
		line9Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line9Text.setEditable(false);
		line9Text.setBounds(9, 340, 318, 32);
		swpppPanel.add(line9Text);
		
		line9yes = new JRadioButton("Yes");
		line9yes.setBounds(333, 349, 50, 23);
		swpppPanel.add(line9yes);
		
		line9na = new JRadioButton("No");
		line9na.setBounds(385, 349, 44, 23);
		swpppPanel.add(line9na);
		
		line9na = new JRadioButton("N/A");
		line9na.setBounds(433, 349, 50, 23);
		swpppPanel.add(line9na);
	
		line8btnGroup = new ButtonGroup();
		line8btnGroup.add(line9yes);
		line8btnGroup.add(line9no);
		line8btnGroup.add(line9na);
		//
		textArea = new JTextArea();
		textArea.setText("Has the frequency of inspections occured as specified in the \nSWPPP?");
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setEditable(false);
		textArea.setBounds(9, 379, 318, 32);
		swpppPanel.add(textArea);
		
		radioButton = new JRadioButton("Yes");
		radioButton.setBounds(333, 388, 50, 23);
		swpppPanel.add(radioButton);
		
		radioButton_1 = new JRadioButton("No");
		radioButton_1.setBounds(385, 388, 44, 23);
		swpppPanel.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("N/A");
		radioButton_2.setBounds(433, 388, 50, 23);
		swpppPanel.add(radioButton_2);
	
		
		tabbedPane.setForeground(Color.BLUE);
	   
	}
}
