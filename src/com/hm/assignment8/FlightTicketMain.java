package com.hm.assignment8;

import com.hm.assignment8.service.BookingService;
import com.hm.assignment8.service.FlightService;

public class FlightTicketMain {
	
	public static void main(String[] args) {
		BookingService bookingService = new BookingService();
		bookingService.getFlight("F001").showSeatInfo();
		 
		FlightService flightService = new FlightService();
		flightService.displayAllFlightSchedule();
		flightService.displayAvailableSeats();
		
	}

}
