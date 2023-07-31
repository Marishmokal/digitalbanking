package com.cof.digitalbanking.testservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cof.digitalbanking.model.Customer;
import com.cof.digitalbanking.repository.CustomerDao;
import com.cof.digitalbanking.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceImplTest {
	
	@Mock
	private CustomerDao customerDao;
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	
	@BeforeEach
	void setUp()
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testgetCustomer()
	{
		when(customerDao.findAll()).thenReturn(Stream.of(new Customer(376,"akbar",77885566,"akbar@gmail.com"),new Customer(958,"birbal",22336655,"birbal@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,customerService.getAllCustomer().size());
	}
	
	@Test
	public void testCreateCustomer()
	{
		Customer customer=new Customer(5,"Pranaya",123654587,"Naga@gmail.com");
		when(customerDao.save(customer)).thenReturn(customer);
		assertEquals(customer,customerService.createCustomer(customer));
	}
	
	@Test 
	public void testDeleteCustomer()
	{
		Customer customer=new Customer(5,"Pranaya",123654587,"Naga@gmail.com");
		customerService.deleteCustomerById(customer);
		verify(customerDao,times(1)).delete(customer);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer customer=new Customer(6,"Daniel",563214796,"danial@gmail.com");
		when(customerDao.save(customer)).thenReturn(customer);
		assertThat(customerDao).isNotEqualTo(customer);
	}
}
