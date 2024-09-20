package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.utils.DatabaseUtil;

public class FlightDAO implements FlightManagementDAO<Flight> {

	@Override
	public List<Flight> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object... parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object... parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object... parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Flight select(Object... parameters) {
		Flight resultFlight = new Flight();
		try {
			String selectFlight = "select * from flight where flight_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, (String) parameters[0]);
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
