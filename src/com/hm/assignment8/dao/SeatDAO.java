package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.utils.DatabaseUtil;

public class SeatDAO implements FlightManagementDAO<Seat>{
	
	public List<Seat> getAvailableSeat(String flightID, String routeID){
		List<Seat> resultSeatList = new ArrayList<>();
		String query = "select seat.* from seat \r\n"
				+ "inner join flight_schedule on seat.flight_id = flight_schedule.flight_id\r\n"
				+ "full outer join booking on seat.seat_id = booking.seat_id\r\n"
				+ "where flight_schedule.departure_date > ? \r\n"
				+ "and flight_schedule.flight_id = ? and flight_schedule.route_id =?\r\n"
				+ "order by seat.flight_id, seat.seat_id";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, new Timestamp(new java.util.Date().getTime()));
			statement.setString(2, flightID);
			statement.setString(3, routeID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Seat seat =  new Seat();
				Flight flight = new Flight();
				flight.setFlightID(resultSet.getString("flight_id"));
				seat.setSeatNo(resultSet.getString("seat_id"));
				seat.setFlight(flight);
				resultSeatList.add(seat);
			}
			DatabaseUtil.getInstance().closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSeatList;
	}

	@Override
	public List<Seat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Seat parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Seat parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Seat parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Seat select(Seat parameters) {
		// TODO Auto-generated method stub
		return null;
	}
}
