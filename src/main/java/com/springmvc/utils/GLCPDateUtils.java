package com.springmvc.utils;

import java.sql.Date;

public class GLCPDateUtils {

	public static Date getNowDate () {
		Date date=new Date(System.currentTimeMillis());
		return date;
	}
	
	public static void main (String args[]) {
		System.out.println(GLCPDateUtils.getNowDate());
	}
}
