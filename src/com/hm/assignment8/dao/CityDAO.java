package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.City;
import com.hm.assignment8.utils.DatabaseUtil;

public class CityDAO implements BaseDAO<City>{

	@Override
	public List<City> getAll() {
		String query = "select * from city";
		List<City> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				City c = new City();
				c.setCityID(rs.getString("city_id"));
				c.setCityName(rs.getString("city_name"));
				resultList.add(c);
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultList.isEmpty() ? null : resultList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(City parameters) {
		String query = "insert into city (city_id, city_name) values (?,?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getCityID());
			statement.setString(2, parameters.getCityName());
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
		String query = "delete from city where city_id = ?";
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
	public City selectByID(String ID) {
		City resultCity = new City();

		String query = "select * from city where city_id = (?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, ID);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				resultCity.setCityID(rs.getString(1));
				resultCity.setCityName(rs.getString(2));
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultCity;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public City selectCityFromRouteID(String routeID, String startCity) {
		City resultCity = new City();
		String query = "select c.* from city c\r\n"
				+ "inner join city_route cr on c.city_id = cr.city_id\r\n"
				+ "where cr.route_id = ? and cr.city_id != ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, routeID);
			statement.setString(2, startCity);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				resultCity.setCityID(rs.getString("city_id"));
				resultCity.setCityName(rs.getString("city_name"));
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultCity;
			
		}catch(SQLException e){e.printStackTrace();}
		return null;
	}
	

}
