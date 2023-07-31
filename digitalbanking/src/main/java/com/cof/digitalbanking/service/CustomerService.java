package com.cof.digitalbanking.service;

import java.util.List;

import com.cof.digitalbanking.model.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	Customer getCustomerById(int id);

	void deleteCustomerById(int id);

	Customer updateCustomer(Customer customer);

	List<Customer> getAllCustomer();

	

}
