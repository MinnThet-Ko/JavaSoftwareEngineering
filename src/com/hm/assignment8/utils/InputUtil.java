package com.hm.assignment8.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InputUtil {
	
	private static InputUtil inputUtil;
	
	private BufferedReader reader;
	private InputUtil() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static InputUtil getInstance() {
		if(inputUtil == null) {
			inputUtil = new InputUtil();
		}
		return inputUtil;
	}
	
	public String readLine() {
		try {
			return this.reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int readInt() {
		return Integer.parseInt(readLine());
	}
	
	public double readDouble() {
		return Double.parseDouble(readLine());
	}
	
	public Date readDate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			return format.parse(readLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeReader() {
		try {
			this.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
