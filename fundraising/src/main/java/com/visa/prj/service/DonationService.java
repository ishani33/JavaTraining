package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.DonationDao;
import com.visa.prj.entity.Donation;

@Service
public class DonationService {

	@Autowired
	private DonationDao donationDao;
	
	public List<Donation> getDonation(){
		return donationDao.findAll();
	}
	
	@Transactional
	public int saveDonation(Donation d) {
		donationDao.save(d);
		return d.getDid();
	}
	
	public Donation getById(int did) {
		return donationDao.findById(did).get();
	}
}
