package com.gamebuster19901.autosplit;

import java.awt.AWTError;
import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.KeyStroke;

import com.gamebuster19901.autosplit.input.SpecialKey;

public interface Hotkey {

	public static final Robot ROBOT = init();
	
	public static Robot init() {
		try {
			return new Robot();
		} catch (AWTException e) {
			AWTError err = new AWTError("Unable to instantiate the Robot instance");
			err.initCause(e);
			throw err;
		}
	}
	
	public int getKeyCode();
	
	@Deprecated
	public int getKeyLocation();
	
	public default void strike() {
		press();
		release();
	}
	
	public default void press() {
		ROBOT.keyPress(getKeyCode());
	}
	
	public default void release() {
		ROBOT.keyRelease(getKeyCode());
	}
	
	public static Hotkey deriveKeyFromText(String text) {
		Hotkey hotkey;
		hotkey = SpecialKey.getSpecialKey(text);
		if(hotkey != SpecialKey.NOT_SPECIAL) {
			return hotkey;
		}
		return new NormalKey(KeyStroke.getKeyStroke(text).getKeyCode());
	}
	
}
