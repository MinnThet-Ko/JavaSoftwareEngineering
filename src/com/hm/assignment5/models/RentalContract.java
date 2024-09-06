package com.hm.assignment5.models;

import java.util.Formatter;

public class RentalContract {
	
	private String id;
	private String customerId;
	private String  vehicleId;
	private int duration;
	
	public RentalContract(String customerId, String vechicleId, int duration) {
		this.customerId = customerId;
		this.vehicleId = vechicleId;
		this.duration = duration;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}


	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("ID: %s \nCustomer ID: %s \nVehicle ID: %s \nDuration: %d", this.id,this.customerId, this.vehicleId, this.duration);
		System.out.println(formatter);
		formatter.close();
	}
}
