package com.hm.assignment3;

public class Student {

	private String name;
	private String[] addresses = new String[2];
	private int[] marks = new int[6];
	private double gpa;

	public Student(String name, String[] addresses, int[] inputMarks) {
		this.name = name;
		this.addresses = addresses;
		this.marks = inputMarks;
		this.gpa = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAddresses() {
		return addresses;
	}

	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	public double getGPA() {
		return this.gpa;
	}

	public void calculateGPA() {
		int total = 0;
		int subCount = 0;
		for (int i = 0; i < 6; i++) {
			total += marks[i];
			subCount += marks[i] > 0? 1:0;
		}
		this.gpa = total /subCount;
	}
	

	public void displayInfo() {
		System.out.println(String.format("Name: %s", this.name));
		System.out.println(String.format("Marks: %d %d %d %d %d %d", this.marks[0], this.marks[1], this.marks[2],
				this.marks[3], this.marks[4], this.marks[5]));
		System.out.println(String.format("GPA: %f", this.gpa));
		System.out.println(String.format("Address 1: %s", this.addresses[0]));
		System.out.println(
				String.format("Address 2: %s", this.addresses[1].isEmpty() ? "Not provides" : this.addresses[1]));

	}

}
