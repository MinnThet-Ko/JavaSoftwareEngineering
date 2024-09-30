package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.DatabaseUtil;

public class TicketDAO implements BaseDAO<Ticket> {

	private BookingDAO bookingDAO;

	public TicketDAO() {
		this.bookingDAO = new BookingDAO();
	}

	@Override
	public List<Ticket> getAll() {
		String query = "select * from ticket";
		List<Ticket> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Ticket r = new Ticket();
				r.setTicketID(rs.getString("ticket_id"));
				r.setBooking(this.bookingDAO.selectByID(rs.getString("booking_id")));
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
	public Ticket selectByID(String id) {
		Ticket resultTicket = new Ticket();

		String query = "select * from ticket where ticket_id = (?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				resultTicket.setTicketID(rs.getString("ticket_id"));
				resultTicket.setBooking(this.bookingDAO.selectByID(rs.getString("booking_id")));
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultTicket;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Ticket parameters) {
		String qurey = "insert into ticket(ticket_id, booking_id, boarding_time) " + "values (?,?,?);";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, parameters.getTicketID());
			statement.setString(2, parameters.getBooking().getBookingID());
			statement.setTimestamp(3, new Timestamp(parameters.getBooking().getDepartureDate().getTime()));
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		String qurey = "delete from ticket where ticket_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(qurey);
			statement.setString(1, id);
			return statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
