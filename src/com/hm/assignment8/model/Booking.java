package com.hm.assignment8.model;

import java.util.Formatter;

public class Booking {
	private String bookingID;
	private Customer customer;
	private Seat seat;
	private Flight flight;
	
	public Booking(Customer customer, Seat seat, Flight flight) {
		this.customer = customer;
		this.seat = seat;
		this.flight = flight;
		this.bookingID = "B-"+(int)(Math.random()* 1000+1);
	}

	public String getBookingID() {
		return bookingID;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public void showBookingInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Booking ID: %s\nCustomer : %s\nSeat: %s\nFlight: 5s", this.bookingID, this.customer.getName(), this.seat.getSeatNo(), this.flight.getFlightID());
		System.out.println(formatter);
		formatter.close();
	}

}
