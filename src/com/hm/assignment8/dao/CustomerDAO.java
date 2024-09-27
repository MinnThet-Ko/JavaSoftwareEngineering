package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Customer;
import com.hm.assignment8.utils.DatabaseUtil;

public class CustomerDAO implements FlightManagementDAO<Customer> {

	@Override
	public List<Customer> getAll() {
		String query = "select * from customer";
		List<Customer> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomerID(rs.getString("customer_id"));
				c.setName(rs.getString("customer_name"));
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
	public boolean insert(Customer parameters) {
		String query = "insert into customer (customer_id, customer_name) values (?,?)";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getCustomerID());
			statement.setString(2, parameters.getName());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Customer parameters) {
		String query = "update customer set customer_name = ? where customer_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getName());
			statement.setString(2, parameters.getCustomerID());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Customer parameters) {
		String query = "delete from customer where customer_id = ?";
		try {
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(query);
			statement.setString(1, parameters.getCustomerID());
			statement.executeUpdate();
			DatabaseUtil.getInstance().closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer select(Customer parameters) {
		Customer resultCustomer = new Customer();
		try {
			String selectFlight = "select * from customer where customer_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, parameters.getCustomerID());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				resultCustomer.setCustomerID(resultSet.getString("customer_id"));
				resultCustomer.setName((resultSet.getString("customer_name")));
			}
			DatabaseUtil.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCustomer;
	}
}
