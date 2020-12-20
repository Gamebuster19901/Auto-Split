package com.gamebuster19901.autosplit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import static javax.swing.JFrame.DISPOSE_ON_CLOSE;

public class Main {

	private static final Dimension MIN_SIZE = new Dimension(622, 490);
	public static final Main INSTANCE;
	static {
		try {
			INSTANCE = new Main();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			throw new Error(e);
		}
	}
	
	final JPanel centralWidget;
	final JLabel splitImageFolderLabel;
	final JTextField splitImageFolderLineEdit;
	final JButton browseButton;
	
	private final Graphics graphics = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB).getGraphics();
	private final FontMetrics fontMetrics = graphics.getFontMetrics();
	
	public static void main(String[] args) {}
	
	public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		JFrame frame = new JFrame();
		
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
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
		centralWidget.setName("centralWidget");
		centralWidget.setLayout(null);
		
		frame.add(centralWidget);
		
		splitImageFolderLabel = new JLabel();
		splitImageFolderLabel.setText("Split Image Folder:");
		splitImageFolderLabel.setFont(fontMetrics.getFont());
		splitImageFolderLabel.setLocation(16, 90);
		splitImageFolderLabel.setSize(splitImageFolderLabel.getPreferredSize());
		splitImageFolderLabel.setBounds(90, 13, getStringWidth(splitImageFolderLabel), 16);
		
		centralWidget.add(splitImageFolderLabel);
		
		splitImageFolderLineEdit = new JTextField();
		splitImageFolderLineEdit.setBackground(Color.GRAY);
		splitImageFolderLineEdit.setForeground(Color.WHITE);
		splitImageFolderLineEdit.setSelectedTextColor(Color.BLACK);
		splitImageFolderLineEdit.setText("Select a folder -->");
		splitImageFolderLineEdit.setBounds(new Rectangle(rightOf(splitImageFolderLabel, 3), 11, 247, 20));
		splitImageFolderLineEdit.setEditable(false);
		splitImageFolderLineEdit.setName("splitImageFolderLineEdit");
		
		centralWidget.add(splitImageFolderLineEdit);
		
		browseButton = new JButton();
		browseButton.setText("Browse");
		browseButton.setFont(fontMetrics.getFont());
		browseButton.setFocusable(false);
		browseButton.setName("browseButton");
		browseButton.setBounds(new Rectangle(rightOf(splitImageFolderLineEdit, 6), 9, calculateButtonWidth(browseButton), 24));
		centralWidget.add(browseButton);
		
		frame.setVisible(true);
	}
	
	private int getStringWidth(JLabel label) {
		return label.getFontMetrics(label.getFont()).stringWidth(label.getText());
	}
	
	private int calculateButtonWidth(JButton button) {
		return button.getFontMetrics(button.getFont()).stringWidth(button.getText()) + (button.getBorder().getBorderInsets(button).left * 2);
	}
	
	private int getStringWidth(JComponent component, String text) {
		return component.getFontMetrics(component.getFont()).stringWidth(text);
	}
	
	private int rightOf(JComponent component) {
		return component.getX() + component.getWidth();
	}
	
	private int rightOf(JComponent component, int spacing) {
		return rightOf(component) + spacing;
	}
	
}
