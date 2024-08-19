package com.hm.assignment4;

public class SMS {

	/*
	 * I didn't add user input functions because I wanted to finish it as fast as possible.
	 */
	public static void main(String[] args) {
		Employee fullTime = new FullTimeEmployee("John", 101, 10000, 2000, 3000);
		Employee partTime = new PartTimeEmployee("Garfield", 102, 0, 120, 30);
		Employee contract = new ContractEmployee("Nermal", 103, 0, 6, 180000);
		fullTime.displayDetails();
		partTime.displayDetails();
		contract.displayDetails();
	}

}
