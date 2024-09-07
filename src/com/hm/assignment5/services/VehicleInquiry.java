package com.hm.assignment5.services;


import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public abstract class VehicleInquiry implements Inquiry {

	private String brand;
	private String model;
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getModel() {
		return this.model;
	}
	
	@Override
	public Vehicle getVehicleInfo() {
		System.out.println("Enter brand:");
		this.brand = InputUtil.getInstance().readLine();

		System.out.println("Enter model: ");
		this.model = InputUtil.getInstance().readLine();
		
		return getSpecificInfo();

	}
	
	public abstract Vehicle getSpecificInfo();

}
