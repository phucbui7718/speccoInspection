package gui;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.sun.glass.ui.Window;

import database.Database;
import model.Inspector;
import model.Report;
import model.SwpppReport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InspectionGUI{
	JFrame inspectionJFrame;
	
	//SWPPP variables 
	private JRadioButton line1yes, line2yes,line3yes,line4yes, line5yes, line6yes, line7yes, line8yes,line9yes,line10yes, line11yes;
	private JRadioButton line1no, line2no, line3no, line4no, line5no, line6no, line7no, line8no, line9no, line10no,line11no;
	private JRadioButton line1na, line2na,line3na, line4na, line5na, line6na,line7na, line8na, line9na, line10na, line11na;
	private ButtonGroup line1btnGroup, line2btnGroup,line3btnGroup, line4btnGroup, line5btnGroup, line6btnGroup, line7btnGroup, line8btnGroup, line9btnGroup;
	private ButtonGroup line10btnGroup, line11btnGroup;
	private JTextArea line1Text, line2Text, line3Text, line4Text,line5Text, line6Text, line7Text, line8Text, line9Text, line10Text, line11Text;
	
	private JTextField line1comment;
	private JTextField line2comment;
	private JTextField line3comment;
	private JTextField line4comment;
	private JTextField line5comment;
	private JTextField line6comment;
	private JTextField line7comment;
	private JTextField line8comment;
	private JTextField line9comment;
	private JTextField line10comment;
	private JTextField line11comment;
	
	//BMP/HouseKeeping Variables
	
	

	
	
	/**
	 * Create the frame.
	 */
	public InspectionGUI(Inspector inspector) {
		
		inspectionJFrame = new JFrame();
		inspectionJFrame.setTitle("Inspection Form");
		inspectionJFrame.setResizable(false);
		inspectionJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inspectionJFrame.setBounds(100, 100, 700, 600);
		inspectionJFrame.getContentPane().setLayout(null);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBounds(0, 0, 694, 510);
		inspectionJFrame.getContentPane().add(tabbedPane);
		
		
		JPanel swpppPanel = new JPanel();
		tabbedPane.addTab("SWPPP Information", null, swpppPanel, null);
		swpppPanel.setLayout(null);
		
		JPanel bmpPanel = new JPanel();
		tabbedPane.addTab("BMP/Housekeeping Information", null, bmpPanel, null);
		bmpPanel.setLayout(null);
		
		JPanel commentPanel = new JPanel();
		tabbedPane.addTab("Comments", null, commentPanel, null);
		commentPanel.setLayout(null);
		
		JPanel imagePanel = new JPanel();
		tabbedPane.addTab("Location Images", null, imagePanel, null);
		imagePanel.setLayout(null);
		    
			
			line1btnGroup = new ButtonGroup();
		    
		    line2btnGroup = new ButtonGroup();
		    line3btnGroup = new ButtonGroup();
		    line4btnGroup = new ButtonGroup();
		    line5btnGroup = new ButtonGroup();
		      line6btnGroup = new ButtonGroup();
		      line7btnGroup = new ButtonGroup();
		      line8btnGroup = new ButtonGroup();
		      
		      line9btnGroup = new ButtonGroup();
		      
		      line10btnGroup = new ButtonGroup();
		      
		      line11btnGroup = new ButtonGroup();
		
	

		
		tabbedPane.setForeground(Color.BLUE);
		
				
				
				
		    line1Text = new JTextArea();
		    line1Text.setText("1. For a nonlinear project, is a sign or other notice: \n"
		    		+ "a) Posted Conspicuously near the main entrance of the \n" 
		    		+ "construction site or if not feasible, \n" 
		    		+ "b) Posted in a local public building such as the town hall or \n"
		    		+ "public library \n"
		    		+ "For linear projects, is a sign or other notice posted at a publicly \n"
		    		+ "accessible location near the active construction project?");
		    line1Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line1Text.setEditable(false);
		    line1Text.setBounds(14, 30, 318, 102);
		    line1Text.setLineWrap(true);
		    swpppPanel.add(line1Text);
		    
		    line1yes = new JRadioButton("Yes");
		    line1yes.setBounds(338, 30, 50, 23);
		    swpppPanel.add(line1yes);
		    
		    line1no = new JRadioButton("No");
		    line1no.setBounds(390, 30, 44, 23);
		    swpppPanel.add(line1no);
		    
		    line1na = new JRadioButton("N/A");
		    line1na.setBounds(438, 30, 50, 23);
		    swpppPanel.add(line1na);
		    line1btnGroup.add(line1yes);
		    line1btnGroup.add(line1no);
		    line1btnGroup.add(line1na);
		    
		    //line 2
		    line2Text = new JTextArea();
		    line2Text.setText("Is a copy of the permit attached?");
		    line2Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line2Text.setEditable(false);
		    line2Text.setBounds(14, 138, 318, 18);
		    swpppPanel.add(line2Text);
		    
		    line2yes = new JRadioButton("Yes");
		    line2yes.setBounds(338, 138, 50, 23);
		    swpppPanel.add(line2yes);
		    
		    line2no = new JRadioButton("No");
		    line2no.setBounds(390, 138, 44, 23);
		    swpppPanel.add(line2no);
		    
		    line2na = new JRadioButton("N/A");
		    line2na.setBounds(438, 138, 50, 23);
		    swpppPanel.add(line2na);
		    line2btnGroup.add(line2yes);
		    line2btnGroup.add(line2no);
		    line2btnGroup.add(line2na);
		    
		    
		    //line 3
		    line3Text = new JTextArea();
		    line3Text.setText("Is the current location of the SWPPP and names and telephone\n"
		    		+ " numbers of a contact person for scheduling viewing times shown?");
		    line3Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line3Text.setEditable(false);
		    line3Text.setBounds(14, 161, 318, 32);
		    swpppPanel.add(line3Text);
		    
		    line3yes = new JRadioButton("Yes");
		    line3yes.setBounds(338, 170, 50, 23);
		    swpppPanel.add(line3yes);
		    
		    line3no = new JRadioButton("No");
		    line3no.setBounds(390, 170, 44, 23);
		    swpppPanel.add(line3no);
		    
		    line3na = new JRadioButton("N/A");
		    line3na.setBounds(438, 170, 50, 23);
		    swpppPanel.add(line3na);
		    line3btnGroup.add(line3yes);
		    line3btnGroup.add(line3no);
		    line3btnGroup.add(line3na);
		    
		    
		    //line 4
		    line4Text = new JTextArea();
		    line4Text.setText("2. Does a copy of the SWPPP and accompanying sediment and \r\nerosion control drawings exist on the construction site?");
		    line4Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line4Text.setEditable(false);
		    line4Text.setBounds(14, 197, 318, 32);
		    swpppPanel.add(line4Text);
		    
		    line4yes = new JRadioButton("Yes");
		    line4yes.setBounds(338, 206, 50, 23);
		    swpppPanel.add(line4yes);
		    
		    line4no = new JRadioButton("No");
		    line4no.setBounds(390, 206, 44, 23);
		    swpppPanel.add(line4no);
		    
		    line4na = new JRadioButton("N/A");
		    line4na.setBounds(438, 206, 50, 23);
		    swpppPanel.add(line4na);
		    line4btnGroup.add(line4yes);
		    line4btnGroup.add(line4no);
		    line4btnGroup.add(line4na);
		    
		    //line 5
		    line5Text = new JTextArea();
		    line5Text.setText("Is the discharge permit on the construction site?");
		    line5Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line5Text.setEditable(false);
		    line5Text.setBounds(14, 233, 318, 23);
		    swpppPanel.add(line5Text);
		    
		    line5yes = new JRadioButton("Yes");
		    line5yes.setBounds(338, 233, 50, 23);
		    swpppPanel.add(line5yes);
		    
		    line5no = new JRadioButton("No");
		    line5no.setBounds(390, 233, 44, 23);
		    swpppPanel.add(line5no);
		    
		    line5na = new JRadioButton("N/A");
		    line5na.setBounds(438, 233, 50, 23);
		    swpppPanel.add(line5na);
		    line5btnGroup.add(line5yes);
		    line5btnGroup.add(line5no);
		    line5btnGroup.add(line5na);
		    
		    //line6
		    line6Text = new JTextArea();
		    line6Text.setText("Is the discharge permit acknowledgement letter on the \n"
		    		+ "construction site?");
		    line6Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    line6Text.setEditable(false);
		    line6Text.setBounds(14, 262, 318, 32);
		    swpppPanel.add(line6Text);
		    
		     line6yes = new JRadioButton("Yes");
		     line6yes.setBounds(336, 270, 50, 23);
		     swpppPanel.add(line6yes);
		     
		      line6no = new JRadioButton("No");
		      line6no.setBounds(388, 270, 44, 23);
		      swpppPanel.add(line6no);
		      
		      line6na = new JRadioButton("N/A");
		      line6na.setBounds(436, 270, 50, 23);
		      swpppPanel.add(line6na);
		      line6btnGroup.add(line6yes);
		      line6btnGroup.add(line6no);
		      line6btnGroup.add(line6na);
		      
		      //line 7
		      
		      line7Text = new JTextArea();
		      line7Text.setText("Are the SWPPP and/or accompanying sediment and erosion \n"
		      		+ "control drawings updated and documented?");
		      line7Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		      line7Text.setEditable(false);
		      line7Text.setBounds(13, 301, 318, 32);
		      swpppPanel.add(line7Text);
		      
		      line7yes = new JRadioButton("Yes");
		      line7yes.setBounds(337, 310, 50, 23);
		      swpppPanel.add(line7yes);
		      
		      line7no = new JRadioButton("No");
		      line7no.setBounds(389, 310, 44, 23);
		      swpppPanel.add(line7no);
		      
		      line7na = new JRadioButton("N/A");
		      line7na.setBounds(437, 310, 50, 23);
		      swpppPanel.add(line7na);
		      line7btnGroup.add(line7yes);
		      line7btnGroup.add(line7no);
		      line7btnGroup.add(line7na);
		      
		      //line 8
		      line8Text = new JTextArea();
		      line8Text.setText("3. Do inspection records exist on the construction sites?");
		      line8Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		      line8Text.setEditable(false);
		      line8Text.setBounds(12, 339, 318, 18);
		      swpppPanel.add(line8Text);
		      
		      line8yes = new JRadioButton("Yes");
		      line8yes.setBounds(337, 335, 50, 23);
		      swpppPanel.add(line8yes);
		      
		      line8no = new JRadioButton("No");
		      line8no.setBounds(389, 335, 44, 23);
		      swpppPanel.add(line8no);
		      
		      line8na = new JRadioButton("N/A");
		      line8na.setBounds(437, 335, 50, 23);
		      swpppPanel.add(line8na);
		      line8btnGroup.add(line8yes);
		      line8btnGroup.add(line8no);
		      line8btnGroup.add(line8na);
		      
		      //line 9
		      
		      line9Text = new JTextArea();
		      line9Text.setText("Has the frequency of inspections occured as specified in the \n"
		      		+ "SWPPP?");
		      line9Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		      line9Text.setEditable(false);
		      line9Text.setBounds(10, 365, 318, 32);
		      swpppPanel.add(line9Text);
		      
		      line9yes = new JRadioButton("Yes");
		      line9yes.setBounds(337, 368, 50, 23);
		      swpppPanel.add(line9yes);
		      
		      
		      line9no = new JRadioButton("No");
		      line9no.setBounds(389, 368, 44, 23);
		      swpppPanel.add(line9no);
		      
		      line9na = new JRadioButton("N/A");
		      line9na.setBounds(437, 368, 50, 23);
		      swpppPanel.add(line9na);
		      line9btnGroup.add(line9yes);
		      line9btnGroup.add(line9no);
		      line9btnGroup.add(line9na);
		      
		      
		      //line 10
		      line10Text = new JTextArea();
		      line10Text.setText("Have all previous inspection items been addressed and\n"
		      		+ " documented within seven (7) calendar days after an inspection?");
		      line10Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		      line10Text.setEditable(false);
		      line10Text.setBounds(10, 404, 318, 32);
		      swpppPanel.add(line10Text);
		      
		      line10yes = new JRadioButton("Yes");
		      line10yes.setBounds(337, 407, 50, 23);
		      swpppPanel.add(line10yes);
		      
		      line10no = new JRadioButton("No");
		      line10no.setBounds(389, 407, 44, 23);
		      swpppPanel.add(line10no);
		      
		      line10na = new JRadioButton("N/A");
		      line10na.setBounds(437, 407, 50, 23);
		      swpppPanel.add(line10na);
		      line10btnGroup.add(line10yes);
		      line10btnGroup.add(line10no);
		      line10btnGroup.add(line10na);
		      
		      //line 11
		      line11Text = new JTextArea();
		      line11Text.setText("4. Do climatic records exist since the last inspection?");
		      line11Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		      line11Text.setEditable(false);
		      line11Text.setBounds(11, 442, 318, 18);
		      swpppPanel.add(line11Text);
		      
		      line11yes = new JRadioButton("Yes");
		      line11yes.setBounds(338, 435, 50, 23);
		      swpppPanel.add(line11yes);
		      
		      line11no = new JRadioButton("No");
		      line11no.setBounds(390, 435, 44, 23);
		      swpppPanel.add(line11no);
		      
		      line11na = new JRadioButton("N/A");
		      line11na.setBounds(438, 435, 50, 23);
		      swpppPanel.add(line11na);
		      line11btnGroup.add(line11yes);
		      line11btnGroup.add(line11no);	
		      line11btnGroup.add(line11na);
		      
		      JLabel lblNewLabel = new JLabel("Comments:");
		      lblNewLabel.setBounds(548, 11, 68, 14);
		      swpppPanel.add(lblNewLabel);
		      
		      line1comment = new JTextField();
		      line1comment.setBounds(494, 29, 174, 51);
		      swpppPanel.add(line1comment);
		      line1comment.setColumns(10);
		      
		      line2comment = new JTextField();
		      line2comment.setColumns(10);
		      line2comment.setBounds(494, 137, 174, 19);
		      swpppPanel.add(line2comment);
		      
		      line3comment = new JTextField();
		      line3comment.setBounds(494, 161, 174, 30);
		      swpppPanel.add(line3comment);
		      line3comment.setColumns(10);
		      
		      line4comment = new JTextField();
		      line4comment.setBounds(494, 196, 174, 33);
		      swpppPanel.add(line4comment);
		      line4comment.setColumns(10);
		      
		      line5comment = new JTextField();
		      line5comment.setColumns(10);
		      line5comment.setBounds(494, 232, 174, 23);
		      swpppPanel.add(line5comment);
		      
		      line6comment = new JTextField();
		      line6comment.setColumns(10);
		      line6comment.setBounds(494, 261, 174, 30);
		      swpppPanel.add(line6comment);
		      
		      line7comment = new JTextField();
		      line7comment.setColumns(10);
		      line7comment.setBounds(494, 300, 174, 30);
		      swpppPanel.add(line7comment);
		      
		      line8comment = new JTextField();
		      line8comment.setColumns(10);
		      line8comment.setBounds(493, 338, 174, 19);
		      swpppPanel.add(line8comment);
		      
		      line9comment = new JTextField();
		      line9comment.setColumns(10);
		      line9comment.setBounds(494, 365, 174, 30);
		      swpppPanel.add(line9comment);
		      
		      line10comment = new JTextField();
		      line10comment.setColumns(10);
		      line10comment.setBounds(493, 404, 174, 32);
		      swpppPanel.add(line10comment);
		      
		      line11comment = new JTextField();
		      line11comment.setColumns(10);
		      line11comment.setBounds(494, 441, 174, 19);
		      swpppPanel.add(line11comment);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Report report = new Report();
				report.setReportDate(reportInfoGUI.dateText.getText());
				report.setReportLocation(reportInfoGUI.siteText.getText());
				report.setInspector(inspector);
				//
				
				Database.submitReport(report);
				
				SwpppReport swpppReport = new SwpppReport();
				swpppReport.setSwpppLine1(getSelectedButtonText(line1btnGroup));
				swpppReport.setSwpppLine2(getSelectedButtonText(line2btnGroup));
				swpppReport.setSwpppLine3(getSelectedButtonText(line3btnGroup));
				swpppReport.setSwpppLine4(getSelectedButtonText(line4btnGroup));
				swpppReport.setSwpppLine5(getSelectedButtonText(line5btnGroup));
				swpppReport.setSwpppLine6(getSelectedButtonText(line6btnGroup));
				swpppReport.setSwpppLine7(getSelectedButtonText(line7btnGroup));
				swpppReport.setSwpppLine8(getSelectedButtonText(line8btnGroup));
				swpppReport.setSwpppLine9(getSelectedButtonText(line9btnGroup));
				swpppReport.setSwpppLine10(getSelectedButtonText(line10btnGroup));
				swpppReport.setSwpppLine11(getSelectedButtonText(line11btnGroup));
				swpppReport.setReport(report);
				
				Database.submitSwpppReport(swpppReport);
			}
		});
		submitBtn.setBounds(70, 514, 134, 39);
		inspectionJFrame.getContentPane().add(submitBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setBounds(358, 514, 134, 39);
		inspectionJFrame.getContentPane().add(exitBtn);
	   
	}
	
	//Method to find the selected button in a button group.
	private String getSelectedButtonText(ButtonGroup buttonGroup){
		
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();){
			AbstractButton button = buttons.nextElement();
			
			if(button.isSelected()){
				return button.getText();
			}
		}
				
		return null;

	}
}
