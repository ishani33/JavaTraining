package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		// create spring container using annotation
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		// create spring container using web.xml
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		OrderService os = ctx.getBean("orderService", OrderService.class);
		
		Product p = new Product(0,"Logitech Mouse","computer",450.00,1000);
		os.insertProduct(p);
		System.out.println("Inserted : " + p.getId());
		
		p = os.getById(1);
		
		System.out.println(p.getName() + "," + p.getCategory() + "," + p.getPrice());

	}

}
