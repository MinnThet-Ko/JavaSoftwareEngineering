package com.hm.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> bookList;
	
	public Library() {
		this.bookList = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		this.bookList.add(book);
	}
	
	public void displayAllBooks() {
		this.bookList.forEach(book -> book.displayInfo());
		System.out.println("Total number of books created: "+ Book.getBookCount());
	}
}
