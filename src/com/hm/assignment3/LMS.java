package com.hm.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hm.assignment2.Animal;

public class LMS {

	public static Library library = new Library();
	
	public static void inputData() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean continueInput = true;
		while (continueInput) {
			System.out.println("Enter details for a new book: Title:");
			String title = reader.readLine();

			System.out.println("Subtitle (or press Enter to skip): ");
			String subtitle = reader.readLine().trim();

			
			System.out.println("Do you want to enter another book? (yes/no):");
			continueInput = reader.readLine().toLowerCase().equals("yes");
			if(subtitle.isEmpty()) {
				library.addBook(new Book(title));
			}else {
				library.addBook(new Book(title, subtitle));
			}

		}
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		inputData();
		library.displayAllBooks();

	}

}
