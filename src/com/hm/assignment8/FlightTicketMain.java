package com.hm.assignment8;

import com.hm.assignment8.dao.BookingDAO;
import com.hm.assignment8.dao.CustomerDAO;
import com.hm.assignment8.dao.RouteDAO;
import com.hm.assignment8.service.BookingService;
import com.hm.assignment8.service.CustomerService;
import com.hm.assignment8.service.RouteService;
import com.hm.assignment8.utils.InputUtil;

public class FlightTicketMain {
	
	static RouteDAO routeDAO = new RouteDAO();
	static CustomerDAO customerDAO = new CustomerDAO();
	static BookingDAO bookingDAO = new BookingDAO();
	
	public static void displayMenu() {
		System.out.println("*** Customer Related Actions ***");
		System.out.println("1. Customer services");
		System.out.println("2. Booking services");
		System.out.println("3. Route services");
		System.out.println("4. Exit");
	}
	public static void main(String[] args) {
		
		displayMenu();
		int input = InputUtil.getInstance().readInt();
		while(input != 4) {
			
			switch (input) {
			case 1: {
				CustomerService customerService = new CustomerService(customerDAO);
				customerService.call();
				break;
			}
			
			case 2: {
				BookingService bookingService = new BookingService(bookingDAO);
				bookingService.call();
				break;
			}
			
			case 3: {
				RouteService routeService = new RouteService(routeDAO);
				routeService.call();
				break;
			}
			
			default:
				break;
			}
			
			displayMenu();
			input = InputUtil.getInstance().readInt();
			
		}
		InputUtil.getInstance().closeReader();
	}
	

}
