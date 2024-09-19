package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.hm.assignment8.utils.DatabaseUtil;

public class TicketDAO {

	public boolean saveTicket(String ticketID, String bookingID, Date boardingTime) {
		String qurey = "insert into ticket(ticket_id, booking_id, boarding_time) "
				+ "values (?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, ticketID);
			statement.setString(2, bookingID);
			statement.setTimestamp(3, new Timestamp(boardingTime.getTime()));
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteTicket(String ticketID) {
		String qurey = "delete from ticket where ticket_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, ticketID);
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
