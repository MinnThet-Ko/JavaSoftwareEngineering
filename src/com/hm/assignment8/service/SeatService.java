package com.hm.assignment8.service;


import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.Seat;
import com.hm.assignment8.utils.ClassWrapperUtil;
import com.hm.assignment8.utils.InputUtil;

public class SeatService extends BaseService<Seat>{

	public SeatService(BaseDAO<Seat> dao) {
		super(dao);
	}


	@Override
	public String getEntityType() {
		return "seat";
	}

	@Override
	public void register() {
		Seat seat = new Seat();
		System.out.println("Enter seat ID:");
		seat.setSeatNo(InputUtil.getInstance().readLine());
		System.out.println("Enter flight ID:");
		seat.setFlight(ClassWrapperUtil.wrapFlight(InputUtil.getInstance().readLine()));
		super.getDAO().insert(seat);
	}
	

}
