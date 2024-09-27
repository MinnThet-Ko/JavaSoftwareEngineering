package com.cinema.models;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
	private int id;
	private String name;
	private String address;
	private List<Theatre> theatreList =  new ArrayList<>();
	
	
	public Cinema() {
	}


	public Cinema(int id, String name, String address, List<Theatre> theatreList) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.theatreList = theatreList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Theatre> getTheatreList() {
		return theatreList;
	}


	public void setTheatreList(List<Theatre> theatreList) {
		this.theatreList = theatreList;
	}
	
	
	
	
}
