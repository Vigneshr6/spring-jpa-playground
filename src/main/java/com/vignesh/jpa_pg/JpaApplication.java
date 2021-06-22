package com.vignesh.jpa_pg;

import com.vignesh.jpa_pg.model.Customer;
import com.vignesh.jpa_pg.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
		log.debug("main code called");
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Customer> all = customerRepository.findAll();
//		log.debug("customer : {}",customer);
		all.forEach(System.out::println);
	}
}
