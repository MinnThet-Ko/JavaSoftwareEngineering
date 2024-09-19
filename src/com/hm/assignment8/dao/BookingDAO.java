package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.hm.assignment8.utils.DatabaseUtil;;

public class BookingDAO {

	public boolean saveBooking(String bookingID, String scheduleID, String customerID, String seatID, String flightID, float price,
			Date departureDate) {
		String qurey = "insert into booking(booking_id, schedule_id, customer_id, seat_id, flight_id, price, departure_date) "
				+ "values (?,?,?,?,?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, bookingID);
			statement.setString(2, scheduleID);
			statement.setString(3, customerID);
			statement.setString(4, seatID);
			statement.setString(5, flightID);
			statement.setFloat(6, price);
			statement.setTimestamp(7, new Timestamp(departureDate.getTime()));
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBooking(String bookingID) {
		String qurey = "delete from booking where booking_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, bookingID);
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
