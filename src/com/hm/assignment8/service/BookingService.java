package com.hm.assignment8.service;

import com.hm.assignment8.model.Customer;

import java.util.List;

import com.hm.assignment8.dao.BookingDAO;
import com.hm.assignment8.dao.CustomerDAO;
import com.hm.assignment8.dao.FlightDAO;
import com.hm.assignment8.dao.FlightScheduleDAO;
import com.hm.assignment8.dao.TicketDAO;
import com.hm.assignment8.model.Booking;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.InputUtil;

public class BookingService {

	private FlightDAO flightDAO;
	private FlightScheduleDAO flightScheduleDAO;
	private CustomerDAO customerDAO;
	private BookingDAO bookingDAO;
	private TicketDAO ticketDAO;

	public BookingService() {
		this.flightDAO = new FlightDAO();
		this.flightScheduleDAO = new FlightScheduleDAO();
		this.customerDAO = new CustomerDAO();
		this.bookingDAO = new BookingDAO();
		
	}

	public void saveBooking() {
		FlightSchedule schedule = this.flightScheduleDAO.getFlightScheduleByID("");
		Customer customer = this.customerDAO.getCustomerByID("");
		this.bookingDAO.saveBooking("", null, null, null, null, 0, null);
	}

	public List<Flight> searchFlights(List<Flight> flightList, Route route) {
		return null;
	}

	public Flight getFlight(String flightID) {
		return this.flightDAO.getFlightByID(flightID);
	}

}
