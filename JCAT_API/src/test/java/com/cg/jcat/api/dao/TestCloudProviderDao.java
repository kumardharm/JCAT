package com.cg.jcat.api.dao;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestCloudProviderDao {
	
	@Autowired
	private DTCloudProviderRuleDao cloudProviderDao;

	@Test
	 public void testGetCloudProvider()
	 {
		 assertEquals(0,cloudProviderDao.getCloudProvider().size());
	 }
	
}
