package com.hm.assignment8;

import com.hm.assignment8.service.BookingService;
import com.hm.assignment8.service.FlightService;
import com.hm.assignment8.service.RouteService;

public class FlightTicketMain {
	
	public static void main(String[] args) {
		RouteService routeService = new RouteService();
		routeService.testRoutes();
	}

}
