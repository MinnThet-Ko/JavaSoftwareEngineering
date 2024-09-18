package com.cinema.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Schedule {
	private int id;
	private Movie movice;
	private Theatre theatre;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Date date;
}
