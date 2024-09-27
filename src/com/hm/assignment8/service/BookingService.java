package com.hm.assignment8.service;

import com.hm.assignment8.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import com.hm.assignment8.dao.BookingDAO;
import com.hm.assignment8.dao.CityDAO;
import com.hm.assignment8.dao.CustomerDAO;
import com.hm.assignment8.dao.FlightDAO;
import com.hm.assignment8.dao.FlightScheduleDAO;
import com.hm.assignment8.dao.RouteDAO;
import com.hm.assignment8.dao.TicketDAO;
import com.hm.assignment8.model.Booking;
import com.hm.assignment8.model.City;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class BookingService {

//	private FlightDAO flightDAO;
//	private FlightScheduleDAO flightScheduleDAO;
//	private CustomerDAO customerDAO;
//	private BookingDAO bookingDAO;
//	private TicketDAO ticketDAO;
//	private CityDAO cityDAO;
//	private RouteDAO routeDAO;
//
//	private City startCity;
//	private City endCity;
//	private List<Route> visitedRoutes = new ArrayList<>();
//	private List<City> visitedCity = new ArrayList<>();
//	private List<List<Route>> possibleRoutes = new ArrayList<>();
//	private Stack<Route> adjRoutes = new Stack<>();
//	private Stack<City> adjCitues = new Stack<>();
//	
//	public BookingService() {
//		this.flightDAO = new FlightDAO();
//		this.flightScheduleDAO = new FlightScheduleDAO();
//		this.customerDAO = new CustomerDAO();
//		this.bookingDAO = new BookingDAO();
//		this.cityDAO = new CityDAO();
//		this.routeDAO = new RouteDAO();
//	}
//
//	public void saveBooking() {
//		FlightSchedule schedule = this.flightScheduleDAO.select("");
//		Customer customer = this.customerDAO.select("");
//		boolean result = this.bookingDAO.insert("B"+IDGenerator.generateRandomNumber(), "SCH0001", "C001", "S001", "F001", 100.0, new Date());
//		System.out.println(result?"Booking successful":"Booking unsuccessful");
//	}
//	
//	public void deleteBooking() {
//		boolean result = this.bookingDAO.delete("B35");
//		System.out.println(result?"Delete successful":"Delete unsuccessful");
//	}
//
//	public List<Flight> searchFlights(List<Flight> flightList, Route route) {
//		return null;
//	} 
//
//	public Flight getFlight(String flightID) {
//		return this.flightDAO.select(flightID);
//	}
	
	

}
