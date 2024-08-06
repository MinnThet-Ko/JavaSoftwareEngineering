package com.hm.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationTable {

	public static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean willConinue = true;

		// The outer loop is a while loop so that the user can decide when to end
		while (willConinue) {
			System.out.println("Enter a number:");
			int inputNumber = Integer.parseInt(inputReader.readLine());
		
			for(int i=1;i<=10; i++) {
				System.out.println(String.format("%d x %d = %d", inputNumber, i, inputNumber*i));
			}

			System.out.println("Would you like to continue?(y/n)");
			willConinue = inputReader.readLine().strip().toLowerCase().equals("y");
		}

	}

}
