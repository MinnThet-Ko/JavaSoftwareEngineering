package com.hm.assignment4;

import java.util.Formatter;

public class Employee {
	private String name;
	private int employeeId;
	private double basicSalary;

	public Employee(String name, int employeeId, double basicSalary) {
		this.name = name;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
	}

	public String getName() {
		return name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public double calculateSalary() {
		return this.basicSalary;
	}

	public void displayDetails() {
		Formatter formatter = new Formatter();
		System.out.println(formatter.format("Name: %s \nEmployee ID: %d \nBasic salary: %f", this.name, this.employeeId, this.calculateSalary()));
		formatter.close();
	}
}
