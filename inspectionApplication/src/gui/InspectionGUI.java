package gui;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import database.Database;
import model.BmpReport;
import model.DetailedCommentReport;
import model.Inspector;
import model.Report;
import model.Swpppreport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;






import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.sun.corba.se.spi.orb.ParserDataFactory;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InspectionGUI {

	JFrame inspectionJFrame;
	private boolean notEmpty = false;
	public static String tempImageURL;
	public static Integer photoNumCount = 0;
	//Images panel
	private Webcam webcam = null;
	private WebcamPanel wPanel= null;
	private WebcamPicker wPicker= null;
	
	// SWPPP variables
	private JRadioButton line1yes, line2yes, line3yes, line4yes, line5yes,
			line6yes, line7yes, line8yes, line9yes, line10yes, line11yes;
	private JRadioButton line1no, line2no, line3no, line4no, line5no, line6no,
			line7no, line8no, line9no, line10no, line11no;
	private JRadioButton line1na, line2na, line3na, line4na, line5na, line6na,
			line7na, line8na, line9na, line10na, line11na;
	private ButtonGroup line1btnGroup, line2btnGroup, line3btnGroup,
			line4btnGroup, line5btnGroup, line6btnGroup, line7btnGroup,
			line8btnGroup, line9btnGroup;
	private ButtonGroup line10btnGroup, line11btnGroup;
	private JTextArea line1Text, line2Text, line3Text, line4Text, line5Text,
			line6Text, line7Text, line8Text, line9Text, line10Text, line11Text;
	private ArrayList<JTextArea>  swppTextArea;
	private ArrayList<ButtonGroup> swpppBtnGroup;
	private ArrayList<JTextArea> swpppCommentList;
	

	private JTextArea line1comment, line2comment, line3comment,line4comment,line5comment,
	 line6comment,
 line7comment,
 line8comment,
	line9comment,
	 line10comment,
	 line11comment;
	
	// BMP/HouseKeeping Variables

	private JRadioButton bmpLine1yes, bmpLine2yes, bmpLine3yes, bmpLine4yes,
			bmpLine5yes, bmpLine6yes, bmpLine7yes, bmpLine8yes, bmpLine9yes,
			bmpLine10yes;
	private JRadioButton bmpLine1no, bmpLine2no, bmpLine3no, bmpLine4no,
			bmpLine5no, bmpLine6no, bmpLine7no, bmpLine8no, bmpLine9no,
			bmpLine10no;
	private JRadioButton bmpLine1na, bmpLine2na, bmpLine3na, bmpLine4na,
			bmpLine5na, bmpLine6na, bmpLine7na, bmpLine8na, bmpLine9na,
			bmpLine10na;
	private ButtonGroup bmpLine1BtnGroup, bmpLine2BtnGroup, bmpLine3BtnGroup,
			bmpLine4BtnGroup, bmpLine5BtnGroup, bmpLine6BtnGroup,
			bmpLine7BtnGroup;
	private ButtonGroup bmpLine8BtnGroup, bmpLine9BtnGroup, bmpLine10BtnGroup;
	private JTextArea bmpLine1Comment, bmpLine2Comment, bmpLine3Comment,
			bmpLine4Comment, bmpLine5Comment, bmpLine6Comment, bmpLine7Comment,
			bmpLine8Comment, bmpLine9Comment, bmpLine10Comment;
	private JTextArea bmpLine1Text, bmpLine2Text, bmpLine3Text, bmpLine4Text,
			bmpLine5Text, bmpLine6Text, bmpLine7Text, bmpLine8Text,
			bmpLine9Text, bmpLine10Text;
	
	// Comment panel
	
	private JTextArea comment1Text, comment2Text, comment3Text, comment4Text, comment5Text;
	private JButton getPDFBtn;
	private ArrayList<JTextArea> bmpTextList;
	private ArrayList<JTextArea> bmpCommentList;
	private ArrayList<ButtonGroup> bmpBtnGroupList;
	/**
	 * Create the frame.
	 */
	public InspectionGUI(Inspector inspector) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
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

		bmpLine1BtnGroup = new ButtonGroup();

		bmpLine2BtnGroup = new ButtonGroup();

		bmpLine3BtnGroup = new ButtonGroup();

		bmpLine4BtnGroup = new ButtonGroup();

		bmpLine5BtnGroup = new ButtonGroup();

		bmpLine6BtnGroup = new ButtonGroup();

		bmpLine7BtnGroup = new ButtonGroup();

		bmpLine8BtnGroup = new ButtonGroup();

		bmpLine9BtnGroup = new ButtonGroup();
		

		

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

		
		JPanel swpppPanel = new JPanel();
		tabbedPane.addTab("SWPPP Information", null, swpppPanel, null);
		swpppPanel.setLayout(null);

		line1Text = new JTextArea(("1. For a nonlinear project, is a sign or other notice: \n"
				+ "a) Posted Conspicuously near the main entrance of the \n"
				+ "construction site or if not feasible, \n"
				+ "b) Posted in a local public building such as the town hall or \n"
				+ "public library \n"
				+ "For linear projects, is a sign or other notice posted at a publicly \n"
				+ "accessible location near the active construction project?"));
		
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

		// line 2
		line2Text = new JTextArea("Is a copy of the permit attached?");
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

		// line 3
		line3Text = new JTextArea("Is the current location of the SWPPP and names and telephone\n"
				+ " numbers of a contact person for scheduling viewing times shown?");
		line3Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line3Text.setEditable(false);
		line3Text.setBounds(14, 161, 318, 32);
		swpppPanel.add(line3Text);

		line3yes = new JRadioButton("Yes");
		line3yes.setBounds(338, 164, 50, 23);
		swpppPanel.add(line3yes);

		line3no = new JRadioButton("No");
		line3no.setBounds(390, 164, 44, 23);
		swpppPanel.add(line3no);

		line3na = new JRadioButton("N/A");
		line3na.setBounds(438, 164, 50, 23);
		swpppPanel.add(line3na);
		line3btnGroup.add(line3yes);
		line3btnGroup.add(line3no);
		line3btnGroup.add(line3na);

		// line 4
		line4Text = new JTextArea("2. Does a copy of the SWPPP and accompanying sediment and \r\nerosion control drawings exist on the construction site?");
		line4Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line4Text.setEditable(false);
		line4Text.setBounds(14, 197, 318, 32);
		swpppPanel.add(line4Text);

		line4yes = new JRadioButton("Yes");
		line4yes.setBounds(338, 195, 50, 23);
		swpppPanel.add(line4yes);

		line4no = new JRadioButton("No");
		line4no.setBounds(390, 195, 44, 23);
		swpppPanel.add(line4no);

		line4na = new JRadioButton("N/A");
		line4na.setBounds(438, 195, 50, 23);
		swpppPanel.add(line4na);
		line4btnGroup.add(line4yes);
		line4btnGroup.add(line4no);
		line4btnGroup.add(line4na);

		// line 5
		line5Text = new JTextArea("Is the discharge permit on the construction site?");
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

		// line6
		line6Text = new JTextArea("Is the discharge permit acknowledgement letter on the \n"
				+ "construction site?");
		line6Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line6Text.setEditable(false);
		line6Text.setBounds(14, 262, 318, 32);
		swpppPanel.add(line6Text);

		line6yes = new JRadioButton("Yes");
		line6yes.setBounds(338, 260, 50, 23);
		swpppPanel.add(line6yes);

		line6no = new JRadioButton("No");
		line6no.setBounds(390, 259, 44, 23);
		swpppPanel.add(line6no);

		line6na = new JRadioButton("N/A");
		line6na.setBounds(438, 259, 50, 23);
		swpppPanel.add(line6na);
		line6btnGroup.add(line6yes);
		line6btnGroup.add(line6no);
		line6btnGroup.add(line6na);

		// line 7

		line7Text = new JTextArea("Are the SWPPP and/or accompanying sediment and erosion \n"
				+ "control drawings updated and documented?");
		line7Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line7Text.setEditable(false);
		line7Text.setBounds(13, 301, 318, 32);
		swpppPanel.add(line7Text);

		line7yes = new JRadioButton("Yes");
		line7yes.setBounds(338, 299, 50, 23);
		swpppPanel.add(line7yes);

		line7no = new JRadioButton("No");
		line7no.setBounds(390, 299, 44, 23);
		swpppPanel.add(line7no);

		line7na = new JRadioButton("N/A");
		line7na.setBounds(438, 299, 50, 23);
		swpppPanel.add(line7na);
		line7btnGroup.add(line7yes);
		line7btnGroup.add(line7no);
		line7btnGroup.add(line7na);

		// line 8
		line8Text = new JTextArea("3. Do inspection records exist on the construction sites?");
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

		// line 9

		line9Text = new JTextArea("Has the frequency of inspections occured as specified in the \n"
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

		// line 10
		line10Text = new JTextArea("Have all previous inspection items been addressed and\n"
				+ " documented within seven (7) calendar days after an inspection?");
		
		line10Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line10Text.setEditable(false);
		line10Text.setBounds(10, 404, 318, 32);
		swpppPanel.add(line10Text);

		line10yes = new JRadioButton("Yes");
		line10yes.setBounds(338, 402, 50, 23);
		swpppPanel.add(line10yes);

		line10no = new JRadioButton("No");
		line10no.setBounds(390, 402, 44, 23);
		swpppPanel.add(line10no);

		line10na = new JRadioButton("N/A");
		line10na.setBounds(438, 402, 50, 23);
		swpppPanel.add(line10na);
		line10btnGroup.add(line10yes);
		line10btnGroup.add(line10no);
		line10btnGroup.add(line10na);

		// line 11
		line11Text = new JTextArea("4. Do climatic records exist since the last inspection?");
		line11Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		line11Text.setEditable(false);
		line11Text.setBounds(11, 442, 318, 18);
		swpppPanel.add(line11Text);

		line11yes = new JRadioButton("Yes");
		line11yes.setBounds(338, 440, 50, 23);
		swpppPanel.add(line11yes);

		line11no = new JRadioButton("No");
		line11no.setBounds(390, 440, 44, 23);
		swpppPanel.add(line11no);

		line11na = new JRadioButton("N/A");
		line11na.setBounds(438, 440, 50, 23);
		swpppPanel.add(line11na);
		line11btnGroup.add(line11yes);
		line11btnGroup.add(line11no);
		line11btnGroup.add(line11na);

		JLabel lblNewLabel = new JLabel("Comments:");
		lblNewLabel.setBounds(548, 11, 68, 14);
		swpppPanel.add(lblNewLabel);

		line1comment = new JTextArea();
		line1comment.setBounds(494, 29, 174, 97);
		swpppPanel.add(line1comment);
		line1comment.setColumns(10);

		line2comment = new JTextArea();
		line2comment.setColumns(10);
		line2comment.setBounds(494, 137, 174, 19);
		swpppPanel.add(line2comment);

		line3comment = new JTextArea();
		line3comment.setBounds(494, 161, 174, 30);
		swpppPanel.add(line3comment);
		line3comment.setColumns(10);

		line4comment =new JTextArea();
		line4comment.setBounds(494, 196, 174, 33);
		swpppPanel.add(line4comment);
		line4comment.setColumns(10);

		line5comment = new JTextArea();
		line5comment.setColumns(10);
		line5comment.setBounds(494, 232, 174, 23);
		swpppPanel.add(line5comment);

		line6comment = new JTextArea();
		line6comment.setColumns(10);
		line6comment.setBounds(494, 261, 174, 30);
		swpppPanel.add(line6comment);

		line7comment = new JTextArea();
		line7comment.setColumns(10);
		line7comment.setBounds(494, 300, 174, 30);
		swpppPanel.add(line7comment);

		line8comment = new JTextArea();
		line8comment.setColumns(10);
		line8comment.setBounds(493, 338, 174, 19);
		swpppPanel.add(line8comment);

		line9comment = new JTextArea();
		line9comment.setColumns(10);
		line9comment.setBounds(494, 365, 174, 30);
		swpppPanel.add(line9comment);

		line10comment = new JTextArea();
		line10comment.setColumns(10);
		line10comment.setBounds(493, 404, 174, 32);
		swpppPanel.add(line10comment);

		line11comment = new JTextArea();
		line11comment.setColumns(10);
		line11comment.setBounds(494, 441, 174, 19);
		swpppPanel.add(line11comment);
		
		
		// BMP line 1
		JPanel bmpPanel = new JPanel();
		tabbedPane.addTab("BMP/Housekeeping Information", null, bmpPanel, null);
		bmpPanel.setLayout(null);

		bmpLine1Text = new JTextArea();
		bmpLine1Text
				.setText("5. Are offsite flows entering the construction site?");
		bmpLine1Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine1Text.setEditable(false);
		bmpLine1Text.setBounds(14, 30, 318, 18);
		bmpPanel.add(bmpLine1Text);

		bmpLine1yes = new JRadioButton("Yes");
		bmpLine1yes.setBounds(338, 30, 50, 23);
		bmpPanel.add(bmpLine1yes);

		bmpLine1no = new JRadioButton("No");
		bmpLine1no.setBounds(390, 30, 44, 23);
		bmpPanel.add(bmpLine1no);

		bmpLine1na = new JRadioButton("N/A");
		bmpLine1na.setBounds(438, 30, 50, 23);
		bmpPanel.add(bmpLine1na);
		bmpLine1BtnGroup.add(bmpLine1yes);
		bmpLine1BtnGroup.add(bmpLine1no);
		bmpLine1BtnGroup.add(bmpLine1na);

		bmpLine1Comment = new JTextArea();
		bmpLine1Comment.setColumns(10);
		bmpLine1Comment.setBounds(494, 30, 174, 19);
		bmpPanel.add(bmpLine1Comment);
		
		// BMP line 2
		bmpLine2Text = new JTextArea();
		bmpLine2Text
				.setText("6. Is there evidence of, or the potential for, increased polutant \n"
						+ "(e.g., sediment, fuel, concrete waste, portable toilet wasted, etc.) loading \n"
						+ "to enter the storm water conveyance system due to the lack of \n"
						+ "maintenance or improper BMP installation?");
		bmpLine2Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine2Text.setEditable(false);
		bmpLine2Text.setBounds(14, 55, 318, 60);
		bmpPanel.add(bmpLine2Text);

		bmpLine2yes = new JRadioButton("Yes");
		bmpLine2yes.setBounds(338, 55, 50, 23);
		bmpPanel.add(bmpLine2yes);

		bmpLine2no = new JRadioButton("No");
		bmpLine2no.setBounds(390, 55, 44, 23);
		bmpPanel.add(bmpLine2no);

		bmpLine2na = new JRadioButton("N/A");
		bmpLine2na.setBounds(438, 55, 50, 23);
		bmpPanel.add(bmpLine2na);
		bmpLine2BtnGroup.add(bmpLine2yes);
		bmpLine2BtnGroup.add(bmpLine2no);
		bmpLine2BtnGroup.add(bmpLine2na);

		bmpLine2Comment = new JTextArea();
		bmpLine2Comment.setColumns(10);
		bmpLine2Comment.setBounds(494, 54, 174, 61);
		bmpPanel.add(bmpLine2Comment);

		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(548, 11, 74, 14);
		bmpPanel.add(lblComments);

		// BMP Line 3
		bmpLine3Text = new JTextArea();
		bmpLine3Text
				.setText("7. Do installation, repair and/or maintenance of sediment control \n"
						+ "BMPs need to occur?");
		bmpLine3Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine3Text.setEditable(false);
		bmpLine3Text.setBounds(14, 124, 318, 32);
		bmpPanel.add(bmpLine3Text);

		bmpLine3yes = new JRadioButton("Yes");
		bmpLine3yes.setBounds(338, 122, 50, 23);
		bmpPanel.add(bmpLine3yes);

		bmpLine3no = new JRadioButton("No");
		bmpLine3no.setBounds(390, 122, 44, 23);
		bmpPanel.add(bmpLine3no);

		bmpLine3na = new JRadioButton("N/A");
		bmpLine3na.setBounds(438, 122, 50, 23);
		bmpPanel.add(bmpLine3na);
		bmpLine3BtnGroup.add(bmpLine3yes);
		bmpLine3BtnGroup.add(bmpLine3no);
		bmpLine3BtnGroup.add(bmpLine3na);

		bmpLine3Comment = new JTextArea();
		bmpLine3Comment.setColumns(10);
		bmpLine3Comment.setBounds(494, 123, 174, 33);
		bmpPanel.add(bmpLine3Comment);

		// BMP line 4
		bmpLine4Text = new JTextArea();
		bmpLine4Text
				.setText("8. Do installations, repair and/or maintenance of erosion control \r\nBMPs need to occur?");
		bmpLine4Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine4Text.setEditable(false);
		bmpLine4Text.setBounds(14, 164, 318, 32);
		bmpPanel.add(bmpLine4Text);

		bmpLine4yes = new JRadioButton("Yes");
		bmpLine4yes.setBounds(338, 162, 50, 23);
		bmpPanel.add(bmpLine4yes);

		bmpLine4no = new JRadioButton("No");
		bmpLine4no.setBounds(390, 162, 44, 23);
		bmpPanel.add(bmpLine4no);

		bmpLine4na = new JRadioButton("N/A");
		bmpLine4na.setBounds(438, 162, 50, 23);
		bmpPanel.add(bmpLine4na);
		bmpLine4BtnGroup.add(bmpLine4yes);
		bmpLine4BtnGroup.add(bmpLine4no);
		bmpLine4BtnGroup.add(bmpLine4na);

		bmpLine4Comment = new JTextArea();
		bmpLine4Comment.setColumns(10);
		bmpLine4Comment.setBounds(494, 163, 174, 33);
		bmpPanel.add(bmpLine4Comment);

		// BMP Line 5

		bmpLine5Text = new JTextArea();
		bmpLine5Text
				.setText("9. Is there evidence of sediment discharging off the construction \n"
						+ "site and onto downstream locations?");
		bmpLine5Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine5Text.setEditable(false);
		bmpLine5Text.setBounds(14, 206, 318, 32);
		bmpPanel.add(bmpLine5Text);

		bmpLine5yes = new JRadioButton("Yes");
		bmpLine5yes.setBounds(338, 204, 50, 23);
		bmpPanel.add(bmpLine5yes);

		bmpLine5no = new JRadioButton("No");
		bmpLine5no.setBounds(390, 204, 44, 23);
		bmpPanel.add(bmpLine5no);

		bmpLine5na = new JRadioButton("N/A");
		bmpLine5na.setBounds(438, 204, 50, 23);
		bmpPanel.add(bmpLine5na);
		bmpLine5BtnGroup.add(bmpLine5yes);
		bmpLine5BtnGroup.add(bmpLine5no);
		bmpLine5BtnGroup.add(bmpLine5na);

		bmpLine5Comment = new JTextArea();
		bmpLine5Comment.setColumns(10);
		bmpLine5Comment.setBounds(494, 205, 174, 33);
		bmpPanel.add(bmpLine5Comment);

		// BMP Line 6
		bmpLine6Text = new JTextArea();
		bmpLine6Text
				.setText("10. Are vehicles tracking sediment off the construction site?");
		bmpLine6Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine6Text.setEditable(false);
		bmpLine6Text.setBounds(14, 246, 318, 18);
		bmpPanel.add(bmpLine6Text);

		bmpLine6yes = new JRadioButton("Yes");
		bmpLine6yes.setBounds(338, 244, 50, 23);
		bmpPanel.add(bmpLine6yes);

		bmpLine6no = new JRadioButton("No");
		bmpLine6no.setBounds(390, 244, 44, 23);
		bmpPanel.add(bmpLine6no);

		bmpLine6na = new JRadioButton("N/A");
		bmpLine6na.setBounds(438, 244, 50, 23);
		bmpPanel.add(bmpLine6na);
		bmpLine6BtnGroup.add(bmpLine6yes);
		bmpLine6BtnGroup.add(bmpLine6no);
		bmpLine6BtnGroup.add(bmpLine6na);

		bmpLine6Comment = new JTextArea();
		bmpLine6Comment.setColumns(10);
		bmpLine6Comment.setBounds(494, 245, 174, 19);
		bmpPanel.add(bmpLine6Comment);

		// BMP Line 7
		bmpLine7Text = new JTextArea();
		bmpLine7Text
				.setText("11. If applicable, is soil, construction material, landscaping items, \n"
						+ " or other debris evident on the streets?");
		bmpLine7Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine7Text.setEditable(false);
		bmpLine7Text.setBounds(14, 273, 318, 32);
		bmpPanel.add(bmpLine7Text);

		bmpLine7yes = new JRadioButton("Yes");
		bmpLine7yes.setBounds(338, 271, 50, 23);
		bmpPanel.add(bmpLine7yes);

		bmpLine7no = new JRadioButton("No");
		bmpLine7no.setBounds(390, 271, 44, 23);
		bmpPanel.add(bmpLine7no);

		bmpLine7na = new JRadioButton("N/A");
		bmpLine7na.setBounds(438, 271, 50, 23);
		bmpPanel.add(bmpLine7na);
		bmpLine7BtnGroup.add(bmpLine7yes);
		bmpLine7BtnGroup.add(bmpLine7no);
		bmpLine7BtnGroup.add(bmpLine7na);

		bmpLine7Comment = new JTextArea();
		bmpLine7Comment.setColumns(10);
		bmpLine7Comment.setBounds(494, 272, 174, 33);
		bmpPanel.add(bmpLine7Comment);

		// BMP Line 8
		bmpLine8Text = new JTextArea();
		bmpLine8Text
				.setText("12. Do locations exist where consideration of installin additional \n"
						+ "BMP not found in the SWPPP should occur?");
		bmpLine8Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine8Text.setEditable(false);
		bmpLine8Text.setBounds(14, 314, 318, 32);
		bmpPanel.add(bmpLine8Text);

		bmpLine8yes = new JRadioButton("Yes");
		bmpLine8yes.setBounds(338, 312, 50, 23);
		bmpPanel.add(bmpLine8yes);

		bmpLine8no = new JRadioButton("No");
		bmpLine8no.setBounds(390, 312, 44, 23);
		bmpPanel.add(bmpLine8no);

		bmpLine8na = new JRadioButton("N/A");
		bmpLine8na.setBounds(438, 312, 50, 23);
		bmpPanel.add(bmpLine8na);
		bmpLine8BtnGroup.add(bmpLine8yes);
		bmpLine8BtnGroup.add(bmpLine8no);
		bmpLine8BtnGroup.add(bmpLine8na);

		bmpLine8Comment = new JTextArea();
		bmpLine8Comment.setColumns(10);
		bmpLine8Comment.setBounds(494, 313, 174, 33);
		bmpPanel.add(bmpLine8Comment);

		// BMP Line 9

		bmpLine9Text = new JTextArea();
		bmpLine9Text
				.setText("13. Do locations exist where consideration of removing existing \n"
						+ "BMPs identified and shown in the SWPPP can occur?");
		bmpLine9Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine9Text.setEditable(false);
		bmpLine9Text.setBounds(14, 356, 318, 32);
		bmpPanel.add(bmpLine9Text);

		bmpLine9na = new JRadioButton("Yes");
		bmpLine9na.setBounds(338, 354, 50, 23);
		bmpPanel.add(bmpLine9na);

		bmpLine9no = new JRadioButton("No");
		bmpLine9no.setBounds(390, 354, 44, 23);
		bmpPanel.add(bmpLine9no);

		bmpLine9na = new JRadioButton("N/A");
		bmpLine9na.setBounds(438, 354, 50, 23);
		bmpPanel.add(bmpLine9na);
		bmpLine9BtnGroup.add(bmpLine9yes);
		bmpLine9BtnGroup.add(bmpLine9no);
		bmpLine9BtnGroup.add(bmpLine9na);

		bmpLine9Comment = new JTextArea();
		bmpLine9Comment.setColumns(10);
		bmpLine9Comment.setBounds(494, 355, 174, 33);
		bmpPanel.add(bmpLine9Comment);

		// BMP Line 10

		bmpLine10Text = new JTextArea();
		bmpLine10Text
				.setText("14. Does your site evaluation indicate a need to possibly update \n"
						+ "and document the SWPPP report and accompanying sediment \n"
						+ "erosion control drawings within the next seven (7) days?");
		bmpLine10Text.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bmpLine10Text.setEditable(false);
		bmpLine10Text.setBounds(14, 398, 318, 43);
		bmpPanel.add(bmpLine10Text);

		bmpLine10yes = new JRadioButton("Yes");
		bmpLine10yes.setBounds(338, 396, 50, 23);
		bmpPanel.add(bmpLine10yes);

		bmpLine10no = new JRadioButton("No");
		bmpLine10no.setBounds(390, 396, 44, 23);
		bmpPanel.add(bmpLine10no);

		bmpLine10na = new JRadioButton("N/A");
		bmpLine10na.setBounds(438, 396, 50, 23);
		bmpPanel.add(bmpLine10na);

		bmpLine10BtnGroup = new ButtonGroup();
		bmpLine10BtnGroup.add(bmpLine10yes);
		bmpLine10BtnGroup.add(bmpLine10no);
		bmpLine10BtnGroup.add(bmpLine10na);

		bmpLine10Comment = new JTextArea();
		bmpLine10Comment.setColumns(10);
		bmpLine10Comment.setBounds(494, 397, 174, 44);
		bmpPanel.add(bmpLine10Comment);
		
		//COMMENT PANEL
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JPanel commentPanel = new JPanel();
		tabbedPane.addTab("Comments", null, commentPanel, null);
				commentPanel.setLayout(new GridLayout(0,1, 0, 0));
				
				JLabel commentLabel = new JLabel("<html>   Identify the problem and its location. If appropriate (in general terms) what needs to be done. <br> However, only if qualified (e.g., you are a designer) should you be mandating specific BMPs to install. </html>");
				commentLabel.setBorder(BorderFactory.createTitledBorder("Detail Report"));
				commentPanel.add(commentLabel);
				comment1Text = new JTextArea();
				comment1Text.setText("1.    ");
				comment1Text.setLineWrap(true);
				comment1Text.setWrapStyleWord(true);
				comment1Text.setBorder(BorderFactory.createCompoundBorder(border, 
	    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		comment2Text = new JTextArea();
		comment2Text.setText("2.   ");
		comment2Text.setWrapStyleWord(true);
		comment2Text.setLineWrap(true);
		comment2Text.setBorder(BorderFactory.createCompoundBorder(border, 
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	
		
		comment3Text = new JTextArea();
		comment3Text.setText("3.   ");
		comment3Text.setWrapStyleWord(true);
		comment3Text.setLineWrap(true);
		
		comment3Text.setBorder(BorderFactory.createCompoundBorder(border, 
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		comment4Text = new JTextArea();
		comment4Text.setText("4.   ");
		comment4Text.setWrapStyleWord(true);
		comment4Text.setLineWrap(true);
		
		comment4Text.setBorder(BorderFactory.createCompoundBorder(border, 
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		comment5Text = new JTextArea();
		comment5Text.setText("OTHER COMMENTS:   ");
		comment5Text.setWrapStyleWord(true);
		comment5Text.setLineWrap(true);
		
		comment5Text.setBorder(BorderFactory.createCompoundBorder(border, 
			    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JScrollPane comment1Scroll = new JScrollPane();
		comment1Scroll.setViewportView(comment1Text);
		commentPanel.add(comment1Scroll);
		
		JScrollPane comment2Scroll = new JScrollPane();
		comment2Scroll.setViewportView(comment2Text);
		commentPanel.add(comment2Scroll);
		
		JScrollPane comment3Scroll = new JScrollPane();
		comment3Scroll.setViewportView(comment3Text);
		commentPanel.add(comment3Scroll);
		
		JScrollPane comment4Scroll = new JScrollPane();
		comment4Scroll.setViewportView(comment4Text);
		commentPanel.add(comment4Scroll);
		
		JScrollPane comment5Scroll = new JScrollPane();
		comment5Scroll.setViewportView(comment5Text);
		commentPanel.add(comment5Scroll);
		
		//Webcam Panel
				JPanel imagePanel = new JPanel();
				tabbedPane.addTab("Location Images", null, imagePanel, null);
				imagePanel.setLayout(new BorderLayout());
				wPicker = new WebcamPicker();
				imagePanel.add(wPicker, BorderLayout.NORTH);
				webcam = wPicker.getSelectedWebcam();
				if (webcam == null) {
					JOptionPane.showMessageDialog(null, "No webcam found on this device!", "Webcam Error", JOptionPane.ERROR_MESSAGE);
				}
				webcam.setViewSize(WebcamResolution.VGA.getSize());
				wPanel = new WebcamPanel(webcam, false);
				imagePanel.add(wPanel, BorderLayout.CENTER);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//validate SWPPPxx
				validateRadioGroup(line1btnGroup);
				validateRadioGroup(line2btnGroup);
				validateRadioGroup(line3btnGroup);
				validateRadioGroup(line4btnGroup);
				validateRadioGroup(line5btnGroup);
				validateRadioGroup(line6btnGroup);
				validateRadioGroup(line7btnGroup);
				validateRadioGroup(line8btnGroup);
				validateRadioGroup(line9btnGroup);
				validateRadioGroup(line10btnGroup);
				validateRadioGroup(line11btnGroup);
				
				//validate BMP
				
				validateRadioGroup(bmpLine1BtnGroup);
				validateRadioGroup(bmpLine2BtnGroup);
				validateRadioGroup(bmpLine3BtnGroup);
				validateRadioGroup(bmpLine4BtnGroup);
				validateRadioGroup(bmpLine5BtnGroup);
				validateRadioGroup(bmpLine6BtnGroup);
				validateRadioGroup(bmpLine7BtnGroup);
				validateRadioGroup(bmpLine8BtnGroup);
				validateRadioGroup(bmpLine9BtnGroup);
				validateRadioGroup(bmpLine10BtnGroup);
				
				
				if( notEmpty == true){
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int	 dialogRes = JOptionPane.showConfirmDialog(null, "Do you want to submit this report?", "Confirm", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (dialogRes == JOptionPane.YES_OPTION){
				Report report = new Report();
				report.setReportDate(reportInfoGUI.dateText.getText());
				report.setReportLocation(reportInfoGUI.siteText.getText());
				report.setInspector(inspector);
				//

				Database.submitReport(report);

				Swpppreport swpppReport = new Swpppreport();
				swpppReport.setSwpppLine1(getSelectedButtonText(line1btnGroup));
				swpppReport.setSwpppLine2(getSelectedButtonText(line2btnGroup));
				swpppReport.setSwpppLine3(getSelectedButtonText(line3btnGroup));
				swpppReport.setSwpppLine4(getSelectedButtonText(line4btnGroup));
				swpppReport.setSwpppLine5(getSelectedButtonText(line5btnGroup));
				swpppReport.setSwpppLine6(getSelectedButtonText(line6btnGroup));
				swpppReport.setSwpppLine7(getSelectedButtonText(line7btnGroup));
				swpppReport.setSwpppLine8(getSelectedButtonText(line8btnGroup));
				swpppReport.setSwpppLine9(getSelectedButtonText(line9btnGroup));
				swpppReport
						.setSwpppLine10(getSelectedButtonText(line10btnGroup));
				swpppReport
						.setSwpppLine11(getSelectedButtonText(line11btnGroup));
				swpppReport.setReport(report);

				Database.submitSwpppReport(swpppReport);
				
				BmpReport bmpReport = new BmpReport();
				bmpReport.setBmpLine1(getSelectedButtonText(bmpLine1BtnGroup));
				bmpReport.setBmpLine2(getSelectedButtonText(bmpLine2BtnGroup));
				bmpReport.setBmpLine3(getSelectedButtonText(bmpLine3BtnGroup));
				bmpReport.setBmpLine4(getSelectedButtonText(bmpLine4BtnGroup));
				bmpReport.setBmpLine5(getSelectedButtonText(bmpLine5BtnGroup));
				bmpReport.setBmpLine6(getSelectedButtonText(bmpLine6BtnGroup));
				bmpReport.setBmpLine7(getSelectedButtonText(bmpLine7BtnGroup));
				bmpReport.setBmpLine8(getSelectedButtonText(bmpLine8BtnGroup));
				bmpReport.setBmpLine9(getSelectedButtonText(bmpLine9BtnGroup));
				bmpReport.setBmpLine10(getSelectedButtonText(bmpLine10BtnGroup));
				bmpReport.setReport(report);
				
				
				Database.submitBmpReport(bmpReport);
				
				//Detailed Comment
				DetailedCommentReport dcReport = new DetailedCommentReport();
				dcReport.setComment1(comment1Text.getText());
				dcReport.setComment2(comment2Text.getText());
				dcReport.setComment3(comment3Text.getText());
				dcReport.setComment4(comment4Text.getText());
				dcReport.setOthercomment(comment5Text.getText());
				dcReport.setReport(report);
				
				Database.submitDetailedComment(dcReport);
				submitBtn.setEnabled(false);
				}
				
				else {
				}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Please make sure all options are selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		submitBtn.setBounds(10, 521, 112, 39);
		inspectionJFrame.getContentPane().add(submitBtn);

		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setBounds(498, 521, 112, 39);
		inspectionJFrame.getContentPane().add(exitBtn);
		
		JButton startCamera = new JButton("Start Camera");
		startCamera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread(){
					@Override
					public void run(){
						wPanel.start();
					}
				};
				t.setDaemon(true);
				t.start();
			}
		});
		startCamera.setBounds(132, 521, 112, 39);
		inspectionJFrame.getContentPane().add(startCamera);
		
		JButton btnSnap = new JButton("Snap");
		btnSnap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!wPanel.isStarted()){
					JOptionPane.showMessageDialog(null, "Camera is not yet started!", "Camera Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				String output = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.jpg'").format(new Date());
				String folderOutput = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
				String path = "C:\\InspectionImages\\"+folderOutput;
				createFolder(path);
				try{
					++photoNumCount;
					//File file = new File(String.format("C:\\InspectionImages\\capture-%d.jpg", System.currentTimeMillis()));
					File file = new File("C:\\InspectionImages\\"+folderOutput+"\\Inspection " +output);
					ImageIO.write(webcam.getImage(),"JPG", file);
					JOptionPane.showMessageDialog(null, "The picture has been saved at: \n" + file.getAbsolutePath(), "Screen cap", JOptionPane.INFORMATION_MESSAGE);
					tempImageURL = file.getAbsolutePath();
					ImageGUI imageFrame = new ImageGUI();
					imageFrame.imageFrame.setVisible(true);
					
					
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			}
		});
		btnSnap.setBounds(254, 521, 112, 39);
		inspectionJFrame.getContentPane().add(btnSnap);
		
		getPDFBtn = new JButton("Get PDF");
		getPDFBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				swppTextArea = new ArrayList<JTextArea>();
				swppTextArea.add(line1Text);
				swppTextArea.add(line2Text);
				swppTextArea.add(line3Text);
				swppTextArea.add(line4Text);
				swppTextArea.add(line5Text);
				swppTextArea.add(line6Text);
				swppTextArea.add(line7Text);
				swppTextArea.add(line8Text);
				swppTextArea.add(line9Text);
				swppTextArea.add(line10Text);
				swppTextArea.add(line11Text);
				
				swpppBtnGroup = new ArrayList<ButtonGroup>();
				swpppBtnGroup.add(line1btnGroup);
				swpppBtnGroup.add(line2btnGroup);
				swpppBtnGroup.add(line3btnGroup);
				swpppBtnGroup.add(line4btnGroup);
				swpppBtnGroup.add(line5btnGroup);
				swpppBtnGroup.add(line6btnGroup);
				swpppBtnGroup.add(line7btnGroup);
				swpppBtnGroup.add(line8btnGroup);
				swpppBtnGroup.add(line9btnGroup);
				swpppBtnGroup.add(line10btnGroup);
				swpppBtnGroup.add(line11btnGroup);
				
				swpppCommentList = new ArrayList<JTextArea>();
				swpppCommentList.add(line1comment);
				swpppCommentList.add(line2comment);
				swpppCommentList.add(line3comment);
				swpppCommentList.add(line4comment);
				swpppCommentList.add(line5comment);
				swpppCommentList.add(line6comment);
				swpppCommentList.add(line7comment);
				swpppCommentList.add(line8comment);
				swpppCommentList.add(line9comment);
				swpppCommentList.add(line10comment);
				swpppCommentList.add(line11comment);
				
				//bmp
				
				bmpTextList = new ArrayList<JTextArea>();
				bmpTextList.add(bmpLine1Text);
				bmpTextList.add(bmpLine2Text);
				bmpTextList.add(bmpLine3Text);
				bmpTextList.add(bmpLine4Text);
				bmpTextList.add(bmpLine5Text);
				bmpTextList.add(bmpLine6Text);
				bmpTextList.add(bmpLine7Text);
				bmpTextList.add(bmpLine8Text);
				bmpTextList.add(bmpLine9Text);
				bmpTextList.add(bmpLine10Text);
				
				bmpCommentList = new ArrayList<JTextArea>();
				bmpCommentList.add(bmpLine1Comment);
				bmpCommentList.add(bmpLine2Comment);
				bmpCommentList.add(bmpLine3Comment);
				bmpCommentList.add(bmpLine4Comment);
				bmpCommentList.add(bmpLine5Comment);
				bmpCommentList.add(bmpLine6Comment);
				bmpCommentList.add(bmpLine7Comment);
				bmpCommentList.add(bmpLine8Comment);
				bmpCommentList.add(bmpLine9Comment);
				bmpCommentList.add(bmpLine10Comment);
				
				bmpBtnGroupList = new ArrayList<ButtonGroup>();
				bmpBtnGroupList.add(bmpLine1BtnGroup);
				bmpBtnGroupList.add(bmpLine2BtnGroup);
				bmpBtnGroupList.add(bmpLine3BtnGroup);
				bmpBtnGroupList.add(bmpLine4BtnGroup);
				bmpBtnGroupList.add(bmpLine5BtnGroup);
				bmpBtnGroupList.add(bmpLine6BtnGroup);
				bmpBtnGroupList.add(bmpLine7BtnGroup);
				bmpBtnGroupList.add(bmpLine8BtnGroup);
				bmpBtnGroupList.add(bmpLine9BtnGroup);
				bmpBtnGroupList.add(bmpLine10BtnGroup);
				
				
				
				
				// start to create pdf
				Document document = new Document(PageSize.A4.rotate());
				try{
					PdfWriter.getInstance(document, new FileOutputStream("OIAReport.pdf"));
					com.itextpdf.text.Font font = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
					com.itextpdf.text.Font font1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
					com.itextpdf.text.Font font2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, com.itextpdf.text.Font.UNDERLINE);
					document.open();
					Image logo = Image.getInstance("C:\\logo.png");
					document.add(logo);
					Paragraph p1 = new Paragraph("OIA South Terminal Expansion", font);
					p1.setAlignment(Element.ALIGN_CENTER);
					document.add(p1);
					Chunk site = new Chunk(reportInfoGUI.siteText.getText() + Chunk.NEWLINE, font2);
					Chunk date = new Chunk (reportInfoGUI.dateText.getText() + Chunk.NEWLINE, font2);
					Chunk name = new Chunk (reportInfoGUI.inspectorText.getText() + Chunk.NEWLINE, font2);
					Chunk weather = new Chunk (reportInfoGUI.weatherText.getText() + Chunk.NEWLINE, font2);
					
					Phrase phrase1 = new Phrase(30);
					phrase1.add(new Chunk("Site Name: ", font1));
					phrase1.add(site);
					phrase1.add(new Chunk("Date of Evaluation: ", font1));
		
					phrase1.add(date);
					phrase1.add(new Chunk("Completed by: ", font1));
					phrase1.add(name);
					phrase1.add(new Chunk("Existing Weather Conditions: ", font1));
					phrase1.add(weather);
					Paragraph p2 = new Paragraph(phrase1);
					document.add(p2);
					document.newPage();
					//new page
					PdfPTable swppptable = new PdfPTable(new float[] {10,2,5});
					 createInformationTable("SWPPP Information", swppptable, swpppCommentList, swppTextArea, swpppBtnGroup);
					 document.add(swppptable);
					 document.newPage();
					 PdfPTable bmptable = new PdfPTable(new float[] {10,2,5});
					 createInformationTable("BMP Information",bmptable, bmpCommentList, bmpTextList, bmpBtnGroupList);
					 document.add(bmptable);
					 document.newPage();
					 
					 PdfPTable commentTable = new PdfPTable(new float[] {1, 10});
					 commentTable.addCell("a");
					 commentTable.addCell("b");
					 commentTable.addCell("a");
					 commentTable.addCell("b");
					 
					 document.add(commentTable);
					document.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		getPDFBtn.setBounds(376, 521, 112, 39);
		inspectionJFrame.getContentPane().add(getPDFBtn);

	}

	// Method to find the selected button in a button group.
	private String getSelectedButtonText(ButtonGroup buttonGroup) {

		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;

	}

	private void validateRadioGroup(ButtonGroup buttonGroup){
		for (Enumeration<AbstractButton> btns = buttonGroup.getElements(); btns.hasMoreElements();){
			AbstractButton btn = (JRadioButton) btns.nextElement();
				if (btn.isSelected()){
					notEmpty = true;
					break;
				}
				else{
					notEmpty = false;
				}
		}
	}
	
	private static boolean createFolder(String theFilePath)
	{
	    boolean result = false;

	    File directory = new File(theFilePath);

	    if (directory.exists()) {
	        System.out.println("Folder already exists");
	    } else {
	        result = directory.mkdirs();
	    }

	    return result;
	}
	
	private void createInformationTable(String tableTitle, PdfPTable table, ArrayList<JTextArea> comment, ArrayList<JTextArea> detail, ArrayList<ButtonGroup> radioGroup){
		
		Phrase phrase = new Phrase(tableTitle, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
		table.getDefaultCell().setPadding(3);
		 table.getDefaultCell().setUseAscender(true);
		 table.getDefaultCell().setUseDescender(true);
		 table.getDefaultCell().setColspan(3);
		 table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.addCell(phrase);
		 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 table.getDefaultCell().setColspan(1);
		 table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		 table.getDefaultCell().setPadding(5);
		 table.addCell("Details");
		 table.addCell("Status");
		 table.addCell("Comments");
		 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 for(int i = 0 ; i < detail.size(); i++){
			 table.addCell(detail.get(i).getText());
			 table.addCell(getSelectedButtonText(radioGroup.get(i)));
			 table.addCell(comment.get(i).getText());
		 }
	}
}

