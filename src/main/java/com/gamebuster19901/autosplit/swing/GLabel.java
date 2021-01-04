package com.gamebuster19901.autosplit.swing;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GLabel extends JLabel {

	public static final FontSettings DEFAULT_FONT_SETTINGS = new FontSettings();
	
	public GLabel(String text, String name) {
		super(text);
		this.setFont(DEFAULT_FONT_SETTINGS.getFont());
		this.setName(name);
	}
	
	public GLabel(String text, String name, FontSettings fontSettings) {
		this(text, name);
		this.setFont(fontSettings.getFont());
	}
	
	public GLabel(String text, String name, Font font) {
		this(text, name);
		this.setFont(font);
	}
	
}
