package com.vignesh.jpa_pg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest create entire spring context - controllers,services,repositories etc
class JpaApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

//	@Test
	void contextLoads() {
	}

	@Test
	public void testCustomerController() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:" + port+"/customers", List.class);
		Assertions.assertEquals(1445,responseEntity.getBody().size());
	}


}
