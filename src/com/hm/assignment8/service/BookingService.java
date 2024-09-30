package com.hm.assignment8.service;

import java.util.Date;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.Booking;
import com.hm.assignment8.utils.ClassWrapperUtil;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class BookingService extends BaseService<Booking>{

	public BookingService(BaseDAO<Booking> dao) {
		super(dao);
	}

	@Override
	public String getEntityType() {
		return "booking";
	}

	@Override
	public void register() {
		Booking booking = new Booking();
		booking.setBookingID("B"+IDGenerator.generateRandomNumber());
		
		System.out.println("Enter customer ID:");
		String customerID = InputUtil.getInstance().readLine();
		booking.setCustomer(ClassWrapperUtil.wrapCustomer(customerID));
		
		System.out.println("Enter fight schedule ID:");
		String scheduleID = InputUtil.getInstance().readLine();
		booking.setFlightSchedule(ClassWrapperUtil.wrapFlightSchedule(scheduleID));
		
		System.out.println("Enter seat ID:");
		String seatID = InputUtil.getInstance().readLine();
		booking.setSeat(ClassWrapperUtil.wrapSeat(seatID));
		
		System.out.println("Enter fight ID:");
		String flightID = InputUtil.getInstance().readLine();
		booking.setFlight(ClassWrapperUtil.wrapFlight(flightID));
		
		System.out.println("Enter price:");
		double price = InputUtil.getInstance().readDouble();
		booking.setPrice(price);
		
		System.out.println("Enter departure date(yyyy-MM-dd):");
		Date departureDate = InputUtil.getInstance().readDate();
		booking.setDepartureDate(departureDate);
		super.getDAO().insert(booking);
		InputUtil.getInstance().closeReader();
	}

	
	
	

}
