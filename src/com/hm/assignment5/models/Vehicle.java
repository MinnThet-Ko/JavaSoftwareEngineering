package com.hm.assignment5.models;

import java.util.Formatter;

import com.hm.assignment5.dao.VehicleDAO;

public class Vehicle {
	
	private String brand;
	private String model;
	private String id;
	public Vehicle(String brand,String model) {
		this.brand = brand;
		this.model = model;
		this.id = "VHI-"+VehicleDAO.getInstance().getVechicleCount();
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

	public void displayInfo(){
		Formatter formatter = new Formatter();
		formatter.format("ID: %d\nBrand: %s \nModel: %s f", getId(), getBrand(), getModel());
		System.out.println(formatter);
		formatter.close();
	}
}
