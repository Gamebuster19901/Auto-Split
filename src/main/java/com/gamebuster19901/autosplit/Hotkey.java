package com.gamebuster19901.autosplit;

import static java.awt.event.KeyEvent.KEY_LOCATION_STANDARD;

import java.awt.AWTError;
import java.awt.AWTException;
import java.awt.Robot;

public class Hotkey {
	
	private static final Robot ROBOT;
	static {
		try {
			ROBOT = new Robot();
		} catch (AWTException e) {
			AWTError err = new AWTError("Unable to instantiate the Robot instance");
			err.initCause(e);
			throw err;
		}
	}
	
	private int keyCode;
	private int keyLocation;
	
	public Hotkey(int keyCode) {
		setKeyCode(keyCode, KEY_LOCATION_STANDARD);
	}
	
	public void setKeyCode(int keyCode, int keyLocation) {
		this.keyCode = keyCode;
		this.keyLocation = keyLocation;
	}
	
	public int getKeyCode() {
		return keyCode;
	}
	
	public int getKeyLocation() {
		return keyLocation;
	}
	
	public void press() {
		ROBOT.keyPress(keyCode);
		ROBOT.keyRelease(keyCode);
	}
	
}
