package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;

@Service
public class CampaignService {

	@Autowired
	private CampaignDao campaignDao;
	
	public List<Campaign> getCampaign(){
		return campaignDao.findAll();
	}
	
	@Transactional
	public int saveCampaign(Campaign c) {
		campaignDao.save(c);
		double donated = 0.0;
		List<Donation> donations = c.getDonations();
		for(Donation d : donations) {
			donated+=d.getAmount();
		}
		c.setDonated(donated);
		
		return c.getId();
	}
	
	public Campaign getById(int id) {
		return campaignDao.findById(id).get();
	}
}
