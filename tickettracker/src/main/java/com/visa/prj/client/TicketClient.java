package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Employee;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService os = ctx.getBean("ticketService", TicketService.class);
		
		Employee e = new Employee();
		e.setEmpId(5746477);
		e.setDepartment("DPD");
		e.setName("Albert");


	}

}
