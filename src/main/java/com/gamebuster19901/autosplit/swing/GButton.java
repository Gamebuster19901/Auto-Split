package com.gamebuster19901.autosplit.swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GButton extends JButton {
	
	private static final FontSettings DEFAULT_FONT_SETTINGS = new FontSettings();
	private static final Border BORDER = new LineBorder(Color.GRAY, 1);
	
	public GButton(String text, String name) {
		super(text);
		this.setFont(DEFAULT_FONT_SETTINGS.getFont());
		this.setFocusable(false);
		this.setName(name);
		this.setBorder(BORDER);
	}
	
	public GButton(String text, String name, FontSettings fontSettings) {
		this(text, name);
		this.setFont(fontSettings.getFont());
	}
	
	public GButton(String text, String name, Font font) {
		this(text, name);
		this.setFont(font);
	}
	
}
