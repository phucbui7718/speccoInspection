package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import model.Inspector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class reportInfoGUI{
	JFrame reportFrame;
	private JTextField siteText;
	private JTextField dateText;
	private JTextField weatherText;
	private JTextField inspectorText;

	/**
	 * Create the frame.
	 */
	public reportInfoGUI(Inspector inspector) {
		reportFrame = new JFrame();
		reportFrame.setTitle("Report Information");
		reportFrame.setResizable(false);
		reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reportFrame.setBounds(100, 100, 315, 270);
		reportFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Report Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(65, 26, 188, 24);
		reportFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(21, 66, 61, 14);
		reportFrame.getContentPane().add(lblNewLabel_1);
		
		siteText = new JTextField();
		siteText.setBounds(143, 60, 132, 20);
		reportFrame.getContentPane().add(siteText);
		siteText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Evaluation:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(21, 97, 112, 14);
		reportFrame.getContentPane().add(lblNewLabel_2);
		
		dateText = new JTextField();
		dateText.setColumns(10);
		dateText.setBounds(143, 91, 132, 20);
		reportFrame.getContentPane().add(dateText);
		
		JLabel lblExistingWeather = new JLabel("Existing Weather:");
		lblExistingWeather.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExistingWeather.setBounds(21, 129, 112, 14);
		reportFrame.getContentPane().add(lblExistingWeather);
		
		weatherText = new JTextField();
		weatherText.setColumns(10);
		weatherText.setBounds(143, 125, 132, 20);
		reportFrame.getContentPane().add(weatherText);
		
		JLabel lblCompletedBy = new JLabel("Completed By:");
		lblCompletedBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCompletedBy.setBounds(21, 159, 112, 14);
		reportFrame.getContentPane().add(lblCompletedBy);
		
		inspectorText = new JTextField(inspector.getInspFirstname() + ", " + inspector.getInspLastname());
		inspectorText.setColumns(10);
		inspectorText.setBounds(143, 156, 132, 20);
		inspectorText.setEditable(false);
		reportFrame.getContentPane().add(inspectorText);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(210, 187, 89, 23);
		reportFrame.getContentPane().add(exitBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siteText.setText("");
				dateText.setText("");
				weatherText.setText("");
			}
		});
		clearBtn.setBounds(111, 187, 89, 23);
		reportFrame.getContentPane().add(clearBtn);
		
		JButton createBtn = new JButton("Proceed");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			InspectionGUI inspFrame = new InspectionGUI();
			inspFrame.inspectionJFrame.setVisible(true);
			reportFrame.dispose();
			}
		});
		createBtn.setBounds(10, 187, 89, 23);
		reportFrame.getContentPane().add(createBtn);
		
	}
}
