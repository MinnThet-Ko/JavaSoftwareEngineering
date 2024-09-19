package com.hm.assignment8.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Formatter;

public class FlightSchedule {
	private String scheduleID;
	private Timestamp departureTime;
	private Flight flight;
	private Route route;

	public FlightSchedule() {

	}

	public FlightSchedule(String scheduleID, Timestamp departureTime, Flight flight, Route route) {
		this.scheduleID = scheduleID;
		this.departureTime = departureTime;
		this.flight = flight;
		this.route = route;
	}

	public String getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	public void displayScheduleInfo() {
		Formatter formatter = new Formatter();
		formatter.format("Schedule ID. : %s\nDeparture date: %s\nFlight ID: %s\nRoute ID: %S", this.scheduleID, this.departureTime.toString(), this.flight.getFlightID(), this.route.getRouteID());
		System.out.println(formatter);
		formatter.close();
	}
}
