package com.hm.assignment5.models;

import java.util.Formatter;

public class Vehicle {
	
	public static final int MAX_VEHICLES = 1000;
	private static int vehicleCount = 0;
	private String brand;
	private String model;
	private String id;
	public Vehicle(String brand,String model) {
		this.brand = brand;
		this.model = model;
		vehicleCount++;
		this.id = "VHI-"+vehicleCount;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getId() {
		return this.id;
	}
	public static int getVehicleCount() {
		return vehicleCount;
	}

	public void displayInfo(){
		Formatter formatter = new Formatter();
		formatter.format("ID: %d\nBrand: %s \nModel: %s f", getId(), getBrand(), getModel());
		System.out.println(formatter);
		formatter.close();
	}
}
