package com.hm.assignment8.service;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.City;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class CityService extends BaseService<City>{

	public CityService(BaseDAO<City> dao) {
		super(dao);
	}

	@Override
	public String getEntityType() {
		return "city";
	}

	@Override
	public void register() {
		City city = new City();
		city.setCityID("C"+IDGenerator.generateRandomNumber());
		System.out.println("Enter city name:");
		city.setCityName(InputUtil.getInstance().readLine());
		super.getDAO().insert(city);
	}

}
