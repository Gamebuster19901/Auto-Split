package com.gamebuster19901.autosplit.swing;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GImagePanel extends JPanel {

	private Rectangle preferredSize = new Rectangle(this.getBounds());
	private Rectangle maximumSize = new Rectangle(this.getBounds());
	private BufferedImage image;
	{
		try {
			setImage(ImageIO.read(getClass().getResource("/noImage.png")));
		} catch (Exception e) {
			System.err.println("Unable to read default image... using blank image instead.");
			e.printStackTrace();
			setImage(new BufferedImage(50, 50, TYPE_INT_ARGB));
		}
		this.setBackground(Color.MAGENTA);
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	@Override
	public void setPreferredSize(Dimension dimension) {
		super.setPreferredSize(dimension);
		preferredSize = new Rectangle(dimension);
	}
	
	@Override
	public void setMaximumSize(Dimension dimension) {
		super.setMaximumSize(dimension);
		maximumSize = new Rectangle(dimension);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		this.setMaximumSize(new Dimension(width, height));
		this.setImage(image);
	}
	
	@Override
	public void setBounds(Rectangle r) {
		this.setMaximumSize(r.getSize());
		this.setImage(image);
	}
	
	public Dimension getScaledSize() {
		double scale = Math.min((double)maximumSize.getWidth() / (double)preferredSize.getWidth(), (double)maximumSize.getHeight() / (double)preferredSize.getHeight());
		return new Dimension((int)(preferredSize.getWidth() * scale), (int)(preferredSize.getHeight() * scale));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension scaledSize = getScaledSize();
		g.drawImage(image, 0, 0, (int)scaledSize.getWidth(), (int)scaledSize.getHeight(), 0, 0, image.getWidth(), image.getHeight(), this);
		System.out.println(this.getSize().toString());
	}
	
}
