package com.gamebuster19901.autosplit.swing;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FontSettings {

	private final Graphics graphics;
	
	public FontSettings() {
		this(new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB).getGraphics());
	}
	
	public FontSettings(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public FontSettings(Font font) {
		graphics = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB).getGraphics();
		graphics.setFont(font);
	}
	
	public Graphics getGraphics() {
		return graphics;
	}
	
	public FontMetrics getFontMetrics() {
		return graphics.getFontMetrics(); 
	}
	
	public Font getFont() {
		return getFontMetrics().getFont();
	}
	
}
