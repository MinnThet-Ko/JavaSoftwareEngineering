package com.hm.assignment5.services;

import com.hm.assignment5.dao.CustomerDAO;
import com.hm.assignment5.models.Customer;
import com.hm.assignment5.utils.InputUtil;

/*
 * I know I'm violating the DRY principle a bit but my ADHD brain just wants this done.
 */
public class CustomerService {
	
	private CustomerDAO customerDAO;
	
	public CustomerService() {
		this.customerDAO = new CustomerDAO();
	}
	
	public void insertCustomer() {
		System.out.println("Enter name:");
		String name =  InputUtil.getInstance().readLine();
		System.out.println("Enter age:");
		int age = InputUtil.getInstance().readInt();
		
		this.customerDAO.insertCustomer(new Customer(name, age));
	}
	
	public void deleteCustomer() {
		System.out.print("Enter ID:");
		String id = InputUtil.getInstance().readLine();
		this.customerDAO.removecustomer(id);
	}
	
	public void updateCustomer() {
		System.out.println("Select to update:\n1.Name \n2.Age");
		int choice = InputUtil.getInstance().readInt();
		System.out.println("Enter ID:");
		String id = InputUtil.getInstance().readLine();
		Customer currentCustomer = this.customerDAO.getCustomerByID(id);
		if(choice == 1) {
			System.out.println("Enter name:");
			String name = InputUtil.getInstance().readLine();
			currentCustomer.setName(name);
		}else if(choice == 2) {
			System.out.println("Enter age:");
			int age = InputUtil.getInstance().readInt();
			currentCustomer.setAge(age);
		}
	}
	
	public void getCustomer() {
		System.out.println("Enter ID:");
		String id = InputUtil.getInstance().readLine();
		this.customerDAO.getCustomerByID(id).displayInfo();
	}
}
