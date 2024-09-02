package com.hm.assignment5.services;


import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class VehicleInquiryService implements VehicleInquiry {

	@Override
	public Vehicle getVehicleInfo() {
		String brand = null, model = null;

		System.out.println("Enter brand:");
		brand = InputUtil.getInstance().readLine();

		System.out.println("Enter model: ");
		model = InputUtil.getInstance().readLine();

		return new Vehicle(brand, model);
	}

}
