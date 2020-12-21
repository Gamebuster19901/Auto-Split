package com.gamebuster19901.autosplit.swing;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class FontSettings {

	private final Graphics graphics;
	
	public FontSettings() {
		this(new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB).getGraphics());
		HashMap<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
		attributes.put(TextAttribute.TRACKING, -0.09);
		graphics.setFont(getFont().deriveFont(attributes));
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
