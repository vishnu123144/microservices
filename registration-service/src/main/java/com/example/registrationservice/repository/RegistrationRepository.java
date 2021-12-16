package com.example.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registrationservice.model.Customer;

@Repository
public interface RegistrationRepository extends JpaRepository<Customer,Integer> {

	Customer findByUsernameAndPassword(String username,String password);
	//@query method
	//select * from customer where username=name and password=password
	
	//@Query("selecy cus * from customer where cus.username=?

	
}
