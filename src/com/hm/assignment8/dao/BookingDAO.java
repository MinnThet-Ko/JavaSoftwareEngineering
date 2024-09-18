package com.hm.assignment8.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hm.assignment8.model.Booking;

public class BookingDAO{

	private static BookingDAO bookingDAO;
	private List<Booking> bookingList;
	
	private BookingDAO() {
		this.bookingList = new ArrayList<>();
	}
	
	public static BookingDAO getInstance() {
		if (bookingDAO == null) {
			bookingDAO = new BookingDAO();
		}
		return bookingDAO;
	}
	
	public void create(Booking booking) {
		this.bookingList.add(booking);
	}
	
	public void delete(String bookingID) {
		this.bookingList.removeIf(b -> b.getBookingID().equals(bookingID));
	}
	
	public Booking getBookingByID(String bookingID) {
		List<Booking> resultList = this.bookingList.stream().filter(b -> b.getBookingID().equals(bookingID)).collect(Collectors.toList());
		if(resultList!= null) {
			return resultList.get(0);
		}
		return null;
	}

	
	

}
