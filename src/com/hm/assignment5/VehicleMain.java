package com.hm.assignment5;

import com.hm.assignment5.services.CustomerService;
import com.hm.assignment5.services.VehicleService;
import com.hm.assignment5.utils.InputUtil;

public class VehicleMain {

	public static void main(String[] args) {
		VehicleService vehicleService =  new VehicleService();
		CustomerService customerService = new CustomerService();
		
		boolean willContinue = true;
		while(willContinue){
			System.out.println("Enter operation:");
			System.out.println("1. Register vehicle");
			System.out.println("2. Find vehicle by ID");
			System.out.println("3. Update vehicle");
			System.out.println("4. Delete vehicle");
			System.out.println("5. Register customer");
			System.out.println("6. Find customer by ID");
			System.out.println("7. Update customer");
			System.out.println("8. Delete customer");
			
			int choice = InputUtil.getInstance().readInt();
			switch(choice){
			case 1:
				vehicleService.registerVehicle();
				break;
			case 2:
				vehicleService.getVehicle();
				break;
			case 3:
				System.out.println("Service unavailable at the moment.");
				break;
			case 4:
				vehicleService.deleteVehicle();
				break;
			case 5:
				customerService.insertCustomer();
				break;
			case 6:
				customerService.getCustomer();
				break;
			case 7:
				customerService.updateCustomer();
				break;
			case 8:
				customerService.deleteCustomer();
				break;
			
			}
			System.out.println("Do you want to continue?(y/n)");
			willContinue =  InputUtil.getInstance().readLine().toLowerCase().equals("y");
		}
		
		InputUtil.getInstance().closeReader();

	}

}
