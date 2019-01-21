package com.cg.jcat.api.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationDao {
	@Autowired
	private ApplicationDao applicationdao;

	@Test
	public void testgetApplication() {
		fail("Not yet implemented");
	}

}
