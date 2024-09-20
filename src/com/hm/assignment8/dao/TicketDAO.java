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
	public boolean insert(Object... parameters) {
		String qurey = "insert into ticket(ticket_id, booking_id, boarding_time) "
				+ "values (?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, (String) parameters[0]);
			statement.setString(2, (String) parameters[1]);
			statement.setTimestamp(3, new Timestamp(((Date)parameters[2]).getTime()));
			return statement.execute();
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
		String qurey = "delete from ticket where ticket_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, (String)parameters[0]);
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Ticket select(Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
