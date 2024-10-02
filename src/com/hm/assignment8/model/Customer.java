package com.hm.assignment8.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String customerID;
	private String name;
	private List<Booking> bookingList;
	
	public Customer() {
		
	}
	
	public Customer(String customerID,String name, List<Booking> bookingList) {
		this.customerID = customerID;
		this.name = name;
		this.bookingList = new ArrayList<>();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	@Override
	public String toString() {
		return String.format("Customer ID: %s\nCustomer name: %s", this.customerID, this.name);
	}
}
