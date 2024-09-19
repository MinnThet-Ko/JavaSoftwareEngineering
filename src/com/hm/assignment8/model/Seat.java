package com.hm.assignment8.model;

import java.util.Formatter;

public class Seat {
	private String seatNo;
	private boolean isBooked;
	private Flight flight;

	public Seat() {

	}

	public Seat(String seatNo, Flight flight) {
		this.seatNo = seatNo;
		this.isBooked = false;
		this.flight = flight;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public void showSeatInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Seat No. : %s\n", this.seatNo);
		System.out.println(formatter);
		formatter.close();
	}
}
