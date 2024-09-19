package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.utils.DatabaseUtil;

public class FlightDAO{
	
	public Flight getFlightByID(String flightID) {
		Flight resultFlight = new Flight();
		try {
			String selectFlight = "select * from flight where flight_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, flightID);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				resultFlight.setFlightID(resultSet.getString("flight_id"));
				resultFlight.setFlightName(resultSet.getString("flight_name"));
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultFlight;
	}
	
}
