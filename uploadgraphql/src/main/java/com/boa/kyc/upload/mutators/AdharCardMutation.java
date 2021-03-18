package com.boa.kyc.upload.mutators;


import com.boa.kyc.upload.models.Address;
import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.models.FullName;
import com.boa.kyc.upload.services.AdharCardService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class AdharCardMutation implements GraphQLMutationResolver {

    @Autowired
    private AdharCardService adharCardService;

    public AdharCard addAdharCard(String adharCardNo, FullName name, String dob, Address address) {
    
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
        return this.adharCardService.createAdhardCard(new AdharCard(adharCardNo,name,LocalDate.parse(dob, dtf),address));
    }
}
