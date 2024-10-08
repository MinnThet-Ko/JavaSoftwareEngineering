package com.hm.assignment8.model;

import java.util.ArrayList;
import java.util.List;

public class Route {

	private String routeID;
	private String routeName;
	private List<City> cityList;
	
	public Route() {
		
	}
	
	public Route(String routeID, ArrayList<City> cityList) {
		this.routeID = routeID;
		this.cityList = cityList;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	

}
