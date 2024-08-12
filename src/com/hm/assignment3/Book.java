package com.hm.assignment3;

public class Book {
	private static int BOOK_COUNT = 0;
	private String title;
	private String subtitle;

	public Book() {
		BOOK_COUNT++;
		this.title = new String();
		this.subtitle = new String();
	}

	public Book(String title) {
		BOOK_COUNT++;
		this.title = title;
		this.subtitle = "";
	}

	public Book(String title, String subtitle) {
		BOOK_COUNT++;
		this.title = title;
		this.subtitle = subtitle;
	}

	public static int getBookCount() {
		return BOOK_COUNT;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public void displayInfo() {
		System.out.println("Title: " + this.title);
		if (!this.subtitle.isEmpty()) {
			System.out.println("Subtitle: " + this.subtitle);
		}
	}

}
