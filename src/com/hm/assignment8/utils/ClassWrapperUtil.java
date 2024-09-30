package com.hm.assignment8.utils;

import com.hm.assignment8.model.Booking;
import com.hm.assignment8.model.City;
import com.hm.assignment8.model.Customer;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Ticket;

public class ClassWrapperUtil {
	
	public static Booking wrapBooking(String bookingID) {
		Booking booking = new Booking();
		booking.setBookingID(bookingID);
		return booking;
	}
	
	public static City wrapCity(String cityID) {
		City city = new City();
		city.setCityID(cityID);
		return city;
	}
	
	public static Customer wrapCustomer(String customerID) {
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		return customer;
	}

	public static Flight wrapFlight(String flightID) {
		Flight flight = new Flight();
		flight.setFlightID(flightID);
		return flight;
	}
	
	public static FlightSchedule wrapFlightSchedule(String scheduleID) {
		FlightSchedule flightSchedule = new FlightSchedule();
		flightSchedule.setScheduleID(scheduleID);
		return flightSchedule;
	}
	
	public static Route wrapRoute(String routeID) {
		Route route = new Route();
		route.setRouteID(routeID);
		return route;
	}
	
	public static Seat wrapSeat(String seatID) {
		Seat seat = new Seat();
		seat.setSeatNo(seatID);
		return seat;
	}
	
	public static Ticket wrapticket(String ticketID) {
		Ticket ticket = new Ticket();
		ticket.setTicketID(ticketID);
		return ticket;
	}
}
