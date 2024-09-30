package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.utils.DatabaseUtil;

public class FlightScheduleDAO implements BaseDAO<FlightSchedule>{
	
	private FlightDAO flightDAO;
	private RouteDAO routeDAO;
	
	public FlightScheduleDAO() {
		this.flightDAO = new FlightDAO();
		this.routeDAO = new RouteDAO();
	}

	@Override
	public List<FlightSchedule> getAll() {
		List<FlightSchedule> resultScheduleList = new ArrayList<>();
		String query = "select * from flight_schedule where departure_date > ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, new Timestamp(new java.util.Date().getTime()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				FlightSchedule fs = new FlightSchedule();
				fs.setScheduleID(rs.getString("schedule_id"));
				fs.setDepartureTime(rs.getTimestamp("departure_date"));
				fs.setFlight(this.flightDAO.selectByID(rs.getString("flight_id")));
				fs.setRoute(this.routeDAO.selectByID(rs.getString("route_id")));
				resultScheduleList.add(fs);
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultScheduleList;
	}

	@Override
	public boolean insert(FlightSchedule parameters) {
		String query = "insert into flight_schedule (schedule_id, flight_id, route_id, departure_date ) \r\n"
				+ "values (?,?,?,?)\r\n";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getScheduleID());
			statement.setString(2, parameters.getFlight().getFlightID());
			statement.setString(3, parameters.getRoute().getRouteID());
			statement.setTimestamp(4,new Timestamp(parameters.getDepartureTime().getTime()) );
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
		String query = "delete from flight_schedule where schedule_id = ?";
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
	public FlightSchedule selectByID(String ID) {
		List<FlightSchedule> resultScheduleList = new ArrayList<>();
		String query = "select * from flight_schedule where schedule_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, ID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				FlightSchedule fs = new FlightSchedule();
				fs.setScheduleID(rs.getString("schedule_id"));
				fs.setDepartureTime(rs.getTimestamp("departure_date"));
				fs.setFlight(this.flightDAO.selectByID(rs.getString("flight_id")));
				fs.setRoute(this.routeDAO.selectByID(rs.getString("route_id")));
				resultScheduleList.add(fs);
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultScheduleList.isEmpty() ? null : resultScheduleList.get(0);
	}

}
