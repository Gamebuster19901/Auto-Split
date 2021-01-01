package com.gamebuster19901.autosplit.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GImagePanel extends JPanel {

	private BufferedImage image;
	{
		try {
			image = ImageIO.read(getClass().getResource("/noImage.png"));
		} catch (Exception e) {
			System.err.println("Unable to read default image... using blank image instead.");
			e.printStackTrace();
			image = new BufferedImage(50, 50, TYPE_INT_ARGB);
		}
		this.setBackground(Color.MAGENTA);
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0, 0, image.getWidth(), image.getHeight(), this);
	}
	
}
