package com.hm.assignment5.services;

import com.hm.assignment5.models.Motorcycle;
import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class MotorcycleInquiryService extends VehicleInquiryService {

	@Override
	public Vehicle getSpecificInfo() {
		// TODO Auto-generated method stub
		System.out.println("Does it have a side car(y/n):");
		boolean hasSidecar = InputUtil.getInstance().readLine().toLowerCase().equals("y");
		return new Motorcycle(super.getBrand(), super.getModel(), hasSidecar);
	}

}
