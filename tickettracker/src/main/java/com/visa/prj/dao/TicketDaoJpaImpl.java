package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Ticket;

@Repository
public class TicketDaoJpaImpl implements TicketDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void raiseTicket(Ticket t) {
		em.persist(t);
		
	}

	@Override
	public List<Ticket> listAllOpenTickets() {
		String jpql = "from Ticket t where t.resolvedBy=:arg1 and t.resolvedDate=:arg1 and t.resolvedText=:arg1";
		TypedQuery<Ticket> query = em.createQuery(jpql,Ticket.class);
		query.setParameter("arg1", null);
		return query.getResultList();
	}

	@Override
	public Employee getITEmp() {
		String jpql = "from Employee e where e.department=:arg1";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		query.setParameter("arg1", "IT");
		return query.getResultList().get(0);
	}

	@Override
	public List<Ticket> listAllClosedTickets() {
		String jpql = "from Ticket t where t.resolvedBy and t.resolvedDate and t.resolvedText";
		TypedQuery<Ticket> query = em.createQuery(jpql,Ticket.class);
		//query.setParameter("arg1", null);
		return query.getResultList();
	}


	
}
