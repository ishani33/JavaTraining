package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visa.prj.entity.Campaign;
import com.visa.prj.service.CampaignService;

@Service
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@GetMapping("campaigns")
	public @ResponseBody List<Campaign> getCampaigns(){
		return campaignService.getCampaign();
	}
	
	@GetMapping("campaigns/{id}")
	public @ResponseBody Campaign getCampaignsById(@PathVariable("id") int id) {
		return campaignService.getById(id);
	}
	
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign c){
		campaignService.saveCampaign(c);
		return new ResponseEntity<>(c,HttpStatus.CREATED); //201
	}
}
