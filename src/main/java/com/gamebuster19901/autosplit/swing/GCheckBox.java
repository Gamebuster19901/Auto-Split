package com.gamebuster19901.autosplit.swing;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GCheckBox extends JCheckBox {

	public static final FontSettings DEFAULT_FONT_SETTINGS = new FontSettings();
	private static final Border BORDER = new LineBorder(Color.GRAY, 1);
	
	public GCheckBox(String name) {
		this("", name);
	}
	
	public GCheckBox(String text, String name) {
		super(text);
		this.setFont(DEFAULT_FONT_SETTINGS.getFont());
		this.setFocusable(false);
		this.setName(name);
		this.setBorder(BORDER);
	}
	
	public GCheckBox(String text, String name, boolean selected) {
		super(text, null, selected);
		this.setFont(DEFAULT_FONT_SETTINGS.getFont());
		this.setFocusable(false);
		this.setName(name);
		this.setBorder(BORDER);
	}
	
}
