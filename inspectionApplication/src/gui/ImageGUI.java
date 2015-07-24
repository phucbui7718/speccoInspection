package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import sun.font.CreatedFontTracker;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JButton;

import model.inspImages;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageGUI{
	JFrame imageFrame = new JFrame();
	private JPanel contentPane;
	private final JLabel photoNumber = new JLabel("");
	private final JLabel image;
	private final JLabel dateTaken;
	private JTextArea directionTaken;
	private JTextArea description;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public ImageGUI() {
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		imageFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		imageFrame.setBounds(100, 100, 810, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		imageFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image = new JLabel("");
		image.setBounds(152, 11, 632, 489);
		contentPane.add(image);
		photoNumber.setHorizontalAlignment(SwingConstants.CENTER);
		photoNumber.setBounds(10, 11, 132, 31);
		photoNumber.setText(InspectionGUI.photoNumCount.toString());
		photoNumber.setBorder(BorderFactory.createTitledBorder("Photo No."));
		image.setIcon(new ImageIcon(InspectionGUI.tempImageURL));
		contentPane.add(photoNumber);
		image.setBorder(BorderFactory.createCompoundBorder(border, 
	    BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		
		
		// date label
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		
		dateTaken = new JLabel("0");
		dateTaken.setHorizontalAlignment(SwingConstants.CENTER);
		dateTaken.setBorder(BorderFactory.createTitledBorder("Date"));
		dateTaken.setText(df.format(date));
		dateTaken.setBounds(10, 47, 132, 31);
		contentPane.add(dateTaken);
		
		directionTaken= new JTextArea();
		directionTaken.setFont(new Font("Tahoma", Font.PLAIN, 11));
		directionTaken.setBorder(BorderFactory.createTitledBorder("Direction Photo Taken"));
		directionTaken.setBounds(10, 86, 132, 85);
		directionTaken.setWrapStyleWord(true);
		directionTaken.setLineWrap(true);
		contentPane.add(directionTaken);
		
		description = new JTextArea();
		description.setFont(new Font("Tahoma", Font.PLAIN, 11));
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setBorder(BorderFactory.createTitledBorder("Description"));
		description.setBounds(10, 181, 132, 170);
		contentPane.add(description);
		
		btnNewButton = new JButton("Take another");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inspImages inspPhoto = new inspImages();
				inspPhoto.setPhotoid(InspectionGUI.photoNumCount);
				inspPhoto.setImgpath(InspectionGUI.tempImageURL);
				inspPhoto.setDate(dateTaken.getText());
				inspPhoto.setDirection(directionTaken.getText());
				inspPhoto.setDescription(description.getText());
				InspectionGUI.imageList.add(inspPhoto);
				System.out.println(InspectionGUI.imageList.size());
				imageFrame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 358, 132, 50);
		contentPane.add(btnNewButton);
	}
}
