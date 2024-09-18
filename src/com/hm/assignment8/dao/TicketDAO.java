package com.hm.assignment8.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hm.assignment8.model.Ticket;

public class TicketDAO{

	private static TicketDAO ticketDAO;
	private List<Ticket> ticketList;
	
	private TicketDAO() {
		this.ticketList = new ArrayList<>();
	}
	
	public static TicketDAO getInstance() {
		if (ticketDAO == null) {
			ticketDAO = new TicketDAO();
		}
		return ticketDAO;
	}
	
	public void create(Ticket ticket) {
		this.ticketList.add(ticket);
	}
	
	public void delete(String ticketID) {
		this.ticketList.removeIf(b -> b.getTicketID().equals(ticketID));
	}
	
	public Ticket getTicketByBookingID(String bookingID) {
		List<Ticket> resultList = this.ticketList.stream().filter(b -> b.getBooking().getBookingID().equals(bookingID)).collect(Collectors.toList());
		if(resultList!= null) {
			return resultList.get(0);
		}
		return null;
	}

	
	

}
