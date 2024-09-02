package com.hm.assignment5.services;

import com.hm.assignment5.dao.VehicleDAO;
import com.hm.assignment5.utils.InputUtil;

public class VehicleService {

	private VehicleFactory vehicleFactory;
	private VehicleDAO vehicleDAO;
	
	public VehicleService() {
		this.vehicleFactory = new VehicleFactory();
	}
	
	public void registerVehicle() {
		this.vehicleDAO.insertVehicle(this.vehicleFactory.createVehicle());
	}
	
	public void getVehicle() {
		System.out.println("Enter vehicle ID:");
		this.vehicleDAO.getVechicleByID(InputUtil.getInstance().readLine());
	}
	
	public void deleteVehicle() {
		System.out.println("Enter vehicle ID:");
		this.vehicleDAO.removeVehicle(InputUtil.getInstance().readLine());
	}
	
	//I'll leave the update method for now.
	//It is time consuming to ask the user WHAT they want to update and I want to move on to other parts of the project.

}
