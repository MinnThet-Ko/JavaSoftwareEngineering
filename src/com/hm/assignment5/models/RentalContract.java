package com.hm.assignment5.models;

import java.util.Formatter;

public class RentalContract {
	
	private String id;
	private Customer customer;
	private Vehicle  vehicle;
	private int duration;
	
	public RentalContract(Customer customer, Vehicle vechicle, int duration) {
		this.customer = customer;
		this.vehicle = vechicle;
		this.duration = duration;
	}
	


	public String getId() {
		return this.id;
	}
	
	public void setcustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getcustomer() {
		return customer;
	}


	public Vehicle getvehicle() {
		return vehicle;
	}

	public void setvehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("ID: %s \nCustomer ID: %s \nVehicle ID: %s \nDuration: %d", this.id,this.customer, this.vehicle, this.duration);
		System.out.println(formatter);
		formatter.close();
	}
}
