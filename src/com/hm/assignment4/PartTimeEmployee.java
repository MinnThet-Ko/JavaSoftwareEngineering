package com.hm.assignment4;

public class PartTimeEmployee extends Employee{

	private int hoursWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name, int employeeId, double basicSalary, int hoursWorked, double hourlyRate) {
		super(name, employeeId, basicSalary);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	
	@Override
	public double calculateSalary() {
		return this.hourlyRate*this.hoursWorked;
	}

}
