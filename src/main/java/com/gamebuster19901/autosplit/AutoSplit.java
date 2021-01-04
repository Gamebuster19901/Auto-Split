package com.gamebuster19901.autosplit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.gamebuster19901.autosplit.input.SpecialKey;
import com.gamebuster19901.autosplit.swing.GButton;

public class AutoSplit implements ActionListener {
	
	public Hotkey split = SpecialKey.NUM_1, reset = SpecialKey.NUM_3, skip = SpecialKey.NUM_2, 
			undo = SpecialKey.NUM_8, pause = SpecialKey.NONE;
	
	public AutoSplit() {
		readConfig();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String e = event.getActionCommand();
		
		switch(e) {
			case "Browse":
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setDialogTitle("Choose a folder");
				chooser.setAcceptAllFileFilterUsed(false);
				if(chooser.showOpenDialog(Main.INSTANCE.frame) == JFileChooser.APPROVE_OPTION) {
					Main.INSTANCE.splitImageFolderLineEdit.setText(chooser.getCurrentDirectory().getAbsolutePath());
				}
				break;
				
			case "Select Region":
				break;
				
			case "Align Region":
				break;
				
			case "Select Window":
				break;
				
			case "Start Auto Splitter":
				break;
				
			case "Split":
				split.strike();
				break;
				
			case "Reset":
				reset.strike();
				break;
				
			case "Max FPS":
				//TODO figure out what this does
				break;
				
			case "Set Hotkey":
				GButton button = (GButton) event.getSource();
				System.out.println(button.getName());
				JOptionPane.showMessageDialog(Main.INSTANCE.frame, "Press the desired hotkey");
				break;
				
			case "Take Screenshot":
				//TODO: Take screenshot
				break;
				
			case "Undo Split":
				undo.strike();
				break;
				
			case "Skip Split":
				skip.strike();
				break;
		}
	}
	
	public void readConfig() {
		//TODO: Read settings from config file
	}
	
}
