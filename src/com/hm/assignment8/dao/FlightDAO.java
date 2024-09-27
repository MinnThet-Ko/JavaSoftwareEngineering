package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Flight;
import com.hm.assignment8.utils.DatabaseUtil;

public class FlightDAO implements FlightManagementDAO<Flight> {

	@Override
	public List<Flight> getAll() {
		String query = "Select * from flight";
		List<Flight> resultList = new ArrayList<>();
		try{
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Flight f = new Flight();
				f.setFlightID(rs.getString("flight_id"));
				f.setFlightName(rs.getString("flight_name"));
				resultList.add(f);
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultList.isEmpty()? null: resultList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(Flight parameters) {
		String query = "insert into flight(flight_id, flight_name) values (?,?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getFlightID());
			statement.setString(2, parameters.getFlightName());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Flight parameters) {
		String query = "update flight set flight_name = ? where flight_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getFlightName());
			statement.setString(2, parameters.getFlightID());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Flight parameters) {
		String query = "delete from flight where flight_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getFlightID());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Flight select(Flight parameters) {
		Flight resultFlight = new Flight();
		try {
			String selectFlight = "select * from flight where flight_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, parameters.getFlightID());
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
