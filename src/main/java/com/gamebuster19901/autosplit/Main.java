package com.gamebuster19901.autosplit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import static javax.swing.JFrame.DISPOSE_ON_CLOSE;

public class Main {

	private static final Dimension MIN_SIZE = new Dimension(622, 490);
	public static final Main INSTANCE = new Main();
	
	final JPanel centralWidget;
	//final JLabel splitImageFolderLabel;
	
	public static void main(String[] args) {}
	
	public Main() {
		JFrame frame = new JFrame();
		
		frame.setName("MainWindow");
		frame.setSize(MIN_SIZE);
		frame.setMinimumSize(MIN_SIZE);
		frame.setMaximumSize(MIN_SIZE); //TODO: See if this is necessary... This will be really small on 4k monitors
		
		try {
			frame.setIconImage(new ImageIcon(Main.class.getResource("/icon.png")).getImage());
		}
		catch(Exception e) {
			System.out.println("Could not retrieve window icon.");
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		centralWidget = new JPanel();
		centralWidget.setSize(MIN_SIZE);
		centralWidget.setBackground(Color.blue); //testing
		centralWidget.setName("centralWidget");
		centralWidget.setLayout(new BorderLayout());
		
		frame.add(centralWidget);
		
		frame.setVisible(true);
	}
	
}
