package com.hm.assignment5.services;


import com.hm.assignment5.dao.RentalContractDAO;
import com.hm.assignment5.models.RentalContract;
import com.hm.assignment5.utils.InputUtil;

public class RentalContractService implements RentalOperations{
	
	private RentalContractDAO rentalContractDAO;
	
	public RentalContractService() {
		this.rentalContractDAO =  new RentalContractDAO();
	}
	
	@Override
	public void getProcessType() {
		System.out.println("Enter operation:");
		System.out.println("1. Register contract");
		System.out.println("2. Find contract by ID");
		System.out.println("3. Update contract");
		System.out.println("4. Delete contract");
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
		System.out.println("Enter customer ID");
		String customerId = InputUtil.getInstance().readLine();
		System.out.println("Enter vehicle ID");
		String vehicle = InputUtil.getInstance().readLine();
		System.out.println("Enter duration:");
		int duration = InputUtil.getInstance().readInt();
		this.rentalContractDAO.insertRentalContract(new RentalContract(customerId, vehicle, duration));
		RentalContractDAO.increaseContractCount();
	}
	
	@Override
	public void performRetrieve() {
		System.out.println("Enter contract ID:");
		String id = InputUtil.getInstance().readLine();
		this.rentalContractDAO.getContractByID(id).displayInfo();
	}
	
	@Override
	public void performUpdate() {
		System.out.println("Service not available at the moment.");
	}
	
	@Override
	public void performDelete() {
		System.out.println("Enter contract ID:");
		String id = InputUtil.getInstance().readLine();
		this.rentalContractDAO.removeRentalContract(id);
		RentalContractDAO.decreaseContractCount();
	}


	
}
