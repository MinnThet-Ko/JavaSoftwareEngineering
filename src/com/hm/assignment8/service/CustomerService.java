package com.hm.assignment8.service;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.Customer;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class CustomerService extends BaseService<Customer> {

	public CustomerService(BaseDAO<Customer> dao) {
		super(dao);
	}

	@Override
	public String getEntityType() {
		return "customer";
	}

	@Override
	public void register() {
		Customer customer = new Customer();
		System.out.println(customer.getCustomerID());
		System.out.println("Enter customer name:");
		customer.setName(InputUtil.getInstance().readLine());
		super.getDAO().insert(customer);
	}

}
