package com.hm.assignment5.services;

import com.hm.assignment5.models.Car;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class CarInquiryService extends VehicleInquiryService {

	@Override
	public Vehicle getVehicleInfo() {
		Vehicle baseVehicle = super.getVehicleInfo();
		int doors = 0;
		System.out.println("Enter the number of doors:");
		doors = Integer.parseInt(InputUtil.getInstance().readLine());
		baseVehicle = new Car(baseVehicle.getBrand(), baseVehicle.getModel(), doors);
		return baseVehicle;

	}

}
