package com.hm.assignment5.services;

import com.hm.assignment5.models.Truck;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class TruckInquiryService extends VehicleInquiryService {

	@Override
	public Vehicle getVehicleInfo() {
		Vehicle baseVehicle = super.getVehicleInfo();
		double loadCapacity;

		System.out.println("Enter load capacity:");
		loadCapacity = Double.parseDouble(InputUtil.getInstance().readLine());
		baseVehicle = new Truck(baseVehicle.getBrand(), baseVehicle.getModel(), loadCapacity);

		return baseVehicle;

	}

}
