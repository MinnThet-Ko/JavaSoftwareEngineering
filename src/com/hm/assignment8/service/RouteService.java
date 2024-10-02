package com.hm.assignment8.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.dao.CityDAO;
import com.hm.assignment8.dao.RouteDAO;
import com.hm.assignment8.model.City;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class RouteService extends BaseService<Route>{

	public RouteService(BaseDAO<Route> dao) {
		super(dao);
	}

	private CityDAO cityDAO = new CityDAO();
	private RouteDAO routeDAO = new RouteDAO();

	private City startCity;
	private City endCity;
	private City pointerCity;

	private List<City> visitedCities = new ArrayList<>();
	private Stack<City> cityStack = new Stack<>();
	private List<List<City>> possibleCities = new ArrayList<>();

	@Override
	public void showMenu() {
		System.out.println("Choose an operation:");
		System.out.println(String.format("1. Insert %s", getEntityType()));
		System.out.println(String.format("2. Delete %s", getEntityType()));
		System.out.println(String.format("3. Find %s by ID", getEntityType()));
		System.out.println(String.format("4. Find all %s", getEntityType()));
		System.out.println("5. Get all routes");
		System.out.println("6. Exit");
	}
	
	@Override
	public void call() {
		showMenu();
		int input = InputUtil.getInstance().readInt();
		if (input == 6) {
			return;
		}

		switch (input) {
		case 1:
			register();
			break;
		case 2:
			delete();
			break;
		case 3:
			findByID();
			break;
		case 4:
			findAll();
			break;
			
		case 5:
			findAllPossibleRoutes();
			break;
		default:
			break;
		}
		call();
	}
	
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

	public void findRoute() {
		this.cityStack.add(pointerCity);
		if (this.pointerCity.equals(this.endCity)) {
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
				List<City> resultRoute = new ArrayList<>();
				resultRoute.addAll(cityStack);
				resultRoute.add(adjacentCity);
				this.possibleCities.add(resultRoute);
			}
			if (!adjacentCity.equals(this.pointerCity) && !checkCityStack(adjacentCity) && !checkVisitedCity(adjacentCity) && !adjacentCity.equals(this.endCity)) {
				adjacentCities.add(adjacentCity);
			}
		}
		
		for (City c : adjacentCities) {
			this.pointerCity = c;
			findRoute();
		}
	}


	public void findAllPossibleRoutes() {
		System.out.println("Enter the starting city ID:");
		String startingCityID = InputUtil.getInstance().readLine();
		System.out.println("Enter the ending city ID:");
		String endingCityID = InputUtil.getInstance().readLine();

		this.startCity = this.cityDAO.selectByID(startingCityID);
		this.endCity = this.cityDAO.selectByID(endingCityID);
		this.pointerCity = this.startCity;
		findRoute();
		System.out.println(possibleCities);
	}

	@Override
	public String getEntityType() {
		return "route";
	}

	@Override
	public void register() {
		Route route = new Route();
		route.setRouteID("R"+IDGenerator.generateRandomNumber());
		System.out.println("Enter route name:");
		route.setRouteName(InputUtil.getInstance().readLine());
		super.getDAO().insert(route);
	}

}
