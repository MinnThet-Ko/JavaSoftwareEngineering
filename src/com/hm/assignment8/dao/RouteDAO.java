package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Route;
import com.hm.assignment8.utils.DatabaseUtil;

public class RouteDAO implements FlightManagementDAO<Route>{

	@Override
	public List<Route> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Route parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Route parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Route parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Route select(Route parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Route> selectByCityID(String cityID){
		List<Route> adjRoutes = new ArrayList<>();
		String query = "select r.* from route r\r\n"
				+ "inner join city_route cr on r.route_id = cr.route_id\r\n"
				+ "where cr.city_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, cityID);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Route r = new Route();
				r.setRouteID(rs.getString(1));
				r.setRouteName(rs.getString(2));
				adjRoutes.add(r);
			}
			DatabaseUtil.getInstance().closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return adjRoutes.isEmpty()? null: adjRoutes;
	}
}
