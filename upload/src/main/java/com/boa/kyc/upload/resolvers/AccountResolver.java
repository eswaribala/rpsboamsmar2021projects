package com.boa.kyc.upload.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.kyc.upload.models.Account;
import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.services.AccountService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class AccountResolver implements GraphQLQueryResolver{
   @Autowired
	private AccountService accountService;
   
   public List<Account> findAccounts(){
		return this.accountService.getAllAccounts();
	}
	

	public Account findAccount(long accountNo){
		return this.accountService.getAccountById(accountNo);
	}
	
}
