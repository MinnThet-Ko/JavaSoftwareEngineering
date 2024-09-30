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
		System.out.println(String.format("1. Insert %s", getEntityType()));
		System.out.println(String.format("2. Delete %s", getEntityType()));
		System.out.println(String.format("3. Find %s by ID", getEntityType()));
		System.out.println(String.format("4. Find all %s", getEntityType()));
		System.out.println("5. Exit");
	}

	public void call() {
		showMenu();
		int input = InputUtil.getInstance().readInt();
		if (input == 5) {
			return;
		}

		switch (input) {
		case 1:
			register();
			break;
		case 2:
			delete();
			break;
		case 3:
			findByID();
			break;
		case 4:
			findAll();
			break;
		default:
			break;
		}
		call();
	}

	public void findByID() {
		System.out.println(String.format("Enter %s ID:", getEntityType()));
		String inputID = InputUtil.getInstance().readLine();
		System.out.println(this.baseDAO.selectByID(inputID));
	}

	public void findAll() {
		List<T> entityList = this.baseDAO.getAll();
		for (T entity : entityList) {
			System.out.println(entity.toString());
		}
	}

	public void delete() {
		System.out.println(String.format("Enter %s ID:", getEntityType()));
		String inputID = InputUtil.getInstance().readLine();
		this.baseDAO.delete(inputID);
	}

	protected BaseDAO<T> getDAO() {
		return this.baseDAO;
	}

	public abstract String getEntityType();

	public abstract void register();

}
