package com.visa.prj.entity;

import java.util.Date;

public class Report {

	private int id;
	private String resolvedBy;
	private long time_taken;
	private Date startDate;
	private Date endDate;
	
	public Report(int id, String resolvedBy, Date startDate, Date endDate) {
		this.id = id;
		this.resolvedBy = resolvedBy;
		this.time_taken = 0;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public long getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(long time_taken) {
		this.time_taken = time_taken;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
