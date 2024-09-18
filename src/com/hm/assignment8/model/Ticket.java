package com.hm.assignment8.model;

import java.util.Formatter;

import com.hm.assignment8.utils.IDGenerator;

public class Ticket {
	private String ticketID;
	private Booking booking;

	
	public Ticket(Booking booking) {
		this.ticketID = "TKT-"+IDGenerator.generateRandomNumber();
		this.booking = booking;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void showTicketInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Ticket ID. : %s\n", this.ticketID);
		System.out.println(formatter);
		formatter.close();
		this.booking.showBookingInfo();
	}
	
}
