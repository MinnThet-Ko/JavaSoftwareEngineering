package com.hm.assignment8.model;

import java.util.Formatter;
import java.util.List;

public class Flight {
	private String flightID;
	private String flightName;
	private Route route;
	private List<Seat> seatList;

	public Flight() {

	}

	public Flight(String flghtID, String flightName, Route route, List<Seat> seatList) {
		this.flightID = flghtID;
		this.flightName = flightName;
		this.route = route;
		this.seatList = seatList;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	public void showSeatInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Flight ID: %s\nFlight name: %s", this.flightID, this.flightName);
		System.out.println(formatter);
		formatter.close();
	}

}
