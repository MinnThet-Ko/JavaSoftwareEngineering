package com.hm.assignment5.dao;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.hm.assignment5.models.Vehicle;

public class VehicleDAO {

	private Vehicle[] vehicleList = new Vehicle[Vehicle.MAX_VEHICLES];

	public void insertVehicle(Vehicle vehicle) {
		this.vehicleList[Vehicle.getVehicleCount()] = vehicle;
	}

	public Vehicle getVechicleByID(String id) {
		return Arrays.asList(this.vehicleList).stream().filter(vehicle -> vehicle.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}
	
	public void updateVehicle(Vehicle vehicle) {
		for(int i = 0; i< Vehicle.getVehicleCount(); i++) {
			if(this.vehicleList[i].getId().equals(vehicle.getId())) {
				this.vehicleList[i] = vehicle;
			}
		}
	}
	
	public void removeVehicle(String id) {
		Arrays.asList(this.vehicleList).removeIf(vehicel -> vehicel.getId().equals(id));
	}
}
