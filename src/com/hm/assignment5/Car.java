package com.hm.assignment5;

import java.util.Formatter;

public class Car extends Vehicle{

	private int doors;
	public Car(String brand, String model, int doors) {
		super(brand, model);
		this.doors = doors;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	@Override
	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Brand: %s \nModel: %s \nDoors: %d", super.getBrand(), super.getModel(), this.getDoors());
		System.out.println(formatter);
		formatter.close();
	}
	

}
