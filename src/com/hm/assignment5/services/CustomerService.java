package com.hm.assignment5.services;

import com.hm.assignment5.dao.CustomerDAO;
import com.hm.assignment5.models.Customer;
import com.hm.assignment5.utils.InputUtil;

/*
 * I know I'm violating the DRY principle a bit but my ADHD brain just wants this done.
 */
public class CustomerService implements RentalOperations{
	
	private CustomerDAO customerDAO;
	
	public CustomerService() {
		this.customerDAO = new CustomerDAO();
	}
	
	@Override
	public void getProcessType() {
		System.out.println("Enter operation:");
		System.out.println("1. Register customer");
		System.out.println("2. Find customer by ID");
		System.out.println("3. Update customer");
		System.out.println("4. Delete customer");
		int choice = InputUtil.getInstance().readInt();

		switch (choice) {
		case 1:
			performRegister();
			break;

		case 2:
			performRetrieve();
			break;

		case 3:
			performUpdate();
			break;

		case 4:
			performDelete();
			break;
		}
	}
	
	@Override
	public void performRegister() {
		System.out.println("Enter name:");
		String name =  InputUtil.getInstance().readLine();
		System.out.println("Enter age:");
		int age = InputUtil.getInstance().readInt();
		
		this.customerDAO.insertCustomer(new Customer(name, age));
		CustomerDAO.increaseCustomerCount();
	}
	
	@Override
	public void performUpdate() {
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
	
	@Override
	public void performRetrieve() {
		System.out.println("Enter ID:");
		String id = InputUtil.getInstance().readLine();
		this.customerDAO.getCustomerByID(id).displayInfo();
	}
	
	@Override
	public void performDelete() {
		System.out.print("Enter ID:");
		String id = InputUtil.getInstance().readLine();
		this.customerDAO.removecustomer(id);
		CustomerDAO.decreaseCustomerCount();
	}

	
	
	
	
	
}