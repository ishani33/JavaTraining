package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	private double donated;
	
	public double getDonated() {
		return donated;
	}
	public void setDonated(double donated) {
		this.donated = donated;
	}
	@Column(name="total_amount")
	private double totalAmount;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date deadline;
	
	@Column(name="campaign_status")
	private String campaignStatus;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="campaign_id")
	private List<Donation> donations = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCampaignStatus() {
		return campaignStatus;
	}
	public void setCampaignStatus(String campaignStatus) {
		this.campaignStatus = campaignStatus;
	}
	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return campaignStatus;
	}
	public void setStatus(String campaignStatus) {
		this.campaignStatus = campaignStatus;
	}
	public List<Donation> getDonations() {
		return donations;
	}
	public void setItems(List<Donation> donations) {
		this.donations = donations;
	}
	
	
	
}
