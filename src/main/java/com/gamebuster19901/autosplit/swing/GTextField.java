package com.gamebuster19901.autosplit.swing;

import java.awt.Color;

import javax.swing.JTextField;

public class GTextField extends JTextField{

	public GTextField(String text, boolean editable, String name) {
		this.setBackground(Color.GRAY);
		this.setForeground(Color.WHITE);
		this.setSelectedTextColor(Color.BLACK);
		this.setText(text);
		this.setEditable(editable);
		this.setName(name);
	}
	
}
