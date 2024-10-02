package com.hm.assignment8.model;

import java.util.Formatter;

public class City {
	
	private String cityID;
	private String cityName;
	
	public City() {
		
	}
	
	public City(String cityID, String cityName) {
		this.cityID = cityID;
		this.cityName = cityName;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void displayCityInfo() {
		Formatter formatter = new Formatter();
		formatter.format("City ID: %s\nName: %s", this.cityID, this.cityName);
		System.out.println(formatter);
		formatter.close();
	}
	
	@Override
	public String toString() {
		return String.format("City ID: %s\nName: %s", this.cityID, this.cityName);
	}

	public boolean equals(City c) {
		return this.cityID.equals(c.getCityID());
	}
}
