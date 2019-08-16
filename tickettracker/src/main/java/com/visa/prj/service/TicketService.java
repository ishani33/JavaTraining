package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Report;
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
	
	public void turnAroudTime() {
		List<Ticket> closedTickets = ticketDao.listAllClosedTickets();
		System.out.println();
		for(Ticket t: closedTickets) {
			Report r = new Report(t.getTicketId(), t.getResolvedBy().getName(), t.getRaisedDate(), t.getResolvedDate());
			r.setTime_taken(Math.abs(r.getStartDate().getTime() - r.getEndDate().getTime()));
			System.out.println(r.getId()+" "+t.getTicketDesc()+" "+r.getResolvedBy()+" "+r.getTime_taken());
		}
	}
}
