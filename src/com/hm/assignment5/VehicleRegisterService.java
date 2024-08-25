package com.hm.assignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class VehicleRegisterService {

	/*
	 * I did not implement the data persistence features because it is not mentioned in the requirement document. 
	 */
	public static void inputData() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean continueInput = true;
		while (continueInput) {

			System.out.println("Enter vehicle type: \n1. Car \n2. Truck \n3. Motorcycle");
			int vehicleType = Integer.parseInt(reader.readLine());

			System.out.println("Enter brand:");
			String brand = reader.readLine();

			System.out.println("Enter model: ");
			String model = reader.readLine().trim();

			switch (vehicleType) {
			case 1: {
				System.out.println("Enter the number of doors:");
				int doors = Integer.parseInt(reader.readLine());
				Vehicle car = new Car(brand, model, doors);
				car.displayInfo();
				break;
			}
			case 2:{
				System.out.println("Enter payload capacity:");
				double payloadCapacity = Double.parseDouble(reader.readLine());
				Vehicle truck = new Truck(brand, model, payloadCapacity);
				truck.displayInfo();
				break;
			}
			
			case 3: {
				System.out.println("Does it have a side car(y/n):");
				boolean hasSidecar = reader.readLine().toLowerCase().equals("y");
				Vehicle motorcycle = new Motorcycle(brand, model, hasSidecar);
				motorcycle.displayInfo();
				break;
			}
			}
			System.out.println("Do you want to continue? (y/n):");
			continueInput = reader.readLine().toLowerCase().equals("y");

		}
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		inputData();

	}

}
