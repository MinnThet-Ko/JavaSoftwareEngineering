package com.hm.assignment5.dao;

import com.hm.assignment5.models.Customer;

public class CustomerDAO {

	public static int customerCount = 0;
	public static final int MAX_CUSTOMER = 1000;

	private Customer[] customerList = new Customer[MAX_CUSTOMER];
	private static CustomerDAO customerDAO;

	public CustomerDAO() {

	}

	public static CustomerDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new CustomerDAO();
		}
		return customerDAO;
	}

	public void insertCustomer(Customer customer) {
		this.customerList[customerCount] = customer;
	}

	public Customer getCustomerByID(String id) {
		for (int i = 0; i < customerCount; i++) {
			if (this.customerList[i].getId().equals(id)) {
				return this.customerList[i];
			}
		}
		return null;
	}

	public void updateCustomer(Customer customer) {
		for (int i = 0; i < customerCount; i++) {
			if (this.customerList[i].getId().equals(customer.getId())) {
				this.customerList[i] = customer;
			}
		}
	}

	public void removecustomer(String id) {
		for (int i = 0; i < customerCount; i++) {
			if (this.customerList[i].getId().equals(id)) {
				this.customerList[i] = null;
			}
		}
	}

	public void increaseCustomerCount() {
		customerCount++;
	}

	public void decreaseCustomerCount() {
		customerCount--;
	}

	public int getCustomerCount() {
		return customerCount;
	}
}
