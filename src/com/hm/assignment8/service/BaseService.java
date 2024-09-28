package com.hm.assignment8.service;

import java.util.List;

import com.cinema.utils.InputUtil;
import com.hm.assignment8.dao.BaseDAO;

public abstract class BaseService<T> {

	private BaseDAO<T> baseDAO;

	public BaseService(BaseDAO<T> dao) {
		this.baseDAO = dao;
	}

	public void showMenu() {
		System.out.println("Choose an operation:");
		System.out.println(String.format("Insert %s", getEntityType()));
		System.out.println(String.format("Delete %s", getEntityType()));
		System.out.println(String.format("Find %s by ID", getEntityType()));
		System.out.println(String.format("Find all %s", getEntityType()));
	}

	public void findByID() {
		System.out.println(String.format("Enter %s ID:", getEntityType()));
		String inputID = InputUtil.getInstance().readLine();
		System.out.println(this.baseDAO.selectByID(inputID));
	}

	public void findAll() {
		List<T> entityList =  this.baseDAO.getAll();
		for(T entity: entityList) {
			System.out.println(entity.toString());
		}
	}
	
	public void delete() {
		System.out.println(String.format("Enter %s ID:", getEntityType()));
		String inputID = InputUtil.getInstance().readLine();
		this.baseDAO.delete(inputID);
	}
	
	

	public abstract T wrapEntityClass(String ID);

	public abstract String getEntityType();

	public abstract void register();

}
