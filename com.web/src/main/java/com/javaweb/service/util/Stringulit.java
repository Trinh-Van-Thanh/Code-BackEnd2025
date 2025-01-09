package com.javaweb.service.util;

public class Stringulit {
	public static boolean checkString(String data) {
		if (data != null && !data.equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
