package com.hm.assignment8.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Ticket;

public class FlightDAO{

	private static FlightDAO flightDAO;
	private List<Flight> flightList;
	
	private FlightDAO() {
		this.flightList = new ArrayList<>();
	}
	
	public static FlightDAO getInstance() {
		if (flightDAO == null) {
			flightDAO = new FlightDAO();
		}
		return flightDAO;
	}
	

	public Flight getFlightByID(String flightID) {
		List<Flight> resultList = this.flightList.stream().filter(f -> f.getFlightID().equals(flightID)).collect(Collectors.toList());
		if(resultList!= null) {
			return resultList.get(0);
		}
		return null;
	}
	
	public void updateFlight(Flight flight) {
		for(Flight f: this.flightList) {
			if(f.getFlightID().equals(flight.getFlightID())) {
				f = flight;
			}
		}
	}

}
