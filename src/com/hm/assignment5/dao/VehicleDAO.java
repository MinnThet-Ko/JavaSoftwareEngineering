package com.hm.assignment5.dao;

import com.hm.assignment5.models.Vehicle;

public class VehicleDAO {

	private static int vechicleCount = 0;
	private static final int MAX_VEHICLE = 1000;

	private Vehicle[] vehicleList = new Vehicle[MAX_VEHICLE];

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

	public static void increaseVehicleCount() {
		vechicleCount++;
	}

	public static void decreaseVehicleCount() {
		vechicleCount--;
	}

	public static int getVechicleCount() {
		return vechicleCount;
	}
}
