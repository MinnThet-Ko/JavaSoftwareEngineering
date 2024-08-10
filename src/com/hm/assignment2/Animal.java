package com.hm.assignment2;

public class Animal {

	public static int ANIMAL_COUNT = 0;
	private String name;
	private int age;
	private String species;

	public Animal(String name, int age, String species) {
		ANIMAL_COUNT++;
		this.name = name;
		this.age = age;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void display() {
		System.out.println(String.format("Name: %s", this.name));
		System.out.println(String.format("Age: %d", this.age));
		System.out.println(String.format("Species: %s", this.species));
	}
}
