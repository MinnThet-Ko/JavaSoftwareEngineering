package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Booking;
import com.hm.assignment8.utils.DatabaseUtil;;

public class BookingDAO implements BaseDAO<Booking> {

	private CustomerDAO customerDAO;
	private SeatDAO seatDAO;
	private FlightDAO flightDAO;
	private FlightScheduleDAO flightScheduleDAO;

	public BookingDAO() {
		this.customerDAO = new CustomerDAO();
		this.seatDAO = new SeatDAO();
		this.flightDAO = new FlightDAO();
		this.flightScheduleDAO = new FlightScheduleDAO();
	}

	@Override
	public List<Booking> getAll() {
		String query = "select * from Booking";
		List<Booking> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Booking b = new Booking();

				b.setBookingID(rs.getString("Booking_id"));
				b.setPrice(rs.getDouble("price"));
				b.setDepartureDate(rs.getDate("departure_date"));

				b.setCustomer(this.customerDAO.selectByID(rs.getString("customer_id")));

				b.setSeat(this.seatDAO.selectByID(rs.getString("seat_dao")));

				b.setFlight(this.flightDAO.selectByID(rs.getString("flight_id")));

				b.setFlightSchedule(this.flightScheduleDAO.selectByID("schedule_id"));
				resultList.add(b);
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultList.isEmpty() ? null : resultList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Booking parameters) {
		String query = "insert into booking (booking_id, customer_id, schedule_id, seat_id, flight_id, price, departure_date ) \r\n"
				+ "values (?,?,?,?,?,?,?)\r\n" + "on conflict (booking_id)\r\n" + "do update\r\n"
				+ "set customer_id = EXCLUDED.customer_id, schedule_id = EXCLUDED.schedule_id, seat_id = EXCLUDED.seat_id, flight_id = EXCLUDED.flight_id, price = EXCLUDED.price, departure_date = EXCLUDED.departure_date;";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getBookingID());
			statement.setString(2, parameters.getCustomer().getCustomerID());
			statement.setString(3, parameters.getFlightSchedule().getScheduleID());
			statement.setString(4, parameters.getSeat().getSeatNo());
			statement.setString(5, parameters.getFlight().getFlightID());
			statement.setDouble(6, parameters.getPrice());
			statement.setTimestamp(7, new Timestamp(parameters.getDepartureDate().getTime()));
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
		String query = "delete from booking where booking_id = ?";
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
	public Booking selectByID(String ID) {
		String query = "select * from booking where booking_id = ?";
		List<Booking> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, ID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Booking b = new Booking();

				b.setBookingID(rs.getString("Booking_id"));
				b.setPrice(rs.getDouble("price"));
				b.setDepartureDate(rs.getDate("departure_date"));

				b.setCustomer(this.customerDAO.selectByID(rs.getString("customer_id")));

				b.setSeat(this.seatDAO.selectByID(rs.getString("seat_dao")));

				b.setFlight(this.flightDAO.selectByID(rs.getString("flight_id")));

				b.setFlightSchedule(this.flightScheduleDAO.selectByID("schedule_id"));
				resultList.add(b);
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultList.isEmpty() ? null : resultList.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
