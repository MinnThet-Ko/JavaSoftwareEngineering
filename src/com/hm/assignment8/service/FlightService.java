package com.hm.assignment8.service;

import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.dao.FlightDAO;
import com.hm.assignment8.dao.FlightScheduleDAO;
import com.hm.assignment8.dao.SeatDAO;
import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.model.Seat;

public class FlightService {
	private FlightDAO flightDAO;
	private FlightScheduleDAO flightScheduleDAO;
	private SeatDAO seatDAO;

	public FlightService() {
		this.flightDAO = new FlightDAO();
		this.flightScheduleDAO = new FlightScheduleDAO();
		this.seatDAO = new SeatDAO();
	}

	public void displayAllFlightSchedule() {
		List<FlightSchedule> scheduleList = this.flightScheduleDAO.getAllFlightSchedules();
		for (FlightSchedule fs : scheduleList) {
			fs.displayScheduleInfo();
		}
	}

	public void displayAvailableSeats() {
		List<Seat> seatList = this.seatDAO.getAvailableSeat("F002", "R001");
		for (Seat s : seatList) {
			s.showSeatInfo();
		}
	}

}
