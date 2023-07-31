package com.cof.digitalbanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cof.digitalbanking.model.Customer;
import com.cof.digitalbanking.service.CustomerService;



@RestController
@RequestMapping("/v2")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerService.createCustomer(customer);	
	}
	
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id")int id)
	{
		return customerService.getCustomerById(id);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable("id")int id)
	{
		 customerService.deleteCustomerById(id);
		
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
		
	}
	
	@GetMapping
	public List<Customer> GetAllCustomer()
	{
		return customerService.getAllCustomer();
		
	}
}
