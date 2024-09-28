package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.utils.DatabaseUtil;

public class SeatDAO implements BaseDAO<Seat>{
	
	public List<Seat> getAvailableSeat(String flightID, String seatID){
		List<Seat> resultSeatList = new ArrayList<>();
		String query = "select seat.* from seat \r\n"
				+ "inner join flight_schedule on seat.flight_id = flight_schedule.flight_id\r\n"
				+ "full outer join booking on seat.seat_id = booking.seat_id\r\n"
				+ "where flight_schedule.departure_date > ? \r\n"
				+ "and flight_schedule.flight_id = ? and flight_schedule.seat_id =?\r\n"
				+ "order by seat.flight_id, seat.seat_id";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, new Timestamp(new java.util.Date().getTime()));
			statement.setString(2, flightID);
			statement.setString(3, seatID);
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
		String query = "select * from seat";
		List<Seat> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Seat r = new Seat();
				r.setSeatNo(rs.getString("seat_id"));
				resultList.add(r);
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultList.isEmpty() ? null : resultList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Seat parameters) {
		String query = "insert into seat (seat_id, seat_name) values (?,?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getSeatNo());
			statement.setString(2, parameters.getFlight().getFlightID());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		String query = "delete from seat where seat_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, id);
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Seat selectByID(String id) {
		Seat resultSeat = new Seat();

		String query = "select * from seat where seat_id = (?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				resultSeat.setSeatNo(rs.getString("seat_id"));
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultSeat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
