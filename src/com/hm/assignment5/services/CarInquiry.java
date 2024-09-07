package com.hm.assignment5.services;

import com.hm.assignment5.models.Car;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class CarInquiry extends VehicleInquiry {


	@Override
	public Vehicle getSpecificInfo() {
		System.out.println("Enter the number of doors:");
		int doors = Integer.parseInt(InputUtil.getInstance().readLine());
		return new Car(super.getBrand(), super.getModel(), doors);
	}

}
