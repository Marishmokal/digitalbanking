package com.cof.digitalbanking;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigitalbankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalbankingApplication.class, args);
	}
	
	@Bean
	public DozerBeanMapper mapper()
	{
		return new DozerBeanMapper();
	}

}
