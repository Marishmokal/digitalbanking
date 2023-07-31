package com.cof.digitalbanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cof.digitalbanking.exception.CustomerNotFoundException;
import com.cof.digitalbanking.exception.InvalidDetailsException;
import com.cof.digitalbanking.model.Customer;
import com.cof.digitalbanking.repository.CustomerDao;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerDao.save(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
	
		return customerDao.findById(id).orElseThrow(()->new CustomerNotFoundException("No customer Present="+id));
		
	}

	@Override
	public void deleteCustomerById(int id) {
	
		 customerDao.deleteById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer c= customerDao.save(customer);
		if(c.getName().isEmpty()&& c.getEmail().isEmpty() || c.getMobileNo()==0)
		{
			throw new InvalidDetailsException("Invalid Details");
		}
		return c;
	}

	@Override
	public List<Customer> getAllCustomer() {
				return customerDao.findAll();
	}

	public void deleteCustomerById(Customer customer) {
		customerDao.delete(customer);
		
	}

}
