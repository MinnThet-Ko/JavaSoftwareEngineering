package com.cinema.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	public void closeReader() {
		try {
			this.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
