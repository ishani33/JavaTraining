package com.visa.training.jdbc;

import java.util.List;

public class ProductApp {

	public static void main(String[] args) {
		JdbcProductDAO dao = new JdbcProductDAO();
		Product test = new Product("test", 19999, 100);
		Product saved = dao.save(test);
		System.out.println("created product with id="+saved.getId());
		List<Product> all = dao.findAll();
		all.forEach(System.out::println);

	}

}
