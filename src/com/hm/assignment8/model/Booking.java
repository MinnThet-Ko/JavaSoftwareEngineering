package com.hm.assignment8.model;

import java.util.Date;
import java.util.Formatter;

public class Booking {
	private String bookingID;
	private Customer customer;
	private Seat seat;
	private Flight flight;
	private FlightSchedule flightSchedule;
	private double price;
	private Date departureDate;
	
	public Booking() {
		
	}

	public Booking(String bookingID, Customer customer, Seat seat, Flight flight, FlightSchedule flightSchedule) {
		this.bookingID = bookingID;
		this.customer = customer;
		this.seat = seat;
		this.flight = flight;
		this.flightSchedule = flightSchedule;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
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

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public void showBookingInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Booking ID: %s\nCustomer : %s\nSeat: %s\nFlight: 5s", this.bookingID, this.customer.getName(),
				this.seat.getSeatNo(), this.flight.getFlightID());
		System.out.println(formatter);
		formatter.close();
	}

}
