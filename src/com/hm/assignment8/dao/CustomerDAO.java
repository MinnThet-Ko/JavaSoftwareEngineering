package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hm.assignment8.model.Customer;
import com.hm.assignment8.utils.DatabaseUtil;

public class CustomerDAO implements FlightManagementDAO<Customer>{
	
	@Override
	public List<Customer> getAll() {
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
	public Customer select(Object... parameters) {
		Customer resultCustomer = new Customer();
		try {
			String selectFlight = "select * from customer where customer_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, (String)parameters[0]);
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
