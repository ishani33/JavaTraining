package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

public interface TicketDao {

	void raiseTicket(Ticket t);
	List<Ticket> listAllOpenTickets();
	List<Ticket> listAllClosedTickets();
	Employee getITEmp();
}
