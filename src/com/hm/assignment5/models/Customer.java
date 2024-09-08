package com.hm.assignment5.models;

import java.util.Formatter;

import com.hm.assignment5.dao.CustomerDAO;

public class Customer {
	
	private String id;
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.id = "CUS-"+CustomerDAO.getInstance().getCustomerCount();
	}

	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("ID: %s \nName: %s \nAge: %d", this.id,this.name, this.age);
		System.out.println(formatter);
		formatter.close();
	}
}
