package com.hm.assignment5.services;

import com.hm.assignment5.models.Vehicle;
import com.hm.assignment5.utils.InputUtil;

public class VehicleFactory {
	
	private VehicleInquiry inquiryService;
	
	public Vehicle createVehicle() {
		getVehicleType();
		return this.inquiryService.getVehicleInfo();
	}
	
	public void getVehicleType() {
		System.out.println("Enter vehicle type: \n1. Car\n2. Truck\n3. Motorcycle");
		int vehicleType = Integer.parseInt(InputUtil.getInstance().readLine());
		switch( vehicleType) {
			case 1:{
				this.inquiryService =  new CarInquiryService();
				break;
			}
			case 2: {
				this.inquiryService =  new TruckInquiryService();
				break;
			}
			case 3: {
				this.inquiryService = new MotorcycleInquiryService();
			}
			default: break;
		}
			
	}
	
	
	

}
