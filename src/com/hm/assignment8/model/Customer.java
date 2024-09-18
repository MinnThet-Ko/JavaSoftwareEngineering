package com.hm.assignment8.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name;
	private String nrc;
	private String passportID;
	private List<Booking> bookingList;

	public Customer(String name, String nrc, String passportID) {
		this.name = name;
		this.nrc = nrc;
		this.passportID = passportID;
		this.bookingList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getPassportID() {
		return passportID;
	}

	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	
}
