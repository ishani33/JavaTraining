package com.visa.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	private static String NAME="";
	
	static {
		ResourceBundle res = ResourceBundle.getBundle("database");// ResourceBundle reads the properties file
		NAME = res.getString("MOBILE_CLAZZ").trim();
	}
	public static MobileDao getMobileDao() {
		//return new MobileDaoDbImpl();
		try {
			return (MobileDao) Class.forName(NAME).newInstance();
		} catch(Exception ex){
			System.out.println(ex);
		}
		return null;
	}
}
