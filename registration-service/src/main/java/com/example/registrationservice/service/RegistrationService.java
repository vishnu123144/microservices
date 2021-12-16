package com.example.registrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registrationservice.model.Customer;
import com.example.registrationservice.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	
	public Customer registerCustomer(Customer customer)
	{
		return repository.save(customer);
	}
	
	public Customer getUsernameAndPassword(String username,String password)
	{
		return repository.findByUsernameAndPassword(username, password);
	}
	
	 

}
