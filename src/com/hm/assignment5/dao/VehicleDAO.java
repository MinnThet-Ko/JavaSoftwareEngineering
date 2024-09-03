package com.hm.assignment5.dao;

import com.hm.assignment5.models.Vehicle;

public class VehicleDAO {

	private Vehicle[] vehicleList = new Vehicle[Vehicle.MAX_VEHICLES];

	public void insertVehicle(Vehicle vehicle) {
		this.vehicleList[Vehicle.getVehicleCount()-1] = vehicle;
	}

	public Vehicle getVechicleByID(String id) {
		for(int i = 0; i< Vehicle.getVehicleCount(); i++) {
			if(this.vehicleList[i].getId().equals(id)) {
				return this.vehicleList[i];
			}
		}
		
		return null;
	}
	
	public void updateVehicle(Vehicle vehicle) {
		for(int i = 0; i< Vehicle.getVehicleCount(); i++) {
			if(this.vehicleList[i].getId().equals(vehicle.getId())) {
				this.vehicleList[i] = vehicle;
			}
		}
	}
	
	public void removeVehicle(String id) {
		for(int i = 0; i< Vehicle.getVehicleCount(); i++) {
			if(this.vehicleList[i].getId().equals(id)) {
				this.vehicleList[i] = null;
			}
		}
	}
}
