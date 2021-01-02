package com.gamebuster19901.autosplit.swing;

import java.awt.Rectangle;

public interface DynamicallySized {

	public Rectangle getActualBounds();
	
	public default int getActualWidth() {
		return (int) getActualBounds().getWidth();
	}
	
	public default int getActualHeight() {
		return (int) getActualBounds().getHeight();
	}
	
}
