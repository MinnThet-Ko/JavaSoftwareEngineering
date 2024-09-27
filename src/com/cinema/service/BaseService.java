package com.cinema.service;

import java.util.List;

import com.cinema.dao.AbstractDAO;

public abstract class BaseService<T> {
	
	private AbstractDAO<T> baseDAO;
	
	public BaseService(AbstractDAO<T> dao) {
		this.baseDAO =dao;
	}
	
	public abstract String getEntityName();
	public void displayMeny() {
		System.out.println("Enter a command:");
		System.out.println("1. Find "+getEntityName()+" name");
		System.out.println("2. Get all "+getEntityName());
		System.out.println("3. Create new "+getEntityName());
		System.out.println("4. Delete "+getEntityName());
		System.out.println("5. Exit");
	}
	
	public abstract T findByID();
	public void findAll() {;
		System.out.println("*** Get all "+getEntityName()+" ***");
		List<T> entityList = this.baseDAO.getAll();
		for(T entity: entityList) {
			System.out.println(entity);
		}
	}
	public abstract boolean create();
	public abstract boolean delete();
	
}
