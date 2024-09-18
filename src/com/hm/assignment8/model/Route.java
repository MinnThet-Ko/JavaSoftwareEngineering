package com.hm.assignment8.model;

public class Route {

	private String departureCity;
	private String destinationCity;
	
	public Route(String departureCity, String destinationCity) {
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

}
