package com.in28minutes.microservices;

public class LimitsConfiguration {

	private int maximum;
	private int minimum;
	public LimitsConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LimitsConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	@Override
	public String toString() {
		return "LimitsConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
}
