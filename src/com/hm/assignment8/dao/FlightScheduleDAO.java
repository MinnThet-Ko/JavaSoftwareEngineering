package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.model.FlightSchedule;
import com.hm.assignment8.model.Route;
import com.hm.assignment8.utils.DatabaseUtil;

public class FlightScheduleDAO {

	public List<FlightSchedule> getAllFlightSchedules() {
		List<FlightSchedule> resultScheduleList = new ArrayList<>();
		String query = "select * from flight_schedule where departure_date > ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, new Timestamp(new java.util.Date().getTime()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				FlightSchedule fs = new FlightSchedule();
				Flight f = new Flight();
				Route r = new Route();
				f.setFlightID(rs.getString("flight_id"));
				r.setRouteID(rs.getString("route_id"));
				fs.setScheduleID(rs.getString("schedule_id"));
				fs.setDepartureTime(rs.getTimestamp("departure_date"));
				fs.setFlight(f);
				fs.setRoute(r);
				resultScheduleList.add(fs);
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultScheduleList;
	}

	public FlightSchedule getFlightScheduleByID(String scheduleID) {
		List<FlightSchedule> resultScheduleList = new ArrayList<>();
		String query = "select * from flight_schedule where schedule_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setObject(1, scheduleID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				FlightSchedule fs = new FlightSchedule();
				Flight f = new Flight();
				Route r = new Route();
				f.setFlightID(rs.getString("flight_id"));
				r.setRouteID(rs.getString("route_id"));
				fs.setScheduleID(rs.getString("schedule_id"));
				fs.setDepartureTime(rs.getTimestamp("departure_date"));
				fs.setFlight(f);
				fs.setRoute(r);
				resultScheduleList.add(fs);
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultScheduleList.isEmpty() ? null : resultScheduleList.get(0);
	}

}
