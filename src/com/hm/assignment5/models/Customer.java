package com.hm.assignment5.models;

import java.util.Formatter;

public class Customer {
	
	public static final int MAX_CUSTOMER = 1000;
	private static int customerCount = 0 ;
	private String id;
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		customerCount++;
		this.id = "CUS-"+customerCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public static int getCustomerCount() {
		return customerCount;
	}

	public void displayInfo() {
		Formatter formatter = new Formatter();
		formatter.format("ID: %s \nName: %s \nAge: %d", this.id,this.name, this.age);
		System.out.println(formatter);
		formatter.close();
	}
}
