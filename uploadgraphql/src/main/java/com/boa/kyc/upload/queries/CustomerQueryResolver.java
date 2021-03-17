package com.boa.kyc.upload.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;



@Component
public class CustomerQueryResolver implements GraphQLQueryResolver{
    @Autowired
	private CustomerService customerService;
    
    public List<Customer> findAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	

	public Customer findCustomer(long customerId){
		return this.customerService.getCustomerById(customerId);
	}
}
