package com.cinema.dao;

import java.util.List;

public interface AbstractDAO<T>{
	public  List<T> getAll();
	public boolean insert(T parameters);
	public boolean update(T parameters);
	public boolean delete(T parameters);
	public T selectByID(int i);

}
