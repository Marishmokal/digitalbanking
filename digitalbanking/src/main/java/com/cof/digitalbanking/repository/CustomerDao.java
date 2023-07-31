package com.cof.digitalbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cof.digitalbanking.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
	
}
