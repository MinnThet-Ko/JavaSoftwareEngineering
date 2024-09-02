package com.hm.assignment5;

import com.hm.assignment5.services.VehicleService;
import com.hm.assignment5.utils.InputUtil;

public class VehicleMain {

	public static void main(String[] args) {
		VehicleService registerService =  new VehicleService();
		
		boolean willContinue = true;
		while(willContinue){
			registerService.registerVehicle();
			System.out.println("Do you want to continue?(y/n)");
			willContinue =  InputUtil.getInstance().readLine().toLowerCase().equals("y");
		}
		
		InputUtil.getInstance().closeReader();

	}

}
