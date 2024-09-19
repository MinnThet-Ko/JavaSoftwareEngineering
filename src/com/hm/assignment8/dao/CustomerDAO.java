package com.hm.assignment8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hm.assignment8.model.Customer;
import com.hm.assignment8.utils.DatabaseUtil;

public class CustomerDAO {
	
	public Customer getCustomerByID(String flightID) {
		Customer resultCustomer = new Customer();
		try {
			String selectFlight = "select * from customer where customer_id = ?";
			PreparedStatement statement = DatabaseUtil.getInstance().getConnection().prepareStatement(selectFlight);
			statement.setObject(1, flightID);
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
