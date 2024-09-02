package com.hm.assignment5.models;

import java.util.Formatter;

public class Motorcycle extends Vehicle {

	private boolean hasSidecar;

	public Motorcycle(String brand, String model, boolean hasSidecar) {
		super(brand, model);
		this.hasSidecar = hasSidecar;
	}

	public boolean isHasSidecar() {
		return hasSidecar;
	}

	public void setHasSidecar(boolean hasSidecar) {
		this.hasSidecar = hasSidecar;
	}

	@Override
	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Brand: %s \nModel: %s \nHas sidecar: %s", super.getBrand(), super.getModel(),
				this.isHasSidecar() == true ? "Yes" : "No");
		System.out.println(formatter);
		formatter.close();

	}

}
