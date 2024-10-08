package com.hm.assignment5.services;

import com.hm.assignment5.dao.VehicleDAO;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class VehicleService implements RentalOperations {

	private VehicleFactory vehicleFactory;

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
		VehicleDAO.getInstance().insertVehicle(this.vehicleFactory.createVehicle());
		VehicleDAO.getInstance().increaseVehicleCount();
	}

	@Override
	public void performRetrieve() {
		System.out.println("Enter vehicle ID:");
		VehicleDAO.getInstance().getVechicleByID(InputUtil.getInstance().readLine()).displayInfo();
	}

	// I'll leave the update method for now.
	// It is time consuming to ask the user WHAT they want to update and I want to
	// move on to other parts of the project.
	@Override
	public void performUpdate() {
		System.out.println("Service not available at the moment.");
	}

	@Override
	public void performDelete() {
		System.out.println("Enter vehicle ID:");
		VehicleDAO.getInstance().removeVehicle(InputUtil.getInstance().readLine());
		VehicleDAO.getInstance().decreaseVehicleCount();
	}

	@Override
	public Vehicle retrieveById() {
		System.out.println("Enter vehicle ID:");
		Vehicle result = VehicleDAO.getInstance().getVechicleByID(InputUtil.getInstance().readLine());
		if (result == null) {
			retrieveById();
		}
		return result;
	}

}
