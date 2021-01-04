package com.gamebuster19901.autosplit;

public enum Comparison {

	L2_NORM("L2 Norm"),
	HISTOGRAM("Histogram"),
	PHASH("PHash");

	private String name;
	
	private Comparison(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
