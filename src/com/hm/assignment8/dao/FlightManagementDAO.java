package com.hm.assignment8.dao;

import java.util.List;

public interface FlightManagementDAO<T>{
	public  List<T> getAll();
	public boolean insert(Object... parameters);
	public boolean update(Object... parameters);
	public boolean delete(Object... parameters);
	public T select(Object... parameters);

}
