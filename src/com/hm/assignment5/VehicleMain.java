package com.hm.assignment5;

import com.hm.assignment4.ContractEmployee;
import com.hm.assignment5.services.CustomerService;
import com.hm.assignment5.services.RentalContractService;
import com.hm.assignment5.services.RentalOperations;
import com.hm.assignment5.services.VehicleService;
import com.hm.assignment5.utils.InputUtil;

public class VehicleMain {

	public static void main(String[] args) {
		RentalOperations service;

		boolean willContinue = true;
		while (willContinue) {

			System.out.println("What would you want to get service on?");
			System.out.println("1. Vehicle");
			System.out.println("2. Customer");
			System.out.println("3. Contract");

			int choice = InputUtil.getInstance().readInt();
			switch (choice) {
			case 1:
				service = new VehicleService();
				service.getProcessType();
				break;
			case 2:
				service = new CustomerService();
				service.getProcessType();
				break;
			case 3:
				service = new RentalContractService();
				service.getProcessType();
				break;

			}
			System.out.println("Do you want to continue?(y/n)");
			willContinue = InputUtil.getInstance().readLine().toLowerCase().equals("y");
		}

		InputUtil.getInstance().closeReader();

	}

}
