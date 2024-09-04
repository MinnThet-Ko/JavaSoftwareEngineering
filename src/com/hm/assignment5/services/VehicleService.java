package com.hm.assignment5.services;

import com.hm.assignment5.dao.VehicleDAO;
import com.hm.assignment5.utils.InputUtil;

public class VehicleService implements RentalOperations {

	private VehicleFactory vehicleFactory;
	private VehicleDAO vehicleDAO;

	public VehicleService() {
		this.vehicleFactory = new VehicleFactory();
	}

	@Override
	public void getProcessType() {
		System.out.println("Enter operation:");
		System.out.println("1. Register vehicle");
		System.out.println("2. Find vehicle by ID");
		System.out.println("3. Update vehicle");
		System.out.println("4. Delete vehicle");
		int choice = InputUtil.getInstance().readInt();

		switch (choice) {
		case 1:
			performRegisterService();
			break;

		case 2:
			performRetrieveService();
			break;

		case 3:
			performUpdateService();
			break;

		case 4:
			performDeleteService();
			break;
		}

	}

	@Override
	public void performRegisterService() {
		this.vehicleDAO.insertVehicle(this.vehicleFactory.createVehicle());
	}

	@Override
	public void performRetrieveService() {
		System.out.println("Enter vehicle ID:");
		this.vehicleDAO.getVechicleByID(InputUtil.getInstance().readLine()).displayInfo();
	}

	// I'll leave the update method for now.
	// It is time consuming to ask the user WHAT they want to update and I want to
	// move on to other parts of the project.
	@Override
	public void performUpdateService() {
		System.out.println("Service not available at the moment.");
	}

	@Override
	public void performDeleteService() {
		System.out.println("Enter vehicle ID:");
		this.vehicleDAO.removeVehicle(InputUtil.getInstance().readLine());
	}

}
