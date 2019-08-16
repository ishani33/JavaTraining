package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;
	
	@Column(name="ticket_desc")
	private String ticketDesc;
	
	@Column(name="raised_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date raisedDate;
	
	@Column(name="raised_by")
	@ManyToOne
	@JoinColumn(name="raisedBy")
	private Employee raisedBy;
	
	@Column(name="resolved_by")
	@ManyToOne
	@JoinColumn(name="resolvedBy")
	private Employee resolvedBy;
	
	@Column(name="resolved_date")
	private Date resolvedDate;
	
	@Column(name="resolved_text")
	private String resolvedText;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDesc() {
		return ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolvedText() {
		return resolvedText;
	}

	public void setResolvedText(String resolvedText) {
		this.resolvedText = resolvedText;
	}

	

}
