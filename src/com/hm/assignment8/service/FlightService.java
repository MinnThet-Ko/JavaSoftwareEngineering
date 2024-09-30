package com.hm.assignment8.service;

import java.util.List;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.dao.FlightDAO;
import com.hm.assignment8.dao.FlightScheduleDAO;
import com.hm.assignment8.dao.SeatDAO;
import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class FlightService  extends BaseService<Flight>{
	private FlightDAO flightDAO;
	private FlightScheduleDAO flightScheduleDAO;
	private SeatDAO seatDAO;

	public FlightService(BaseDAO<Flight> baseDAO) {
		super(baseDAO);
		this.flightDAO = new FlightDAO();

		this.seatDAO = new SeatDAO();
	}


	public void displayAvailableSeats() {
		List<Seat> seatList = this.seatDAO.getAvailableSeat("F002", "R001");
		for (Seat s : seatList) {
			s.showSeatInfo();
		}
	}


	@Override
	public String getEntityType() {
		return "flight";
	}


	@Override
	public void register() {
		Flight flight = new Flight();
		flight.setFlightID("F"+IDGenerator.generateRandomNumber());
		System.out.println("Enter flight name:");
		flight.setFlightName(InputUtil.getInstance().readLine());
		super.getDAO().insert(flight);
		
	}

}
