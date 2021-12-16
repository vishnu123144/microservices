package com.example.registrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationservice.model.Customer;
import com.example.registrationservice.service.RegistrationService;

@RestController
@RequestMapping(path="/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;

	@GetMapping("/register")
	//@ResponseStatus(code=HttpStatus.OK,reason="Trail Page")
	public String getRegistrationHomePage()
	{
		return "welcome to Registration  page";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomerDetails(@RequestBody Customer customer)
	{
		Customer registerCustomer=service.registerCustomer(customer);
		if(registerCustomer!=null)
		{
			return "Data saved successfully with id"+registerCustomer.getId();
		}
		return "No Details saved.Check your data";
	}
	
	@GetMapping("find/{username}/{password}")
	public String getCustomerByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password) {
		        Customer   findCustomer=service.getUsernameAndPassword(username, password);
		        if(findCustomer!=null)
		        {
		        	return "log in successfully"+findCustomer.getId();
		        }
		        return "Invalid username or password";
	}
 	
	
	
	
}
