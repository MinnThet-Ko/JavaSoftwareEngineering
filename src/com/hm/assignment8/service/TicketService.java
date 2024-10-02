package com.hm.assignment8.service;

import com.hm.assignment8.dao.BaseDAO;
import com.hm.assignment8.model.Ticket;
import com.hm.assignment8.utils.ClassWrapperUtil;
import com.hm.assignment8.utils.IDGenerator;
import com.hm.assignment8.utils.InputUtil;

public class TicketService extends BaseService<Ticket>{

	public TicketService(BaseDAO<Ticket> dao) {
		super(dao);
	}

	@Override
	public String getEntityType() {
		return "ticket";
	}

	@Override
	public void register() {
		Ticket ticket = new Ticket();
		ticket.setTicketID("T"+IDGenerator.generateRandomNumber());
		System.out.println("Enter booking ID");
		ticket.setBooking(ClassWrapperUtil.wrapBooking(InputUtil.getInstance().readLine()));
		super.getDAO().insert(ticket);
	}

}
