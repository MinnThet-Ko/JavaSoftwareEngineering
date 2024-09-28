package com.hm.assignment8.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.hm.assignment8.dao.CityDAO;
import com.hm.assignment8.dao.RouteDAO;
import com.hm.assignment8.model.City;
import com.hm.assignment8.model.Route;

public class RouteService {

	private CityDAO cityDAO = new CityDAO();
	private RouteDAO routeDAO = new RouteDAO();

	private City startCity;
	private City endCity;
	private City pointerCity;

	private List<City> visitedCities = new ArrayList<>();
	private Stack<City> cityStack = new Stack<>();
	private List<List<City>> possibleCities = new ArrayList<>();

	public boolean checkVisitedCity(City c) {
		boolean existsInVisited = false;
		for (City vc : this.visitedCities) {
			if(vc.getCityID().equals(c.getCityID())) {
				existsInVisited = true;
			}
			
		}
		return existsInVisited;
	}
	
	public boolean checkCityStack(City c) {
		boolean existsInStack = false;
		for (City vc : this.cityStack) {
			if(vc.getCityID().equals(c.getCityID())) {
			existsInStack = true;
			}
		}
		return  existsInStack;
	}

	public void findAllRoutes() {
		this.cityStack.add(pointerCity);
		if (this.pointerCity.equals(this.endCity)) {
			System.out.println("Checking end city and pointer city");
			this.possibleCities.addAll(Arrays.asList(this.cityStack));
			this.cityStack.pop();
			this.pointerCity = this.cityStack.get(this.cityStack.size() - 1);
			return;
		}
		List<Route> adjacentRoutes = this.routeDAO.selectByCityID(this.pointerCity.getCityID());
		List<City> adjacentCities = new ArrayList<>();
		if (adjacentRoutes.isEmpty()) {
			System.out.println("Adjacent routes are empty");
			this.visitedCities.add(this.cityStack.pop());
			return;
		}
		for (Route r : adjacentRoutes) {
			City adjacentCity = this.cityDAO.selectCityFromRouteID(r.getRouteID(), this.pointerCity.getCityID());
			
			//Check for end city
			if(adjacentCity.equals(this.endCity)) {
				System.out.println("In the end city check");
				System.out.println(this.cityStack);
				List<City> resultRoute = new ArrayList<>();
				resultRoute.addAll(cityStack);
				resultRoute.add(adjacentCity);
				this.possibleCities.add(resultRoute);
				System.out.println(this.possibleCities);
			}
			if (!adjacentCity.equals(this.pointerCity) && !checkCityStack(adjacentCity) && !checkVisitedCity(adjacentCity) && !adjacentCity.equals(this.endCity)) {
				adjacentCities.add(adjacentCity);
			}
		}
		
		for (City c : adjacentCities) {
			this.pointerCity = c;
			findAllRoutes();
		}
	}

	public void findAdjacentCities() {

	}

	public void testRoutes() {
		City firstCity = new City();
		firstCity.setCityID("C001");
		City secondCity = new City();
		secondCity.setCityID("C004");

		this.startCity = this.cityDAO.selectByID(firstCity.getCityID());
		this.endCity = this.cityDAO.selectByID(secondCity.getCityID());
		this.pointerCity = this.startCity;
		findAllRoutes();

	}

}
