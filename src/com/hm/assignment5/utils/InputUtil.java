package com.hm.assignment5.utils;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeReader() {
		try {
			this.reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
