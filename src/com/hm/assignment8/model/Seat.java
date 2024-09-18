package com.hm.assignment8.model;

import java.util.Formatter;

public class Seat {
	private String seatNo;
	private boolean isBooked;
	
	public Seat(String seatNo) {
		this.seatNo = seatNo;
		this.isBooked = false;
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

	
	public void showSeatInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Seat No. : %s\nBooking status: %s", this.seatNo, this.isBooked?"Available":"Unavailable");
		formatter.close();
	}
}
