package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.hm.assignment8.model.Booking;
import com.hm.assignment8.utils.DatabaseUtil;;

public class BookingDAO implements FlightManagementDAO<Booking> {

	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object... parameters) {
		String qurey = "insert into booking(booking_id, schedule_id, customer_id, seat_id, flight_id, price, departure_date) "
				+ "values (?,?,?,?,?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, (String) parameters[0]);
			statement.setString(2, (String) parameters[1]);
			statement.setString(3, (String) parameters[2]);
			statement.setString(4, (String) parameters[3]);
			statement.setString(5, (String) parameters[4]);
			statement.setDouble(6, (double) parameters[5]);
			statement.setTimestamp(7, new Timestamp(((Date) parameters[6]).getTime()));
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Object... parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object... parameters) {
		String qurey = "delete from booking where booking_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, (String) parameters[0]);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Booking select(Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
