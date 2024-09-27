package com.hm.assignment8.dao;

import java.util.List;

public interface FlightManagementDAO<T>{
	public  List<T> getAll();
	public boolean insert(T parameters);
	public boolean update(T parameters);
	public boolean delete(T parameters);
	public T select(T parameters);

}
