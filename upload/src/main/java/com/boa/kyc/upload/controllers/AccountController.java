package com.boa.kyc.upload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.upload.models.Account;
import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.services.AccountService;
import com.boa.kyc.upload.services.CustomerService;
@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	//add adharcard
		@PostMapping({"/v1.0/{customerId}", "/v1.1/{customerId}"})
		public ResponseEntity<?> addAccount(@RequestBody Account account, @PathVariable("customerId") long customerId )
		{
			Account accountObj=this.accountService.createAccount(account,customerId);
			if(accountObj!=null)
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountObj);
				
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account not created validate the input");
			
			
		}
		
		@GetMapping({"/v1.0", "/v1.1"})
		public List<Account> getAllAccounts()
		{
			return this.accountService.getAllAccounts();
		}
}
