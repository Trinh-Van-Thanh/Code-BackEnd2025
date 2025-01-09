package com.javaweb.service.util;

public class Numberutil {
	public static boolean isNumber(String value) {
		try {
			Long number = Long.parseLong(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
