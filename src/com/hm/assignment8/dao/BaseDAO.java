package com.hm.assignment8.dao;

import java.util.List;

public interface BaseDAO<T>{
	public  List<T> getAll();
	public boolean insert(T parameters);
	public boolean delete(String id);
	public T selectByID(String id);

}
