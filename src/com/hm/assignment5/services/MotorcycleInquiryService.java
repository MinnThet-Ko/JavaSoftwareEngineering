package com.hm.assignment5.services;

import com.hm.assignment5.models.Motorcycle;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class MotorcycleInquiryService extends VehicleInquiryService {

	@Override
	public Vehicle getVehicleInfo() {
		Vehicle baseVehicle = super.getVehicleInfo();
		boolean hasSidecar = false;

		System.out.println("Does it have a side car(y/n):");
		hasSidecar = InputUtil.getInstance().readLine().toLowerCase().equals("y");
		baseVehicle = new Motorcycle(baseVehicle.getBrand(), baseVehicle.getModel(), hasSidecar);

		return baseVehicle;

	}

}
