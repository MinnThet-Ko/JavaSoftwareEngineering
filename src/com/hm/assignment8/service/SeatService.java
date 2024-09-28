package com.hm.assignment8.service;


import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.Seat;

public class SeatService extends BaseService<Seat>{

	public SeatService(BaseDAO<Seat> dao) {
		super(dao);
	}

	@Override
	public Seat wrapEntityClass(String ID) {
		Seat seat = new Seat();
		seat.setSeatNo(ID);
		return seat;
	}

	@Override
	public String getEntityType() {
		return "seat";
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}
	

}
