package com.hm.assignment5;

import java.util.Formatter;

public class Truck extends Vehicle{

	private double payloadCapacity;

	public Truck(String brand, String model, double payloadCapacity) {
		super(brand, model);
		this.payloadCapacity = payloadCapacity;
	}
	
	public double getPayloadCapacity() {
		return payloadCapacity;
	}

	public void setPayloadCapacity(double payloadCapacity) {
		this.payloadCapacity = payloadCapacity;
	}

	@Override
	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Brand: %s \nModel: %s \nPayload capacity: %f", super.getBrand(), super.getModel(), this.getPayloadCapacity());
		System.out.println(formatter);
		formatter.close();
	}
}
