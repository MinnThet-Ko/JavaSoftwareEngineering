package com.hm.assignment5.dao;

import com.hm.assignment5.models.Vehicle;

public class VehicleDAO {

	private static int vechicleCount = 0;
	private static final int MAX_VEHICLE = 1000;

	private Vehicle[] vehicleList = new Vehicle[MAX_VEHICLE];
	private static VehicleDAO vehicleDAO;

	public VehicleDAO() {

	}

	public static VehicleDAO getInstance() {
		if (vehicleDAO == null) {
			vehicleDAO = new VehicleDAO();
		}
		return vehicleDAO;
	}

	public void insertVehicle(Vehicle vehicle) {
		this.vehicleList[vechicleCount] = vehicle;
	}

	public Vehicle getVechicleByID(String id) {
		for (int i = 0; i < vechicleCount; i++) {
			if (this.vehicleList[i].getId().equals(id)) {
				return this.vehicleList[i];
			}
		}

		return null;
	}

	public void updateVehicle(Vehicle vehicle) {
		for (int i = 0; i < vechicleCount; i++) {
			if (this.vehicleList[i].getId().equals(vehicle.getId())) {
				this.vehicleList[i] = vehicle;
			}
		}
	}

	public void removeVehicle(String id) {
		for (int i = 0; i < vechicleCount; i++) {
			if (this.vehicleList[i].getId().equals(id)) {
				this.vehicleList[i] = null;
			}
		}
	}

	public void increaseVehicleCount() {
		vechicleCount++;
	}

	public void decreaseVehicleCount() {
		vechicleCount--;
	}

	public int getVechicleCount() {
		return vechicleCount;
	}
}
