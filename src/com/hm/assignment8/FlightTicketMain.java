package com.hm.assignment8;

import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Customer;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.service.BookingService;

public class FlightTicketMain {
	
	public static void main(String[] args) {
		List<Seat> seatList =  new ArrayList<>();
		seatList.add(new Seat("S001"));
		seatList.add(new Seat("S002"));
		seatList.add(new Seat("S003"));
		seatList.add(new Seat("S004"));
		seatList.add(new Seat("S005"));
		seatList.add(new Seat("S006"));
		seatList.add(new Seat("S007"));
		seatList.add(new Seat("S008"));
		seatList.add(new Seat("S009"));
		seatList.add(new Seat("S010"));
		seatList.add(new Seat("S011"));
		seatList.add(new Seat("S012"));
		
		Flight flight = new Flight("F001",  seatList);
		
		BookingService bookingService = new BookingService();
		
		Customer customer = new Customer("Mike", "145/TESTING", "ab123456"); 
		Ticket resultTicket= bookingService.bookSeat(customer, flight, "S001");
		if (resultTicket == null) {
			System.err.println("Seat unavailable.");
		}else {
			resultTicket.showTicketInfo();
		}
		
		resultTicket= bookingService.bookSeat(customer, flight, "S001");
		if (resultTicket == null) {
			System.err.println("Seat unavailable.");
		}else {
			resultTicket.showTicketInfo();
		}
	}

}
