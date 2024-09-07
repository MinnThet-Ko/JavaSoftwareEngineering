package com.hm.assignment5.services;

import com.hm.assignment5.models.Truck;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class TruckInquiry extends VehicleInquiry {

	@Override
	public Vehicle getSpecificInfo() {

		System.out.println("Enter load capacity:");
		double loadCapacity = Double.parseDouble(InputUtil.getInstance().readLine());
		return new Truck(super.getBrand(), super.getModel(), loadCapacity);

	}

}
