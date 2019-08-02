package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLCLient {

	public static void main(String[] args) {
		String CREATE_SQL = SQLUtil.generateCreateSQL(Product.class);
		System.out.println(CREATE_SQL);
		
		Product p = new Product(120,"iPhone XR",99999.00,"mobile",100);
		String INSERT_PRODUCT = SQLUtil.generateInsertSQL(p);
		System.out.println(INSERT_PRODUCT);
	}

}
