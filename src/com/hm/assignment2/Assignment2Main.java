package com.hm.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Assignment2Main {

	public static List<Animal> animalList = new ArrayList();

	public static void inputData() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean continueInput = true;
		while (continueInput) {
			System.out.println("Enter animal name:");
			String name = reader.readLine();

			System.out.println("Enter animal age:");
			int age = Integer.parseInt(reader.readLine());

			System.out.println("Enter animal species:");
			String species = reader.readLine();

			System.out.println("Do you want to enter another animal? (yes/no) ");
			continueInput = reader.readLine().toLowerCase().equals("yes");
			animalList.add(new Animal(name, age, species));

		}
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		inputData();

		System.out.println(String.format("Total number of animals: %d", animalList.size()));
		for (int i = 1; i <= animalList.size(); i++) {
			System.out.println(String.format("Animal: %d", i));
			animalList.get(i - 1).display();
		}

	}

}
