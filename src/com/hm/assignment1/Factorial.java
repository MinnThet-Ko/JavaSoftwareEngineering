package com.hm.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean willConinue = true;

		// The outer loop is a while loop so that the user can decide when to end
		while (willConinue) {
			System.out.println("Enter a number:");
			int inputNumber = Integer.parseInt(inputReader.readLine());
			int result = 1;

			// The conditions will check the input number to calculate the factorial.
			if (inputNumber == 0) {
				result = 1;
				System.out.println(String.format("Factorial of %d: %d", inputNumber, result));
			} else if (inputNumber > 0) {
				for (int i = inputNumber; i >= 1; i--) {
					result = result * i;
				}
				System.out.println(String.format("Factorial of %d: %d", inputNumber, result));
			} else {
				System.out.println("Factorial is not applicable to negative numbers.");
			}

			System.out.println("Would you like to continue?(y/n)");
			willConinue = inputReader.readLine().strip().toLowerCase().equals("y");
		}

	}

}
