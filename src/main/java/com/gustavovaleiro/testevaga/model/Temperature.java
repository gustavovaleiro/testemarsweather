package com.gustavovaleiro.testevaga.model;

import java.io.Serializable;

public class Temperature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double averageTemperature;

	public Temperature() {}
	
	
	public Temperature(double averageTemperature) {
		this.averageTemperature = averageTemperature;
	}


	public double getAverageTemperature() {
		return averageTemperature;
	}

	public void setAverageTemperature(double averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	
	
	
}
