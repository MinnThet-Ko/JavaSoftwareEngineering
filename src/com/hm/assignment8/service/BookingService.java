package com.hm.assignment8.service;

import com.hm.assignment8.model.Customer;

import java.util.List;

import com.hm.assignment8.dao.BookingDAO;
import com.hm.assignment8.dao.TicketDAO;
import com.hm.assignment8.model.Booking;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.InputUtil;

public class BookingService {
	
	public Ticket bookSeat(Customer customer, Flight flight,String seatNo) {
		Seat resultSeat= flight.findAvailableSeat(seatNo);
		if(resultSeat == null) {
			return null;
		}
		Booking booking = new Booking(customer, resultSeat, flight);
		BookingDAO.getInstance().create(booking);
		Ticket resultTicket= new Ticket(booking);
		TicketDAO.getInstance().create(resultTicket);
		return resultTicket;
	}
	
	public List<Flight> searchFlights(List<Flight> flightList, Route route){
		return null;
	}
	
	public void cancelBooking() {
		System.out.println("Enter booking ID:");
		String bookingID = InputUtil.getInstance().readLine();
		if(BookingDAO.getInstance().getBookingByID(bookingID)== null) {
			System.err.println("Booking ID not found.");
		}else {
			TicketDAO.getInstance().delete(TicketDAO.getInstance().getTicketByBookingID(bookingID).getTicketID());
			BookingDAO.getInstance().delete(bookingID);
		}
	}

}
