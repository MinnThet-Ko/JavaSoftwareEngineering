package com.hm.assignment5.dao;



import com.hm.assignment5.models.Customer;

public class CustomerDAO {

	private Customer[] customerList = new Customer[Customer.MAX_CUSTOMER];

	public void insertCustomer(Customer customer) {
		this.customerList[Customer.getCustomerCount() - 1] = customer;
	}

	public Customer getCustomerByID(String id) {
		for (int i = 0; i < Customer.getCustomerCount(); i++) {
			if (this.customerList[i].getId().equals(id)) {
				return this.customerList[i];
			}
		}
		return null;
	}

	public void updateCustomer(Customer customer) {
		for (int i = 0; i < Customer.getCustomerCount(); i++) {
			if (this.customerList[i].getId().equals(customer.getId())) {
				this.customerList[i] = customer;
			}
		}
	}

	public void removecustomer(String id) {
		for (int i = 0; i < Customer.getCustomerCount(); i++) {
			if (this.customerList[i].getId().equals(id)) {
				this.customerList[i] = null;
			}
		}
	}

}
