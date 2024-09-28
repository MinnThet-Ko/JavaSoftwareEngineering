package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hm.assignment8.model.Customer;
import com.hm.assignment8.utils.DatabaseUtil;

public class CustomerDAO implements BaseDAO<Customer> {

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
	public boolean delete(String id) {
		String query = "delete from customer where customer_id = ?";
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
	public Customer selectByID(String ID) {
		Customer resultCustomer = new Customer();
		try {
			String selectFlight = "select * from customer where customer_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, ID);
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
