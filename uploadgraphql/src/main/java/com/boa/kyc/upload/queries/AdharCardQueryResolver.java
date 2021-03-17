package com.boa.kyc.upload.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.services.AdharCardService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class AdharCardQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private AdharCardService adharCardService;
	
	public List<AdharCard> findAllAdharCards(){
		return this.adharCardService.getAllAdharCards();
	}
	

	public AdharCard findAdharCard(String adharCardNo ){
		return this.adharCardService.getAdharCardById(adharCardNo);
	}
}
