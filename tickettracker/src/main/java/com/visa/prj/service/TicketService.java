package com.visa.prj.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	
	@Transactional
	public void resolveTicket(Ticket t) {
		Employee resolvedBy = ticketDao.getITEmp();
		t.setResolvedBy(resolvedBy);
		t.setResolvedDate(new Date());
		t.setResolvedText("Solved");
	}
}
