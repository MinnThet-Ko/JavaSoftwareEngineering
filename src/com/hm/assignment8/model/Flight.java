package com.hm.assignment8.model;

import java.util.List;

public class Flight {
	private String flightID;
	private Route route;
	private List<Seat> seatList;

	public Flight(String flghtID, List<Seat> seatList) {
		this.flightID = flghtID;
		this.seatList = seatList;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}

	public Seat findAvailableSeat(String seatNo) {
		for (Seat seat : this.seatList) {
			if (!seat.isBooked() && seat.getSeatNo().equals(seatNo)) {
				seat.setBooked(true);
				return seat;
			}
		}
		return null;
	}
	
	public void showAllSeats() {
		this.seatList.forEach(seat -> seat.showSeatInfo());
	}

}
