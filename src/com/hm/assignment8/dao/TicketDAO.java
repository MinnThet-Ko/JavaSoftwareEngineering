package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.DatabaseUtil;

public class TicketDAO implements FlightManagementDAO<Ticket>{

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Ticket parameters) {
		String qurey = "insert into ticket(ticket_id, booking_id, boarding_time) "
				+ "values (?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, parameters.getTicketID());
			statement.setString(2, parameters.getBooking().getBookingID());
			statement.setTimestamp(3, new Timestamp(parameters.getBooking().getDepartureDate() .getTime()));
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Ticket parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Ticket parameters) {
		String qurey = "delete from ticket where ticket_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, parameters.getTicketID());
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Ticket select(Ticket parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
