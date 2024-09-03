package com.hm.assignment5.services;


import com.hm.assignment5.dao.RentalContractDAO;
import com.hm.assignment5.models.RentalContract;
import com.hm.assignment5.utils.InputUtil;

public class RentalContractService {
	
	private RentalContractDAO rentalContractDAO;
	
	public RentalContractService() {
		this.rentalContractDAO =  new RentalContractDAO();
	}
	
	public void insertContract() {
		System.out.println("Enter customer ID");
		String customerId = InputUtil.getInstance().readLine();
		System.out.println("Enter vehicle ID");
		String vehicle = InputUtil.getInstance().readLine();
		System.out.println("Enter duration:");
		int duration = InputUtil.getInstance().readInt();
		this.rentalContractDAO.insertRentalContract(new RentalContract(customerId, vehicle, duration));
	}
	
	public void getContractById() {
		System.out.println("Enter contract ID:");
		String id = InputUtil.getInstance().readLine();
		this.rentalContractDAO.getContractByID(id).displayInfo();
	}
	
	public void updateContract() {
		
	}
	
	public void deleteContract() {
		System.out.println("Enter contract ID:");
		String id = InputUtil.getInstance().readLine();
		this.rentalContractDAO.removeRentalContract(id);
	}
}
