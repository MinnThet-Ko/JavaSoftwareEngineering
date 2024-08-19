package com.hm.assignment4;

public class ContractEmployee extends Employee{
	
	private int contractMonths;
	private double contractAmount;
	
	public ContractEmployee(String name, int employeeId, double basicSalary, int contractedMonths, double contractAmount) {
		super(name, employeeId, basicSalary);
		this.contractMonths = contractedMonths;
		this.contractAmount = contractAmount;
	}
	
	@Override
	public double calculateSalary() {
		return this.contractAmount/this.contractMonths;
	}

}
