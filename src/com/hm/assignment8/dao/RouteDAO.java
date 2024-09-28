package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Route;
import com.hm.assignment8.utils.DatabaseUtil;

public class RouteDAO implements BaseDAO<Route> {

	@Override
	public List<Route> getAll() {
		String query = "select * from route";
		List<Route> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Route r = new Route();
				r.setRouteID(rs.getString("route_id"));
				r.setRouteName(rs.getString("route_name"));
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
	public boolean insert(Route parameters) {
		String query = "insert into route (route_id, route_name) values (?,?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getRouteID());
			statement.setString(2, parameters.getRouteName());
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
		String query = "delete from route where route_id = ?";
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
	public Route selectByID(String ID) {
		Route resultRoute = new Route();

		String query = "select * from route where route_id = (?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, ID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				resultRoute.setRouteID(rs.getString("route_id"));
				resultRoute.setRouteName(rs.getString("route_name"));
			}
			DatabaseUtil.getInstance().closeConnection();
			return resultRoute;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Route> selectByCityID(String cityID) {
		List<Route> adjRoutes = new ArrayList<>();
		String query = "select r.* from route r\r\n" + "inner join city_route cr on r.route_id = cr.route_id\r\n"
				+ "where cr.city_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, cityID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Route r = new Route();
				r.setRouteID(rs.getString(1));
				r.setRouteName(rs.getString(2));
				adjRoutes.add(r);
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adjRoutes.isEmpty() ? null : adjRoutes;
	}

}
