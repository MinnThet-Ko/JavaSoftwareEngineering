package com.hm.assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SMMS {

	public static List<Student> studentList = new ArrayList<>();

	public static void showMeanMarks() {
		int[] totalMarks = new int[6];
		for(Student s: studentList) {
			for(int i=0; i<6; i++) {
				totalMarks[i] = s.getMarks()[i];
			}
		}
		System.out.println("Mean Marks:");
		for (int i = 0; i < 6; i++) {
			System.out.println(String.format("Subject %d: %d", i+1, totalMarks[i]/studentList.size()));
			
		}
		
	}

	public static void inputData() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean continueInput = true;
		while (continueInput) {
			System.out.println("Enter details for a new student:");

			System.out.println("Name: ");
			String name = reader.readLine().trim();

			System.out.println("Enter marks for 6 subjects (or less, defaults to 0):");
			int inputMarks[] = new int[6];
			for (int i = 0; i < 6; i++) {
				System.out.println(String.format("Subject %d", i + 1));
				String inputMarkString = reader.readLine().trim();
				inputMarks[i] = inputMarkString.isEmpty() ? 0 : Integer.parseInt(inputMarkString);
			}

			String addresses[] = new String[2];
			System.out.println("Address 1: ");
			addresses[0] = reader.readLine().trim();

			System.out.println("Enter address 2 (or press Enter to skip) ");
			addresses[1] = reader.readLine().trim();

			Student newStudent = new Student(name, addresses, inputMarks);
			newStudent.calculateGPA();
			studentList.add(newStudent);

			System.out.println("Do you want to enter another student? (yes/no):");
			continueInput = reader.readLine().toLowerCase().equals("yes");

		}
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		inputData();
		showMeanMarks();
		System.out.println("Student with the highest GPA:");
		for(Student s: studentList) {
			s.displayInfo();
		}
		studentList
	      .stream()
	      .min(Comparator.comparing(Student::getGPA))
	      .orElseThrow(NoSuchElementException::new).displayInfo();;

	}

}
